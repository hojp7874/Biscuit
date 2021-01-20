<template>
  <div id="app" class="container login-wrap col-md-3 col-md-offset-4">
    <h2 class="login_title">로그인</h2>
    <div class="text-center login_cnt">
      <form>
        <input
          v-bind:class="{ inputform: true }"
          v-model="id"
          placeholder="아이디 (이메일)"
        /><br />
        <input
          v-bind:class="{ inputform: true }"
          v-model="password"
          placeholder="비밀번호"
        />
        <div>
          <button class="btn btn-primary" id="login_btn" @click="login">
            로그인하기
          </button>
        </div>
      </form>
      <div class="sns_login">
        <p>SNS 계정으로 로그인하기</p>
        <ul>
          <button type="button" class="btm_image" id="img_btn">
            <img
              class="btm_image"
              src="../../assets/img/naver.png"
              alt="naver"
            />
          </button>

          <button type="button" class="btm_image" id="img_btn">
            <img
              class="btm_image"
              src="../../assets/img/kakao.png"
              alt="kakao"
            />
          </button>

          <button type="button" class="btm_image" id="img_btn">
            <img
              class="btm_image"
              src="../../assets/img/facebook.png"
              alt="facebook"
            />
          </button>

          <button type="button" class="btm_image" id="img_btn">
            <img
              class="btm_image"
              src="../../assets/img/apple.png"
              alt="apple"
            />
          </button>
        </ul>
      </div>

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
import '../../assets/css/user.scss';
import constants from '../../lib/constants';

export default {
  el: '#app',
  data: {
    id: '',
    password: '',
  },

  methods: {
    login() {
      location.href = './main.html';
    },
  },
};
</script>

<style>
.login_title {
  width: 50%;
  margin-bottom: 34px;
  font-weight: 600;
  font-size: 44px;
  text-align: center;
}

.find_password {
  color: #5d5d5d;
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
}

#login_btn {
  width: 100%;
  height: 45px;
  background: #000;
  border-radius: 2px;
  color: #fff;
  font-size: 16px;
  text-align: center;
  margin: 12px 0 10px;
}

.inputform {
  width: 100%;
  height: 40px;
  margin-bottom: 10px;
}

.sns_login {
  margin: 25px 0 80px;
}

.findpw {
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
}

.btm_image {
  width: 60px;
  height: 60px;
  background-color: white;
  margin-right: 16px;
  border: none;
  vertical-align: top;
}
</style>
