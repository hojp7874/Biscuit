<template v-slot:content>
  <div class="text-center memjoin_cnt">
    <form>
      <div>
        <p style="font-size: x-large">회원 정보 수정</p>
      </div>
      <div id="user_info">
        <p style="font-size: large">로그인 정보</p>
        <div id="login_info">
          <span> 아이디(이메일) </span>
          <p>aaaaa12345@naver.com</p>
          <span> 비밀번호 </span>
          <button
            id="update_btn"
            @click="
              addPwInput();
              div_hide();
            "
          >
            변경
          </button>
          <div id="addedKeyword"></div>
          <button @click = "div_show()">변경취소</button>

          <p id="fakePw">.........</p>
        </div>
        <br /><br />
        <p style="font-size: large">회원 정보</p>
        <div id="member_info">
          <div class="inpbx" style="font-size: large">
            닉네임 : <input type="text" id="user-id" placeholder="닉네임" />
          </div>
        </div>
      </div>
      <div>
        <button class="btn btn-primary" id="next_btn">완료</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data: {},
  methods: {
    addPwInput() {
      console.log('123');
      var addedFormDiv = document.getElementById('addedKeyword');
      var str =
        '<input type="text" style="margin-top: 10px;"'
        +'placeholder="현재 비밀번호를 입력하세요" ><br><input type="text" style="margin-top: 10px;"'
        + 'placeholder="새 비밀번호를 입력하세요" ><br><input type="text" style="margin-top: 10px;"  placeholder="새 비밀번호를 한 번 더입력하세요" ><br>'
        + '<button @click = "div_show()">변경취소</button>'
        + '<button>확인</button>';
      var addedDiv = document.createElement('div');
      // addedDiv.setAttribute("id","keyword_Frm" + count);
      addedDiv.innerHTML = str;
      addedFormDiv.appendChild(addedDiv);
    },
    div_hide() {
      document.getElementById('update_btn').style.display = 'none';
      document.getElementById('fakePw').style.display = 'none';
    },
    div_show() {
        console.log("zzz");
        document.getElementById('update_btn').style.display = 'block';
      document.getElementById('fakePw').style.display = 'block';
      document.getElementById('addedKeyword').style.display = 'none';
 }

  },
  components: {
    'button-counter': {
      template: '<input type="text" style="margin-top: 10px;" ><br>',
    },
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
}

#login_info,
#member_info {
  padding-top: 18px;
  border-top: 4px solid #000;
  border-top-width: 2px;
  border-top-style: solid;
  border-top-color: rgb(172, 159, 159);
}

#update_btn {
  width: 34px;
  height: 50px;
  background: rgb(245, 245, 245);
  border-radius: 2px;
  color: rgb(32, 23, 23);
  font-size: 16px;
  font-weight: 600;
  text-align: center;
  margin: 12px 0 10px;
}
</style>
