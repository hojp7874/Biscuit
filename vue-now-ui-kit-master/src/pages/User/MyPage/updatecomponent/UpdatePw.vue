<template>
    <div>
            <fg-input
              type="password"
              style="margin-top: 10px;width:300px"
              placeholder="현재 비밀번호를 입력하세요"
              v-model="mem.password"
            />

            <fg-input
              type="password"
              style="margin-top: 15px;width:300px"
              placeholder="새 비밀번호를 입력하세요"
              v-model="mem.newpassword"
            />

            <fg-input
              type="password"
              style="margin-top: 15px; margin-bottom: 15px; width:300px"
              placeholder="새 비밀번호를 한 번 더 입력하세요"
              v-model="verify_newpassword"
            />
            
            <n-button type="primary"  @click="cancel()" style="border-radius: 10rem;">변경취소</n-button>
            &nbsp;
            <n-button type="primary" @click="updatePw();" style="border-radius: 10rem;">확인</n-button>
    </div>
</template>
<script>
import axios from 'axios';
import { Button, FormGroupInput } from '@/components';
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
  components: {
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
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