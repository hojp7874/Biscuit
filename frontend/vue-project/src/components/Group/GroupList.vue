<template>
  <div>
    <h1>그룹 목록</h1>
    <b-card-group
      deck
      class="d-flex flex-row"
    >
      <b-col cols="3"
        v-for="group in groups"
        :key="group"
        :group="group"
      >
        <b-card
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
      onSubmit: function() {
        // 일단 로그인여부는 구현 ㄴ
        const item = {
          max: this.form.max,
          edate: this.form.edate,
          email: "ssafy@ssafy.com",
          groupName: this.form.groupName,
          groupDesc: this.form.groupDesc,
          category: this.form.category,
          region: this.form.region,
          img: "null"
        }
        // const data = [item]
        axios.post(`http://localhost:8877/a407/group/create/`, item)
          .then(res => {
            console.log(res)
          })
          .catch(err => {
            console.log(err)
          })
      }
    },
    mounted: function () {
      console.log(SERVER_URL)
      axios.get(`http://localhost:8877/a407/group/list/`, {params: this.params})
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
