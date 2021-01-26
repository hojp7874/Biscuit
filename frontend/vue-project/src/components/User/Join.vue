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
                  style="width: 50%"
                  v-model="user.email"
                />
                <button class="btn btn-primary" id="certinum_btn">
                  인증번호 받기
                </button>
                <br />
                <input
                  type="text"
                  id="certinum"
                  placeholder="인증번호를 입력하세요"
                  style="width: 50%"
                />
                <button class="btn btn-primary" id="certinum_btn">
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
                    id="password"
                    placeholder="비밀번호 입력"
                    v-model="user.password"
                  />
                  <br /><br />
                  <div style=" font-size :small" id="english-check">
                    영문포함✓
                  </div>
                </div>
                <br />
                <div>
                  <input
                    type="password"
                    id="certipw"
                    placeholder="비밀번호 확인"
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
                $refs.first.next();
                barProceeding();
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
                닉네임 : <input type="text" id="user-id" placeholder="닉네임" v-model="user.nickname"/>
                지역 : <input type="text" id="user-id" placeholder="지역" v-model="user.region"/>
                전화번호 : <input type="text" id="user-id" placeholder="닉네임" v-model="user.phone" />
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

const SERVER_URL = process.env.VUE_APP_LOCAL_SERVER_URL;

export default {
  data() {
    return {
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
      console.log(this.user.id);
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

#certinum,
#user-id,
#certipw {
  width: 80%;
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
