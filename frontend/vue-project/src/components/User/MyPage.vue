// main.js에 모달관련 import함
<template v-slot:content>
  <div class="text-center memjoin_cnt">
    <div>
      <span style="font-size: x-large">회원 정보 수정</span>
      <del-popup style=  "margin-left:720px" v-on:logout="logout()"/>
    </div>
    <div id="user_info">
      <p style="font-size: large">로그인 정보</p>
      <div id="login_info">
        <span> 아이디(이메일) </span>
        <p>{{ user.email }}</p>
        <br />
        <span> 비밀번호 </span>
        <p id="fakePw" v-if="!show">········</p>
        <UpdatePw v-if="show" v-on:cancel="cancel()" />
        <button id="update_btn" @click.prevent="show_update_pw()" v-if="!show">
          변경
        </button>
      </div>
      <br><br>
    </div>
    <br /><br />
    <div>
      <p style="font-size: large">회원 정보</p>
      <div id="member_info">
        <div class="inpbx" style="font-size: large">
          <span style="margin-right :28px">닉네임</span>
          <input
            type="text"
            id="user-id"
            placeholder="닉네임"
            style="margin-left : 30px"
            v-model="user.nickname"
          /><br />
          <span style="margin-right : 20px">휴대폰 번호</span>
          <input
            type="text"
            id="user-id"
            placeholder="휴대폰 번호"
            v-model="user.phone"
          /><br />
          <span style="margin-right :55px">사는 곳</span>
          <input
            type="text"
            id="user-id"
            placeholder="사는 곳"
            v-model="user.region"
          /><br />
        </div>
      </div>
    </div>

    <br /><br />
    <div>
      <button
        class="btn btn-primary"
        id="complete_btn"
        @click.prevent="update()"
      >
        완료
      </button>
    </div>
  </div>
  
</template>

<script>
import DelPopup from './updatecomponent/DelPopup.vue';
import UpdatePw from './updatecomponent/UpdatePw.vue';
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_LOCAL_SERVER_URL;

export default {
  data() {
    return {
      show: false,
      visible: false,
      user: {
        email: '',
        nickname: '',
        picture:'',
        region: '',
        phone: '',
      },
    };
  },
  methods: {

    show_update_pw() {
      this.show = true;
    },

    cancel() {
      this.show = false;
    },

    update() {
      console.log("토큰 : " + localStorage.getItem('token'));
      axios
        .put(`${SERVER_URL}/user/update`, this.user, {
          headers: {
            "x-access-token": localStorage.getItem('token'),
          },
        })
        .then((response) => {
          if (response.data.success === 'success') {
            console.log(this.user.region);
            alert('정보 수정에 성공하셨습니다.');
            localStorage.setItem('region', this.user.region);
            localStorage.setItem('nickname', this.user.nickname);
            localStorage.setItem('phone', this.user.phone);
            this.$router.push('/');
          } else alert('정보 수정에 실패하셨습니다.');
        })
        .catch(function(error) {
          console.log(error);
        });
    },

    handleClickButton() {
      this.visible = !this.visible;
    },
    logout(){
      console.log("로그아웃입니다");
      this.$router.push('/');
      window.location.reload();
    }
  },
  components: {
    UpdatePw,DelPopup
  },

  created() {
    this.user.region = localStorage.getItem('region');
    this.user.email = localStorage.getItem('email');
    this.user.nickname = localStorage.getItem('nickname');
    this.user.phone = localStorage.getItem('phone');
  },
};
</script>

<style>
#user_info {
  padding-top: 18px;
  border-top: 4px solid #000;
  border-top-width: 4px;
  border-top-style: solid;
  border-top-color: rgb(0, 0, 0);
  width: 800px;
  margin: 0 auto;
}

#login_info,
#member_info {
  margin: 0 auto;
  font-size: 18px;
  width: 600px;
  text-align: center;
  padding-top: 18px;
  border-top: 4px solid #000;
  border-top-width: 2px;
  border-top-style: solid;
  border-top-color: rgb(172, 159, 159);
}

#update_btn,
#cancel_btn,
#confirm_btn {
  margin: 0 auto;
  width: 70px;
  height: 30px;
  background: rgb(245, 245, 245);
  border-radius: 2px;
  color: rgb(32, 23, 23);
  font-size: 16px;
  font-weight: 600;
}

#complete_btn {
  width: 100px;
  height: 45px;
  background: #000;
  border-radius: 2px;
  color: #fff;
  font-size: 16px;
  font-weight: 600;
  text-align: center;
  margin: 12px 0 10px;
}
</style>
