<template>
  <div>
    <div class="page-header clear-filter" filter-color="orange">
      <parallax
        class="page-header-image"
        style="background-image:url('img/bg11.jpg')"
      >
      </parallax>
      <div class="container">
        <h1 class="m-5">스터디 생성</h1>
        <b-form @submit.prevent="onSubmit">
          <div class="d-flex">
            <p class="col-3">스터디 이름:</p>
            <fg-input
              class="no-border input-lg col-9"
              id="input-1"
              v-model="form.groupName"
              placeholder="스터디그룹 이름을 작명해주세요."
              required
            ></fg-input>
          </div>

          <div class="d-flex">
            <p class="col-3">스터디 인원제한:</p>
            <fg-input
              class="no-border input-lg col-9"
              id="input-2"
              v-model="form.max"
              placeholder="스터디 인원제한을 설정해주세요."
              required
            ></fg-input>
          </div>

          <div class="d-flex">
            <p class="col-3">지역:</p>
            <fg-input
              class="no-border input-lg col-9"
              id="input-3"
              v-model="form.region"
              :options="region"
              required
            ></fg-input>
          </div>

          <div class="d-flex">
            <p class="col-3">카테고리:</p>
            <div class="col-9">
              <b-form-radio-group v-model="form.category" :options="options" name="radio-validation">
                <b-form-invalid-feedback>Please select one</b-form-invalid-feedback>
              </b-form-radio-group>
            </div>
          </div>

          <div class="d-flex">
            <p class="col-3">스터디원 모집 종료일:</p>
            <div class="col-9">
              <!-- <n-switch
                v-model="form.onoff"
                style="width:500px"
                on-text="ON"
                off-text="OFF"
              ></n-switch> -->
                <input class="col-8 no-border" v-model="form.edate" type="date" name="" id="">
            </div>
          </div>

          <div>
            <p class="col-3">스터디 이미지:</p>
            <div class="col-9">
              <input type="file" id="img">
            </div>
          </div>

          <div class="d-flex">
            <p class="col-3">스터디 설명:</p>
            <b-form-textarea
              id="input-6"
              v-model="form.groupDesc"
              placeholder="스터디그룹에 대해 설명해주세요."
              class="col-9"
              style="height: 500px"
            ></b-form-textarea>
          </div>

          <b-button type="submit" variant="primary">Submit</b-button>
        </b-form>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  import {Switch, Button, Radio, FormGroupInput}from '@/components'
  const SERVER_URL = process.env.VUE_APP_SERVER_URL;

  export default {
    data() {
      return {
        options: [
          { text: '한국사', value: '한국사' },
          { text: '프로그래머', value: '프로그래머' },
          { text: '농부', value: '농부' },
          { text: '어부', value: '어부' },
          { text: '광부', value: '광부' }
        ],
        form: {
          max: '',
          edate: '',
          email: '',
          nickname: '',
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
    components: {
      [Button.name]: Button,
      [Radio.name]: Radio,
      [FormGroupInput.name]: FormGroupInput,
      [Switch.name]: Switch,
      [Option.name]: Option,
    },
    methods: {
      onSubmit: function() {
        const item = {
          max: this.form.max,
          edate: this.form.edate,
          email: localStorage.getItem("email"),
          nickname: localStorage.getItem("nickname"),
          groupName: this.form.groupName,
          groupDesc: this.form.groupDesc,
          category: this.form.category,
          region: this.form.region
        }
        const frm = new FormData()
        var img = document.getElementById("img")
        if (img.files.length != 0) {
          frm.append('file', img.files[0])
          axios.post(`${SERVER_URL}/file/upload/`, frm)
            .then(res => {
              console.log(res.data.message)
              // item.push({img: SERVER_URL + "/file/read/" + res.data.message})
              item["img"] = SERVER_URL + "/file/read/" + res.data.message
              
              // DB에 저장
              axios.post(`${SERVER_URL}/group/create/`, item)
                .then(res => {
                  console.log(res)
                  this.$router.push({ path: './grouplist'});
                })
                .catch(err => {
                  console.log(err)
                })
            .catch(err => {
              console.log(err)
            })
          })
        } else {
          // DB에 저장
          axios.post(`${SERVER_URL}/group/create/`, item)
            .then(res => {
              console.log(res)
              this.$router.push({ path: './grouplist'});
            })
            .catch(err => {
              console.log(err)
            })
        }
      }
    }
  }
</script>

<style scoped>
</style>
