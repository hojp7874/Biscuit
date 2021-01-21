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
          <br />
          <span> 비밀번호 </span>
          <p id="fakePw">········</p>
          <button id="update_btn" @click="div_hide()">
            변경
          </button>
          <div id="addedKeyword"></div>

          <div id="cancel" style="display:none">
            <input
              type="password"
              style="margin-top: 10px;"
              placeholder="현재 비밀번호를 입력하세요"
            />
            <br />
            <input
              type="password"
              style="margin-top: 15px;"
              placeholder="새 비밀번호를 입력하세요"
            />
            <br />
            <input
              type="password"
              style="margin-top: 15px; width :500px ; margin-left: 180px; margin-bottom: 15px;"
              placeholder="새 비밀번호를 한 번 더 입력하세요"
            />
            <br />
            <button id="cancel_btn" @click="div_show()">변경취소</button>
            &nbsp;
            <button id="confirm_btn">확인</button>
          </div>
        </div>
        <br /><br />
        <p style="font-size: large">회원 정보</p>
        <div id="member_info">
          <div class="inpbx" style="font-size: large">
            <span style="margin-right :28px">닉네임</span>
            <input
              type="text"
              id="user-id"
              placeholder="닉네임"
              style="margin-left : 30px"
            /><br />
            <span style="margin-right : 20px">휴대폰 번호</span>
            <input type="text" id="user-id" placeholder="휴대폰 번호" /><br />
            <span style="margin-right :55px">사는 곳</span>
            <input type="text" id="user-id" placeholder="사는 곳" /><br />
          </div>
        </div>
      </div>
      <button style="margin-left :550px ; font-size : small" @click="doc_del_rendar()">
        회원 탈퇴하기
      </button>
      <div class="row">
        <!-- <modals-container /> -->
      </div>
      <br /><br />
      <div>
        <button class="btn btn-primary" id="complete_btn">완료</button>
      </div>
    </form>
  </div>
</template>

<script>
import DelPopup from './DelPopup.vue';

export default {
  methods: {
    doc_del_rendar() {
      this.$modal.show(
        DelPopup,
        {
          hot_table: 'data',
          modal: this.$modal,
        },
        {
          name: 'dynamic-modal',
          width: '500px',
          height: '260px',
          draggable: true
        }
      );
    },
    addPwInput() {
      console.log('123');
      var addedFormDiv = document.getElementById('addedKeyword');
      var str =
        '<input type="text" style="margin-top: 10px;"' +
        'placeholder="현재 비밀번호를 입력하세요" ><br><input type="text" style="margin-top: 10px;"' +
        'placeholder="새 비밀번호를 입력하세요" ><br><input type="text" style="margin-top: 10px;"  placeholder="새 비밀번호를 한 번 더입력하세요" ><br>';
      var addedDiv = document.createElement('div');
      // addedDiv.setAttribute("id","keyword_Frm" + count);
      addedDiv.innerHTML = str;
      addedFormDiv.appendChild(addedDiv);
    },
    div_hide() {
      document.getElementById('update_btn').style.display = 'none';
      document.getElementById('fakePw').style.display = 'none';
      document.getElementById('cancel').style.display = 'block';
    },
    div_show() {
      console.log('zzz');
      document.getElementById('update_btn').style.display = 'block';
      document.getElementById('fakePw').style.display = 'block';
      document.getElementById('addedKeyword').style.display = 'none';
      document.getElementById('cancel').style.display = 'none';
    },
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
