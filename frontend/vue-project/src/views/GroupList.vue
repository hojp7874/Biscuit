<template>
  <div>
    <b-card-group deck>
      <b-card title="Title" img-src="https://picsum.photos/300/300/?image=41" img-alt="Image" img-top>
        <b-card-text>
          This is a wider card with supporting text below as a natural lead-in to additional content.
          This content is a little bit longer.
        </b-card-text>
        <template #footer>
          <small class="text-muted">Last updated 3 mins ago</small>
        </template>
      </b-card>

      <b-card title="Title" img-src="https://picsum.photos/300/300/?image=41" img-alt="Image" img-top>
        <b-card-text>
          This card has supporting text below as a natural lead-in to additional content.
        </b-card-text>
        <template #footer>
          <small class="text-muted">Last updated 3 mins ago</small>
        </template>
      </b-card>

      <b-card title="Title" img-src="https://picsum.photos/300/300/?image=41" img-alt="Image" img-top>
        <b-card-text>
          This is a wider card with supporting text below as a natural lead-in to additional content.
          This card has even longer content than the first to show that equal height action.
        </b-card-text>
        <template #footer>
          <small class="text-muted">Last updated 3 mins ago</small>
        </template>
      </b-card>
    </b-card-group>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    data() {
      return {
        form: {
          max: '',
          edate: '',
          email: '',
          groupName: '',
          groupDesc: '',
          category: '',
          region: '',
          onoff: ''
        },
        region:[{text:'지역을 선택해주세요.',value:null},'온라인','서울','대전','광주','구미'],
        category:[{text:'카테고리를 선택해주세요.',value:null},'한국사','프로그래머','농부','어부','광부']
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
    }
  }
</script>

<style scoped>
</style>
