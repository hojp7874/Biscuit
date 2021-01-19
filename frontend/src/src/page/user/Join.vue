#시작 전 npm install --save vueperslides 그리고 index.html에 bootstrap npm
install --save vue-slide-bar

<template>
  <div class="out">
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
      style="width: 500px; height: 350px; display: inline-block; background-color: white"
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

              <div>
                <button
                  class="btn btn-primary"
                  id="next_btn"
                  @click="
                    $refs.first.next();
                    barProceeding();
                  "
                >
                  다음
                </button>
              </div>
            </form>
          </div>
        </template>
      </vueper-slide>

      <vueper-slide :key="2">
        <template v-slot:content>
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
                  v-model="password"
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
              <br /><br />
              <div>
                <button
                  class="btn btn-primary"
                  id="next_btn"
                  @click="
                    $refs.first.next();
                    barProceeding();
                  "
                >
                  다음
                </button>
              </div>
            </form>
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
                닉네임 : <input type="text" id="user-id" placeholder="닉네임" />
              </div>
              <br /><br /><br /><br /><br /><br /><br /><br />
              <div>
                <button
                  class="btn btn-primary"
                  id="next_btn"
                  @click="
                    $refs.first.next();
                    barProceeding();
                  "
                >
                  회원가입 완료
                </button>
              </div>
            </form>
          </div>
        </template>
      </vueper-slide>
    </vueper-slides>
  </div>
</template>

<script>
import { VueperSlides, VueperSlide } from 'vueperslides';
import 'vueperslides/dist/vueperslides.css';
import VueSlideBar from 'vue-slide-bar';
export default {
  data() {
    return {
      simpleValue: 0,
      checkPassword:
        '영문포함✓  &nbsp;&nbsp;&nbsp;숫자포함✓ &nbsp;&nbsp;&nbsp;8~20자 이내✓',
    };
  },
  components: { VueperSlides, VueperSlide, VueSlideBar },
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

    chkPwd(str) {
      var pw = str;
      var num = pw.search(/[0-9]/g);
      var eng = pw.search(/[a-z]/gi);
      var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

      if (pw.length < 8 || pw.length > 20) {
        alert('8자리 ~ 20자리 이내로 입력해주세요.');
        return false;
      }
      if (pw.search(/₩s/) != -1) {
        alert('비밀번호는 공백업이 입력해주세요.');
        return false;
      }
      if (eng < 0) {
      }
      return true;
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
#password,
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
