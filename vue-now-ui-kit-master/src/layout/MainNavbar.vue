<template>
  <navbar
    position="fixed"
    type="primary"
    :transparent="transparent"
    :color-on-scroll="colorOnScroll"
    menu-classes="ml-auto"
  >
    <template>
      <router-link v-popover:popover1 class="navbar-brand" to="/">
      <img class="n-logo" src="img/bisWhite.png" height="30px" alt="" />
      
      </router-link>
      <el-popover
        ref="popover1"
        popper-class="popover"
        placement="bottom"
        width="200"
        trigger="hover"
      >
        <div class="popover-body">
         서울 4반 7팀
        </div>
      </el-popover>
    </template>
    <template slot="navbar-menu">
      <router-link class="navbar-brand" to="/group">
        <i class="now-ui-icons arrows-1_cloud-download-93"></i>
        <p>그룹 찾기</p>
      </router-link>
      <drop-down
        tag="li"
        title="게시판"
        icon="now-ui-icons design_app"
        class="nav-item"
      >
        <nav-link to="/">
          <i class="now-ui-icons business_chart-pie-36"></i> 공지사항
        </nav-link>
        <nav-link to="/board">
          <i class="now-ui-icons business_chart-pie-36"></i> All components 자유 게시판
        </nav-link>
        <a
          href="https://demos.creative-tim.com/vue-now-ui-kit/documentation"
          target="_blank"
          class="dropdown-item"
        >
          <i class="now-ui-icons design_bullet-list-67"></i> Documentation 취업 게시판
        </a>
      </drop-down>
      <drop-down
              tag="li"
              title="마이페이지"
              icon="now-ui-icons design_image"
              class="nav-item"
               v-if="this.token !== ''"
      >
        <nav-link to="/landing">
          <i class="now-ui-icons education_paper"></i> Landing
        </nav-link>
        <nav-link to="/profile">
          <i class="now-ui-icons users_single-02"></i> Profile
        </nav-link>
      </drop-down>
      <li class="nav-item">
        <a
          class="nav-link btn btn-neutral"
          v-on:click="goToLogin()"
          target="_blank"
          v-if="this.token === ''"
        >
          <i class="now-ui-icons arrows-1_share-66"></i>
          <p>로그인</p>
        </a>
        <a
          class="nav-link btn btn-neutral"
          v-on:click="onClickLogout()"
          target="_blank"
          v-else
        >
          <i class="now-ui-icons arrows-1_share-66"></i>
          <p>로그아웃</p>
        </a>
      </li>

      <li class="nav-item">
        <a
          class="nav-link"
          rel="tooltip"
          title="Follow us on Twitter"
          data-placement="bottom"
          href="https://twitter.com/CreativeTim"
          target="_blank"
        >
          <i class="fab fa-twitter"></i>
          <p class="d-lg-none d-xl-none">Twitter</p>
        </a>
      </li>
      <li class="nav-item">
        <a
          class="nav-link"
          rel="tooltip"
          title="Like us on Facebook"
          data-placement="bottom"
          href="https://www.facebook.com/CreativeTim"
          target="_blank"
        >
          <i class="fab fa-facebook-square"></i>
          <p class="d-lg-none d-xl-none">Facebook</p>
        </a>
      </li>
      <li class="nav-item">
        <a
          class="nav-link"
          rel="tooltip"
          title="Follow us on Instagram"
          data-placement="bottom"
          href="https://www.instagram.com/CreativeTimOfficial"
          target="_blank"
        >
          <i class="fab fa-instagram"></i>
          <p class="d-lg-none d-xl-none">Instagram</p>
        </a>
      </li>
    </template>
  </navbar>
</template>

<script>
import { DropDown, Navbar, NavLink } from '@/components';
import { Popover } from 'element-ui';
export default {
  name: 'main-navbar',
  data() {
    return {
      id: '',
      name: '',
      admin: '',
      type: '',
      token:''
    };
  },
  props: {
    transparent: Boolean,
    colorOnScroll: Number
  },
  components: {
    DropDown,
    Navbar,
    NavLink,
    [Popover.name]: Popover
  },
  methods:{
    onClickLogout() {
      console.log("onclicklogout확인" + this.token +"gd" );
      localStorage.removeItem('token');
      localStorage.removeItem('email');
      localStorage.removeItem('nickname');
      localStorage.removeItem('admin');
      localStorage.removeItem('phone');
      localStorage.removeItem('region');
      this.$emit('logout');
    },
    goToLogin(){
      this.$router.replace(`/login`);
    }
  },
  created() {
    if (localStorage.getItem('token')) {
      this.token = localStorage.getItem('token');
      this.email = localStorage.getItem('email');
      this.nickname = localStorage.getItem('nickname');
      this.admin = localStorage.getItem('admin');
    }
  },
};
</script>

<style scoped></style>
