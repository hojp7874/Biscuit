<template>
  <div id="app">
    
    <div id="findpw_cnt"  class="container findpw-wrap col-md-3 col-md-offset-4" style="margin-top:60px">
      <h2 class="findpw_title">비밀번호 찾기</h2>
      <div class="text-center findpw_cnt">
        <form>
          <div>
            <p>
              본인인증을 통해 아이디(이메일) 확인 및<br />
              비밀번호를 변경하실 수 있습니다.
            </p>
          </div>
          <div>
            <input type="text" id="cert-id" placeholder="아이디 (이메일)" />
          </div>
          <div class="cert-wrap">
            <input
              type="text"
              id="certinum"
              placeholder="인증번호를 입력하세요"
            />
            <input type="button" id="certinum_btn" value="인증번호 받기" />
          </div>
          <div>
            <button
              type="button"
              class="btn btn-primary"
              id="findpw_btn"
              @click="changePw"
            >
              확인
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  components: {  },
};
</script>

<style>
.findpw_title {
  width: 100%;
  margin-bottom: 34px;
  font-weight: 600;
  font-size: 44px;
  text-align: center;
}

.findpw_cnt {
  padding-top: 18px;
  border-top: 4px solid #000;
  border-top-width: 4px;
  border-top-style: solid;
  border-top-color: rgb(0, 0, 0);
}

#cert-id {
  width: 100%;
  height: 40px;
  margin-bottom: 10px;
}

.certi-wrap {
  margin-top: 12px;
  width: 350px;
  height: 40px;
}

#certinum {
  width: 70%;
  height: 40px;
  display: inline;
}

#certinum_btn {
  width: 30%;
  height: 40px;
  background-color: black;
  border: none;
  font-size: 1em;
  color: white;
  outline: none;
  display: inline;
  margin-left: -10px;
  box-sizing: border-box;
}

#findpw_btn {
  width: 100%;
  height: 45px;
  background: #000;
  border-radius: 2px;
  color: #fff;
  font-size: 16px;
  text-align: center;
  margin: 12px 0 10px;
}
</style>
