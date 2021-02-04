<template>
  <div>
    <div>
      <center style="font-size: 30px; margin-top:30px">개인 정보 수정</center>
      <del-popup style="margin-left:950px ; margin-top:20px" v-on:logout="logout()" />
    </div>
    <div id="all_info" style="margin-left:80px">
    <div id="user_info">
      <div id="login_info">
        <span style="margin-left: 80px ;font-size: 30px"> 아이디(이메일) </span>
        <span style="margin-left: 100px ; font-size: 30px">{{
          user.email
        }}</span>
        <br /><br /><br />
        <span style="margin-left:156px ;font-size: 30px "> 비밀번호 </span>
        <span
          id="fakePw"
          v-if="!show"
          style="margin-left: 100px ; font-size: 30px"
          >********</span
        >
        <UpdatePw
          v-if="show"
          v-on:cancel="cancel()"
          style="margin-left:390px;margin-top:-50px;"
        />
        <n-button
          type="primary"
          @click.prevent="show_update_pw()"
          style="margin-left: 40px ;margin-top:-17px;font-size:0.5rem;border-radius: 10rem"
          v-if="!show"
        >
          변경
        </n-button>
      </div>
    </div>
    <div>
      <div style="margin-top:35px">
        <div class="inpbx" style="font-size: large">
          <span style="margin-left:185px ;font-size: 30px ;"> 닉네임 </span>
          <fg-input
            placeholder="닉네임"
            style="margin-left : 370px ; margin-top:-44px;width : 300px"
            v-model="user.nickname"
          />
          <br />
          <div></div>
          <span style="margin-left:120px ;font-size: 30px ;">
            휴대폰 번호
          </span>
          <fg-input
            style="margin-left : 370px ; margin-top:-44px;width : 300px"
            placeholder="휴대폰 번호"
            v-model="user.phone"
          /><br />

          <div style="margin-top:-10px">
            <span style="margin-left:180px ;font-size: 30px ;"> 사는 곳 </span>
            <fg-input
              placeholder=""
              v-model="user.region"
              style="margin-top:-44px ;margin-left : 370px ; width :450px"
            />
            <n-button
              type="primary"
              v-b-modal.modal-2
              style="margin-left: 850px ;margin-top:-85px;font-size:0.5rem;border-radius: 10rem"
              >주소찾기</n-button
            >
            <br />
            <div>
              <b-modal
                ref="addr-modal"
                id="modal-2"
                title="주소 찾기"
                hide-footer
              >
                <FindPostCode @setAddress="setAddress" />
              </b-modal>
            </div>
            <!-- <input
            type="text"
            id="user-address"
            placeholder=""
            v-model="region_detail"
            style="margin-top:20px " 
          /> -->
          </div>

          <br />
        </div>
      </div>
    </div>
    </div>

    <center style="margin-top :-30px">
      <n-button
        type="primary"
        @click.prevent="update()"
        style="border-radius: 10rem; width :150px"
      >
        수정
      </n-button>
    </center>
  </div>
</template>

<script>
import { Button, FormGroupInput } from '@/components';
import DelPopup from './updatecomponent/DelPopup.vue';
import UpdatePw from './updatecomponent/UpdatePw.vue';
import FindPostCode from '../FindPostCode';
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      show: false,
      visible: false,
      user: {
        email: '',
        nickname: '',
        picture: '',
        region: '',
        phone: '',
      },
    };
  },
  // components: {
  //   [Button.name]: Button,
  //   FgInput
  // },
  methods: {
    show_update_pw() {
      this.show = true;
    },

    cancel() {
      this.show = false;
    },

    update() {
      console.log('토큰 : ' + localStorage.getItem('token'));
      axios
        .put(`${SERVER_URL}/user/update`, this.user, {
          headers: {
            'x-access-token': localStorage.getItem('token'),
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
    logout() {
      console.log('로그아웃입니다');
      this.$router.push('/');
      window.location.reload();
    },
    setAddress(data) {
      this.user.region = data;
      console.log(this.user.region);
      this.hideModal();
    },
    hideModal() {
      this.$refs['addr-modal'].hide();
    },
  },
  components: {
    UpdatePw,
    DelPopup,
    FindPostCode,
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
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
#login_info,
#member_info {
  /* margin: 0 auto; */
  margin-top: 40px;
  /* font-size: 18px; */
  /* width: 600px; */
  /* text-align: center; */
  /* padding-top: 18px; */
  /* border-top: 4px solid #000; */
  /* border-top-width: 2px; */
  /* border-top-style: solid; */
  /* border-top-color: rgb(172, 159, 159); */
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

#user-address {
  width: 500px;
  height: 45px;
}

.memupdate {
  margin-right: 20px;
}
</style>
