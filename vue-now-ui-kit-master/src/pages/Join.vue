//코드 수정시 이메일 인증 다음 버튼에 추가삭제 v-if="isHidden" //비밀번호
수정에서 아래코드 주석화 // else if (this.verifyValidPw(this.user.password) ===
false) { // console.log('gg'); // }

<template>
  <div class="page-header clear-filter" filter-color="orange">
    <div
      class="page-header-image"
      style="background-image: url('img/login.jpg')"
    ></div>
    <div class="content" style="margin-top:140px">
      <center style="margin-bottom:-50px">
        <h2 style="x">간편가입</h2>
      </center>
    </div>
    <vue-slide-bar
      v-model="simpleValue"
      :processStyle="{ backgroundColor: '#35495e' }"
      :lineHeight="5"
      :style="{ width: '500px', margin: 'auto' }"
      :showTooltip="false"
    />
    <br />
    <div>
      <center>
        <vueper-slides
          class="in"
          id="slides"
          :touchable="false"
          :bullets="false"
          :arrows="false"
          :fixed-height="setSliderHeight()"
          ref="first"
          style="width: 500px; height: 400px; display: inline-block; border:0;outline:0 "
        >
          <vueper-slide :key="1">
            <template v-slot:content>
              <div class="text-center memjoin_cnt">
                <form>
                  <div>
                    <p style=" font-size :x-large ; margin-top:20px">
                      로그인에 사용할<br />
                      아이디를 입력해주세요.
                    </p>
                  </div>
                  <div class="inpbx">
                    <fg-input
                      placeholder="아이디(이메일) 입력"
                      style="width: 300px ; margin-left : 20px ; opacity: 2.0"
                      v-model="user.email"
                    >
                    </fg-input>
                    <n-button
                      type="primary"
                      @click.prevent="sendEmail()"
                      style="width:150px;margin-left:320px;margin-top:-75px;border-radius: 10rem;"
                      class="orange_btn"
                      >인증번호 받기</n-button
                    >

                    <!-- <button
                      class="btn btn-primary"
                      id="certinum_btn"
                      @click.prevent="sendEmail()"
                      style="width:150px;margin-left:10px"
                    >
                      인증번호 받기
                    </button> -->

                    <br />
                    <!-- <input
                      type="text"
                      id="certinum"
                      placeholder="인증번호를 입력하세요"
                      style="width: 300px"
                      v-model="code"
                    /> -->
                    <fg-input
                      placeholder="인증번호를 입력하세요"
                      style="width: 300px ; margin-left : 20px"
                      v-model="code"
                    >
                    </fg-input>
                    &nbsp;
                    <!-- <button
                      class="btn btn-primary"
                      id="certinum_btn"
                      style="width:150px ; margin-left:10px"
                      @click.prevent="checkCode()"
                    >
                      확인
                    </button> -->
                    <n-button
                      type="primary"
                      @click.prevent="checkCode()"
                      style="width:150px;margin-left:320px;margin-top:-75px; border-radius: 10rem;"
                      class="orange_btn"
                      >확인</n-button
                    >
                    <br />
                  </div>
                </form>
              </div>
              <div>
                <!-- <button
                  class="btn btn-primary"
                  id="certinum_btn"
                  @click="
                    $refs.first.next();
                    barProceeding();
                  "
                >
                  다음
                </button> -->
                <n-button
                  type="primary"
                  round
                  @click="
                    $refs.first.next();
                    barProceeding();
                  "
                  style="width:200px;border-radius: 10rem;"
                  v-if="isHidden"
                  >다음</n-button
                >
              </div>
            </template>
          </vueper-slide>
          <vueper-slide :key="2">
            <template v-slot:content>
              <div>
                <div class="text-center memjoin_cnt">
                  <form>
                    <div>
                      <p style=" font-size :x-large ; margin-top:20px">
                        로그인에 사용할<br />
                        비밀번호를 입력해주세요.
                      </p>
                      <p style="font-size :medium">
                        8~20자 이내
                      </p>
                    </div>
                    <div class="inpbx">
                      <fg-input
                        type="password"
                        class="col-12"
                        placeholder="비밀번호 입력"
                        style="width: 300px ; margin-left : 95px ;"
                        v-model="user.password"
                      >
                      </fg-input>
                      <!-- <input
                        type="password"
                        id="pw"
                        placeholder="비밀번호 입력"
                        v-model="user.password"
                      /> -->

                      <!-- <div style=" font-size :small" id="english-check">
                    영문포함✓
                  </div> -->
                    </div>
                    <br />
                    <div>
                      <!-- <input
                        type="password"
                        id="certipw"
                        placeholder="비밀번호 확인"
                        v-model="pw_certification"
                      /> -->
                      <fg-input
                        type="password"
                        class="col-12"
                        placeholder="비밀번호 확인"
                        style="width: 300px ; margin-left : 95px ;"
                        v-model="pw_certification"
                      >
                      </fg-input>
                      <br />
                    </div>
                  </form>
                </div>
                <br /><br />
                <!-- <button
                  class="btn btn-primary"
                  id="next_btn"
                  @click="checkPw()"
                >
                  다음</button -->
                <n-button
                  type="primary"
                  @click="checkPw()"
                  style="width:200px ; margin-top : -60px;border-radius: 10rem;"
                  >다음</n-button
                >
              </div>
            </template>
          </vueper-slide>
          <vueper-slide :key="3">
            <template v-slot:content>
              <div class="text-center memjoin_cnt">
                <form>
                  <div>
                    <p style=" font-size :x-large ; margin-top:20px">
                      기본 정보를 입력해주세요.
                    </p>
                  </div>
                  <div
                    class="inpbx"
                    style="font-size :x-large ; margin-top:20px"
                  >
                    <div style="margin-top:20px">
                      <div style="margin-right:330px">닉네임 :</div>
                      <!-- <input
                        type="text"
                        id="user-id"
                        placeholder="닉네임"
                        v-model="user.nickname"
                      /> -->
                      <fg-input
                        v-model="user.nickname"
                        style="width: 300px ; margin-left : 140px ; margin-top : -40px ;opacity: 2.0"
                      ></fg-input>
                    </div>
                    <!-- <div style= "margin-top:10px;margin-left:25px">
                지역 : &nbsp; &nbsp; &nbsp;
                <input
                  type="text"
                  id="user-region"
                  placeholder="지역"
                  v-model="user.region"
                /></div> -->
                    <!-- <div style="margin-top:10px;margin-right:20px">
                      전화번호 :
                      <input
                        type="text"
                        id="user-phone"
                        placeholder="전화번호"
                        v-model="user.phone"
                      />
                    </div> -->
                    <div style="margin-top:20px">
                      <div style="margin-right:355px">전화번호 :</div>
                      <fg-input
                        v-model="user.phone"
                        style="width: 300px ; margin-left : 140px ; margin-top : -40px ;opacity: 2.0"
                      ></fg-input>
                    </div>
                    <div style="margin-right:223px">
                      <span style="margin-right:10px">사는 곳 :</span>
                      <!-- <b-button v-b-modal.modal-2>주소찾기</b-button> -->
                      <n-button
                        type="primary"
                        round
                        v-b-modal.modal-2
                        style="; height : 40px;  font-size:13px "
                        >주소찾기</n-button
                      >
                    </div>
                    <!-- <input
                      type="text"
                      id="user-address"
                      placeholder="주소"
                      v-model="user.region"
                      style="margin-top:10px ;margin-bottom:20px;font-size:13px ;width:470px;height:45px "
                    /> -->
                    <fg-input
                        v-model="user.region"
                        style="width: 400px ; margin-left : 40px; font-size:13px ;opacity: 2.0"
                      ></fg-input>
                  </div>
                </form>
              </div>

              <div>
                <!-- <button
                  class="btn btn-primary"
                  id="next_btn"
                  @click="
                    barProceeding();
                    signup();
                  "
                >
                  회원가입 완료
                </button> -->
                <n-button
                  type="primary"
                  @click="
                    barProceeding();
                    signup();
                  "
                  style="width:200px ; margin-right:20px;border-radius: 10rem;"
                  >회원가입 완료</n-button
                >
              </div>
            </template>
          </vueper-slide>
        </vueper-slides>
      </center>
    </div>
    <b-modal ref="addr-modal" id="modal-2" title="주소 찾기" hide-footer>
      <FindPostCode @setAddress="setAddress" />
    </b-modal>
  </div>
</template>

<script>
import { VueperSlides, VueperSlide } from 'vueperslides';
import 'vueperslides/dist/vueperslides.css';
import VueSlideBar from 'vue-slide-bar';
import axios from 'axios';
import 'url-search-params-polyfill';
import FindPostCode from './User/FindPostCode';
import { Button, FormGroupInput } from '@/components';

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  data() {
    return {
      isHidden: false, //다음 표시 숨기기 기능
      code: '',
      pw_certification: '',
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

  components: {
    VueperSlides,
    VueperSlide,
    VueSlideBar,
    FindPostCode,
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
  },
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
      this.$router.replace('/login');
    },
    sendEmail() {
      console.log(this.user.email);
      axios
        .post(`${SERVER_URL}/service/mail`, this.user.email)
        .then((response) => {
          if (response.data.success === 'success') {
            alert('이메일로 코드를 전송하였습니다');
            console.log('성공');
          } else if (response.data.success === 'error') {
            alert('이메일 형식에 맞추어 다시 입력 해 주세요.');
            console.log('실패');
          } else {
            console.log('실패2');
          }
        })
        .catch(function(error) {
          console.log(error);
          alert('이메일 형식에 맞추어 다시 입력 해 주세요.');
        });
      // .then((response) => {
      //   alert("11에러입니다");
      //   if (response.data.success === 'success') {
      //     alert('해당 이메일로 코드 발송하였습니다.');
      //   } else alert('실패하셨습니다.');
      // })
      // .catch(function(error) {
      //   alert("에러입니다");
      //   console.log(error);
      // });
    },
    checkCode() {
      console.log(this.code + '  gd');
      axios
        .post(`${SERVER_URL}/service/verifyCode`, this.code)
        .then((response) => {
          if (response.data.success === 'success') {
            alert('인증 성공');
            this.isHidden = true;
          } else {
            alert('인증 실패');
          }
        })
        .catch(function(error) {
          console.log(error);
          alert('오류');
        });
    },
    checkPw() {
      console.log(this.user.password);
      console.log(this.pw_certification);
      if (this.user.password === '') {
        alert('비밀번호를 입력해주세요');
      }
      else if (this.verifyValidPw(this.user.password) === false) {
        console.log('gg');
      }
      else if (this.user.password === this.pw_certification) {
        this.$refs.first.next();
        this.barProceeding();
      } else {
        alert('비밀번호가 일치하지 않습니다');
      }
    },
    verifyValidPw(str) {
      console.log('확인작업');
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
    setAddress(data) {
      this.user.region = data;
      console.log(this.user.region);
      this.hideModal();
    },
    hideModal() {
      this.$refs['addr-modal'].hide();
    },
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
  /* border-top-style: solid; */
  /* border-top-color: rgb(0, 0, 0); */
}

#slides {
  width: 500px;
  height: 400px;
  display: inline-block;
  /* background-color: #ffffff; */
  /* opacity: 0.5; */
  background-color: rgba(255, 255, 255, 0.075);
}
.orange_btn{
  border-radius: 10rem;
}
</style>
