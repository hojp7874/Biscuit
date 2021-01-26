<template>
  <div style="text-align:center">
    <h2 class="login_title">로그인</h2>
    <div class="text-center login_cnt">
      <form>
        <input
        v-bind:class="{ inputform: true }"
          id="email"
          ref="email"
          v-model="user.email"
          required
          placeholder="아이디(이메일)"
        /><br />
        <input
        v-bind:class="{ inputform: true }"
          type="password"
          id="password"
          ref="password"
          v-model="user.password"
          required
          placeholder="비밀번호"
          @keypress.enter="checkLogin"
          style="margin-bottom:15px"
        />
        <div>
          <button block
              pill
              type="button"
              variant="primary"
              class="m-1"
              @click="checkLogin"
              id="login_btn"
              style="margin-bottom:10px">
            로그인하기
          </button>
        </div>
      </form>
      

      <router-link to="./join" id="sign"
        >계정이 없으신가요? 가입하기</router-link
      >
      <div class="findpw">
        <router-link to="./findPw" id="find_password"
          >비밀번호 찾기</router-link
        >
      </div>
    </div>
  </div>
</template>

<script>
import Vue from 'vue';
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import axios from 'axios';
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
          localStorage.setItem('email', response.data.user.email);
          localStorage.setItem('nickname', response.data.user.nickname);
          localStorage.setItem('admin', response.data.user.admin);
          localStorage.setItem('phone', response.data.user.phone);
          localStorage.setItem('region', response.data.user.region);
          // localStorage.setItem('admin', response.data.admin);
          this.$router.replace(`/`);
        })
        .catch(function(error) {
          alert("아이디 혹은 비밀번호를 다시 확인 해 주세요");
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
.login_title {
  margin-bottom: 34px;
  /* margin-left: 23px; */
  font-weight: 600;
  font-size: 44px;
  text-align: center;
}

#find_password {
  color: #5d5d5d;
  font-size: 13px;
}

.login_wrap {
  width: 100%;
}

.login_cnt {
  padding-top: 18px;
  border-top: 4px solid #000;
  border-top-width: 4px;
  border-top-style: solid;
  border-top-color: rgb(0, 0, 0);
  width:27% ;
  margin: 0px auto;
  
}

#sign {
  display: block;
  height: 56px;
  border: 1px solid #5d5d5d;
  border-radius: 28px;
  box-sizing: border-box;
  font-weight: 600;
  font-size: 14px;
  color: #1d1d1d;
  text-align: center;
  line-height: 56px;
  margin-top:30px
}

#login_btn {
  width: 100%;
  height: 60px;
  background: #000;
  border-radius: 2px;
  color: #fff;
  font-size: 16px;
  text-align: center;
  margin: 12px 0 10px;
}

.inputform {
  width: 100%;
  height: 50px;
  margin-top: 10px;
}

.findpw {
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}

</style>
