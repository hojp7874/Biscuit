<template>
  <div class="out">
      <Header/>
    <h2>간편가입</h2>

    <vue-slide-bar
      v-model="simpleValue"
      :processStyle="{ backgroundColor: '#35495e' }"
      :lineHeight="5"
      :style="{ width: '500px', margin: 'auto' }"
      :showTooltip="false"
    />
    <br />

    <vueper-slides
      class="in"
      :touchable="false"
      :bullets="false"
      :arrows="false"
      :fixed-height="setSliderHeight()"
      ref="first"
      style="width: 500px; height: 500px; display: inline-block;background-color: white"
    >
      <vueper-slide :key="1">
        <template v-slot:content>
          <div class="text-center memjoin_cnt">
            <form>
              <div>
                <p style=" font-size :x-large">
                  로그인에 사용할<br />
                  아이디를 입력해주세요.
                </p>
              </div>
              <div class="inpbx">
                <input
                  type="text"
                  id="user-id"
                  placeholder="아이디(이메일) 입력"
                  style="width: 300px"
                  v-model="user.email"
                />
                &nbsp;
                <button class="btn btn-primary" id="certinum_btn" @click="sendEmail()" style="width:130px">
                  인증번호 받기
                </button>
                <br />
                <input
                  type="text"
                  id="certinum"
                  placeholder="인증번호를 입력하세요"
                  style="width: 300px"
                />
                &nbsp;
                <button class="btn btn-primary" id="certinum_btn" style="width:130px">
                  확인
                </button>
                <br />
              </div>
            </form>
          </div>
          <div>
            <button
              class="btn btn-primary"
              id="certinum_btn"
              @click="
                $refs.first.next();
                barProceeding();
              "
            >
              다음
            </button>
          </div>
        </template>
      </vueper-slide>
      <vueper-slide :key="2">
        <template v-slot:content>
          <div>
            <div class="text-center memjoin_cnt">
              <form>
                <div>
                  <p style=" font-size :x-large">
                    로그인에 사용할<br />
                    비밀번호를 입력해주세요.
                  </p>
                </div>
                <br /><br />
                <div class="inpbx">
                  <input
                    type="password"
                    id="pw"
                    placeholder="비밀번호 입력"
                    v-model="user.password"
                  />

                  <!-- <div style=" font-size :small" id="english-check">
                    영문포함✓
                  </div> -->
                </div>
                <br />
                <div>
                  <input
                    type="password"
                    id="certipw"
                    placeholder="비밀번호 확인"
                     v-model="pw_certification"
                  />
                  <br />
                </div>
              </form>
            </div>
            <br /><br />
            <button
              class="btn btn-primary"
              id="next_btn"
              @click="
                checkPw();
              "
            >
              다음</button
            >>
          </div>
        </template>
      </vueper-slide>
      <vueper-slide :key="3">
        <template v-slot:content>
          <div class="text-center memjoin_cnt">
            <form>
              <div>
                <p style=" font-size :x-large">
                  기본 정보를 입력해주세요.
                </p>
              </div>
              <br /><br />
              <div class="inpbx" style="font-size :x-large">
                닉네임 : <input type="text" id="user-id" placeholder="닉네임" v-model="user.nickname"/><br>
                지역 : <input type="text" id="user-region" placeholder="지역" v-model="user.region"/><br>
                전화번호 : <input type="text" id="user-phone" placeholder="전화번호" v-model="user.phone" />
              </div>
              <br /><br /><br /><br /><br /><br /><br /><br />
            </form>
          </div>

          <div>
            <button
              class="btn btn-primary"
              id="next_btn"
              @click="
                barProceeding();
                signup();
              "
            >
              회원가입 완료
            </button>
          </div>
        </template>
      </vueper-slide>
    </vueper-slides>
  </div>
</template>

<script>
import Header from '../Header'; //import 헤더 추가
import { VueperSlides, VueperSlide } from 'vueperslides';
import 'vueperslides/dist/vueperslides.css';
import VueSlideBar from 'vue-slide-bar';
import axios from 'axios';
import 'url-search-params-polyfill';

const SERVER_URL = process.env.VUE_APP_LOCAL_SERVER_URL;

export default {
  data() {
    return {
      pw_certification:'',
      searchWindow: {
        display: 'none',
        height: '300px',
      },
      user: {
        email: '',
        password: '',
        nickname: '',
        admin: '',
        region: '',
        phone: '',
      },
      simpleValue: 0,
    };
  },

  components: { VueperSlides, VueperSlide, VueSlideBar, Header },
  methods: {
    barProceeding() {
      this.simpleValue += 33;
      if (this.simpleValue === 99) {
        this.simpleValue++;
      }
    },
    setSliderHeight() {
      return '20px';
    },
    signup() {
      console.log(this.user.email);
      axios
        .post(`${SERVER_URL}/user/join`, this.user)
        .then((response) => {
          if (response.data.success === 'success') {
            alert('회원가입에 성공하셨습니다.');
          } else alert('회원가입에 실패하셨습니다.');
          this.back();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    back() {
      this.$router.replace('/');
    },
    sendEmail(){
      console.log(this.user.email);
      axios
        .post(`${SERVER_URL}/service/mail`,
          {userId:"hi"}
        )
        .then(() =>{
          console.log( "hihi" + this.user.email);
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    checkPw(){
      console.log(this.user.password);
      console.log(this.pw_certification);
      if(this.user.password === ''){
        alert("비밀번호를 입력해주세요");
      }
      // else if(this.verifyValidPw(this.user.password) === false){
      //   console.log("gg");
      // }
      else if(this.user.password === this.pw_certification){ 
        this.$refs.first.next();
        this.barProceeding();
      }else{
        alert("비밀번호가 일치하지 않습니다");
      }
     
    }
  },
  verifyValidPw(str) {
    console.log("확인작업");
      var pw = str;
      //var num = pw.search(/[0-9]/g);
      // var eng = pw.search(/[a-z]/gi);
      //var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

      if (pw.length < 8 || pw.length > 20) {
        alert('8자리 ~ 20자리 이내로 입력해주세요.');
        return false;
      }
      if (pw.search(/₩s/) != -1) {
        alert('비밀번호는 공백업이 입력해주세요.');
        return false;
      }

      return true;
    },
};
</script>

<style>
.memjoin_title {
  width: 50%;
  margin-bottom: 34px;
  font-weight: 600;
  font-size: 44px;
  text-align: center;
}

#pw,
#certinum,
#user-id,
#user-phone,
#user-region,
#certipw {
  width: 350px;
  height: 45px;
}


#certinum_btn,
#next_btn {
  width: 80%;
  height: 45px;
  background: #000;
  border-radius: 2px;
  color: #fff;
  font-size: 16px;
  font-weight: 600;
  text-align: center;
  margin: 12px 0 10px;
}

.memjoin_cnt {
  border-top-style: solid;
  border-top-color: rgb(0, 0, 0);
}
</style>
