<template>
  <div class="container">
    <b-button variant="primary" @click="goCreate">그룹생성</b-button>
    <b-card-group
      deck
      class="d-flex flex-row"
    >
      <b-col cols="3"
        v-for="(group, idx) in groups"
        :key="idx"
        :group="group"
      >
        <!-- @click="goDetail(group)" -->
          <!-- v-b-modal.group-13 -->
        <b-card
          @click="$bvModal.show(`group-${idx}`)"
          v-bind:title="group.groupName"
          img-src="https://picsum.photos/300/300/?image=41"
          img-alt="Image"
          img-top
        >
          <b-card-text>
            {{group.groupDesc}}
          </b-card-text>
          <template #footer>
            <small class="text-muted">Last updated 3 mins ago</small>
          </template>
        </b-card>
        <b-modal
          :id="'group-'+idx"
          size="xl"
          :title="''+group.groupName"
        >
          {{group.groupDesc}}
          <div>
            <b-jumbotron bg-variant="info" text-variant="white" border-variant="dark">
              <template #header>{{ group.groupName }}</template>
              <b-button pill variant="primary">그룹 참가하기</b-button>

              <template #lead>
                <img src="" alt="">
                <p>모집인원: {{ group.max }}명</p>
                <p>온라인 여부: {{ group.onoff }}</p>
                <p>모집기간: {{ group.edate }}</p>
                <p>지역: {{ group.region }}</p>
                <p>스터디 주기: {{ group.cycle }}</p>
              </template>

              <hr class="my-4">

              <p>
                <!-- {{ group }} -->
                {{ group.groupDesc }}
              </p>
              <form action="" method="post" @submit.prevent="updateGroup(group.gId)">
                <b-button type="submit" pill variant="warning">그룹 정보 수정하기</b-button>
              </form>
              <form action="" method="post" @submit.prevent="deleteGroup(group.gId)">
                <b-button type="submit" pill variant="danger">그룹 삭제하기</b-button>
              </form>
            </b-jumbotron>
          </div>
        </b-modal>
      </b-col>
    </b-card-group>
  </div>
</template>

<script>
  import axios from 'axios'
  const SERVER_URL = process.env.VUE_APP_SERVER_URL


  export default {
    data() {
      return {
        params: {
          type: '',
          word: '',
        },
        groups: Object
      }
    },
    methods: {
      goCreate: function() {
        // const data = [item]
        this.$router.push({path: './GroupCreate'})
      },
      goDetail: function(group) {
        this.$router.push({path: './GroupDetail', query: {gId: group.gId}})
      },
      updateGroup: function(gId) {
        this.$router.push({path: './GroupUpdate', query: { gId: gId}})
      },
      deleteGroup: function(gId) {
        console.log(gId)
        axios.delete(`${SERVER_URL}/group/delete/`, {headers: {gId: gId}})
          .then(res => {
            console.log(res)
          })
          .catch(err => {
            console.log(err)
          })
      }
    },
    created: function () {
      axios.get(`${SERVER_URL}/group/list/`, {params: this.params})
        .then(res => {
          console.log(res.data.list[0])
          this.groups = res.data.list
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
</script>

<style scoped>
</style>
