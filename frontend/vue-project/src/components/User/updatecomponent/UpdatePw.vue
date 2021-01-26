<template>
    <div>
            <input
              type="password"
              style="margin-top: 10px;"
              placeholder="현재 비밀번호를 입력하세요"
              v-model="mem.password"
            />
            <br />
            <input
              type="password"
              style="margin-top: 15px;"
              placeholder="새 비밀번호를 입력하세요"
              v-model="mem.newpassword"
            />
            <br />
            <input
              type="password"
              style="margin-top: 15px; margin-bottom: 15px;"
              placeholder="새 비밀번호를 한 번 더 입력하세요"
              v-model="verify_newpassword"
            />
            <br />
            <button id="cancel_btn" @click="cancel()">변경취소</button>
            &nbsp;
            <button id="confirm_btn" @click="updatePw();">확인</button>
    </div>
</template>
<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_LOCAL_SERVER_URL;

export default {

  data() {
    return {
      mem : {
        password:'',
        newpassword:'',
        email:''
      },

      verify_newpassword:''
    };
  },

    methods: {

      cancel(){
        this.$emit('cancel');
      },

      updatePw(){
        axios
        .put(`${SERVER_URL}/user/pwupdate`,  this.mem,{
          headers:{
            "x-access-token" : localStorage.getItem("token")
          }
        })
        .then((response) => {
          if (response.data.success === 'success') {
            alert('변경 완료되었습니다');
            this.isHidden = true;
            this.cancel();
          }else{
            alert('현재 비밀번호를 다시 한 번 확인 해 주세요!');
          }
        }).catch(function(error) {
          console.log(error);
          alert('오류');
        });

      }
    },
    mounted(){
      this.mem.email = localStorage.getItem("email");
    }
}
</script>

<style>

</style>