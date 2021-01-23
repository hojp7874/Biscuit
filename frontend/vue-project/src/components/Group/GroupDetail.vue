<template>
  <div>
    <h1>그룹 상세보기</h1>
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
  </div>
</template>

<script>
  import axios from 'axios'
  const SERVER_URL = process.env.VUE_APP_SERVER_URL


  export default {
    data() {
      return {
        params: {
          type: 'gId',
          word: this.$route.query.gId,
        },
        group: Object
      }
    },
    methods: {
      updateGroup: function(gId) {
        this.$router.push({path: './GroupUpdate', query: { gId: gId}})
      },
      deleteGroup: function(gId) {
        console.log(gId)
        axios.delete(`http://localhost:8877/a407/group/delete/`, {headers: {gId: gId}})
          .then(res => {
            console.log(res)
          })
          .catch(err => {
            console.log(err)
          })
      },
      onSubmit: function() {
        // 일단 로그인여부는 구현 ㄴ
        // const item = {
        //   max: this.form.max,
        //   edate: this.form.edate,
        //   email: "ssafy@ssafy.com",
        //   groupName: this.form.groupName,
        //   groupDesc: this.form.groupDesc,
        //   category: this.form.category,
        //   region: this.form.region,
        //   img: "null"
        // }
        // const data = [item]
        // axios.post(`http://localhost:8877/a407/group/create/`, item)
        //   .then(res => {
        //     console.log(res)
        //   })
        //   .catch(err => {
        //     console.log(err)
        //   })
      }
    },
    created: function () {
      console.log(SERVER_URL)
      axios.get(`http://localhost:8877/a407/group/list/`, {params: this.params})
        .then(res => {
          console.log(res.data.list[0])
          this.group = res.data.list[0]
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
</script>

<style scoped>
</style>
