<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand href="#">Vue.js로 게시판 만들기</b-navbar-brand>

      <b-navbar-toggle target="nav_collapse" />

      <b-collapse is-nav id="nav_collapse">
        <b-navbar-nav>
          <b-nav-item href="#">공지사항</b-nav-item>
          <b-nav-item to="/boardlist">자유게시판</b-nav-item>
          <b-nav-item to="/mypage">마이페이지</b-nav-item>
        </b-navbar-nav>
        <!-- <b-navbar-nav class="ml-auto">
          <b-nav-form>
            <b-nav-item to="/login">로그인</b-nav-item>
          </b-nav-form>
        </b-navbar-nav> -->

        <b-navbar-nav
          class="ml-auto"
          v-if="this.token !== ''"
        >
          
          <b-navbar-nav class="ml-auto">
            <b-nav-item
          >{{ nickname }}님 환영합니다.</b-nav-item
        >
        <b-nav-form>
          <b-button variant="success" @click="onClickLogout"
            >로그아웃</b-button
          >
        </b-nav-form>
          </b-navbar-nav>
        </b-navbar-nav>

        <b-navbar-nav class="ml-auto" v-else>
          <b-navbar-nav class="ml-auto">
            <b-nav-form>
              <b-nav-item to="/login">로그인</b-nav-item>
            </b-nav-form>
          </b-navbar-nav>
        </b-navbar-nav>

      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: 'Header',
   data() {
    return {
      id: '',
      name: '',
      admin: '',
      type: '',
      token:''
    };
  },
  methods: {
    onClickLogout() {
      console.log("onclicklogout확인" + this.token +"gd" );
      localStorage.removeItem('token');
      localStorage.removeItem('email');
      localStorage.removeItem('nickname');
      localStorage.removeItem('admin');
      localStorage.removeItem('phone');
      localStorage.removeItem('region');
      this.$emit('logout');
    }
  },
  created() {
    if (localStorage.getItem('token')) {
      this.token = localStorage.getItem('token');
      this.email = localStorage.getItem('email');
      this.nickname = localStorage.getItem('nickname');
      this.admin = localStorage.getItem('admin');
    }
  }
  
};
</script>
