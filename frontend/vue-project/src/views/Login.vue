<template>
  <b-container fluid class="bgImg">
    <Header/>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card
          border-variant="secondary"
          class="mt-3"
          header="로그인"
          style="max-width: 40rem;"
          align="left"
        >
          <b-form bg-variant="light">
            <b-form-group label="이메일" label-for="email">
              <b-form-input
                id="email"
                ref="email"
                v-model="user.email"
                required
                placeholder="아이디(이메일)"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호" label-for="password">
              <b-form-input
                type="password"
                id="password"
                ref="password"
                v-model="user.password"
                required
                placeholder="비밀번호"
                @keypress.enter="checkLogin"
              ></b-form-input>
            </b-form-group>
            <b-button
              block
              pill
              type="button"
              variant="primary"
              class="m-1"
              @click="checkLogin"
              >로그인</b-button
            >
            <b-button
              type="button"
              block
              pill
              variant="success"
              class="m-1"
              @click="signup"
              >회원가입</b-button
            >
            <b-button variant="link" @click="findId">ID찾기</b-button>
            <b-button variant="link" @click="findPw">비밀번호찾기</b-button>
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import Vue from 'vue';
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import axios from 'axios';
import Header from '../components/Header'; //import 헤더 추가
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

// const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  name: 'Login',
  data: function() {
    return {
      //   isLogin: false,
      user: {
        email: '',
        password: '',
      },
      message: '',
    };
  },
  components: {Header},
  created() {
    // if (localStorage.getItem('token') !== null) this.$router.replace(`/`);
  },
  methods: {
    checkLogin() {
      let err = true;
      let msg = '';

      !this.user.email &&
        ((msg = '아이디를 입력해주세요'), (err = false), this.$refs.id.focus());
      err &&
        !this.user.password &&
        ((msg = '비밀번호를 입력해주세요'),
        (err = false),
        this.$refs.password.focus());

      if (!err) alert(msg);
      else this.login();
    },
    login: function() {
      // LOGIN 액션 실행
      // 서버와 통신(axios)을 해 토큰값을 얻어야 하므로 Actions를 호출.
      axios
        .post(`http://localhost:8877/a407/user/login`, this.user)
        .then((response) => {
          localStorage.setItem('token', response.data['x-access-token']);
          localStorage.setItem('email', response.data.email);
          localStorage.setItem('name', response.data.name);
          localStorage.setItem('admin', response.data.admin);
          //   this.isLogin = true;
          // axios.defaults.headers.common[
          //   'x-access-token'
          // ] = `${response.data['x-access-token']}`;
          this.$router.replace(`/`);
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    signup: function() {
      this.$router.push('/signup');
    },
    findId: function() {
      this.$router.push('/findid');
    },
    findPw: function() {
      this.$router.push('/findpw');
    },
  },
};
</script>

<style>
#login-div {
  text-align: center;
}

</style>
