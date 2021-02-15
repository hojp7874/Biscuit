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
      <router-link class="navbar-brand" to="/grouplist">
        <i class="now-ui-icons arrows-1_cloud-download-93" style="font-size: 15px"> 스터디 찾기</i>
      </router-link>
      <drop-down
        tag="li"
        title="게시판"
        style="font-size: 21px"
        icon="now-ui-icons design_app"
        class="nav-item"
      >
        <nav-link to="/">
          <i class="now-ui-icons business_chart-pie-36"></i> 공지사항
        </nav-link>
        <nav-link to="/boardlist">
          <i class="now-ui-icons business_chart-pie-36"></i> All components 자유
          게시판
        </nav-link>
        <a target="_blank" class="dropdown-item">
          <i class="now-ui-icons design_bullet-list-67"></i> Documentation 취업
          게시판
        </a>
      </drop-down>

      <div class="d-flex align-items-center">
        <img v-if="this.token" :src="loginStatus.picture" alt="" class="rounded-circle" style="width:40px; height:40px">
        
        <drop-down
          tag="li"
          :title="loginStatus.nickname + ' 님'"
          style="font-size: 21px"
          class="nav-item"
          v-if="this.token !== ''"
        >
          <!-- icon="now-ui-icons design_image" -->
          <!-- <nav-link to="/landing">
            <i class="now-ui-icons education_paper"></i> Landing
          </nav-link> -->
          <nav-link to="/profile">
            <i class="now-ui-icons users_single-02"></i> MyPage
          </nav-link>
        </drop-down>
      </div>
      <!-- <div class="alert-icon">
        <i class="now-ui-icons ui-1_bell-53" style="background-color:white"></i>
      </div> -->
      <drop-down v-if="this.token !== ''">
        <b-icon-bell
          slot="title"
          class="dropdown-toggle"
          data-toggle="dropdown"
          font-scale="1.3"
          style="margin-top:10px;margin-right:15px;margin-left:-5px;color:white"
          @click="readNotification"
        />

      <!-- <a target="_blank" class="dropdown-item">
        댓글이 작성되었습니다~~~
        </a><a target="_blank" class="dropdown-item"> 
          그룹 신청 왔습니다~~~
        </a><a target="_blank" class="dropdown-item">
          그룹 승인 되었습니다~~
        </a> -->
        
        <!-- <button class="dropdown-item" v-for="item in items" v-bind:key="item" @click="goNoti(item)">
          {{item.message}}
        </button><i class="now-ui-icons ui-1_simple-remove" style="margin-left:10px ;margin-top:-3px" @click="deleteNoti(item)"/> -->
        <div v-for="item in items" v-bind:key="item">
          <div class="dropdown-item" v-if="item.isRead == 1" id="readNoti">
            <button style = "background-color: white; border:0;outline:0; font-size:10px;margin-left:-20px" @click="goNoti(item)">{{item.message}}</button>
            <i class="now-ui-icons ui-1_simple-remove" style="margin-left:5px ;margin-top:-3px" @click.prevent="deleteNoti(item)"/>
          </div>

          <div class="dropdown-item" v-if="item.isRead == 0" id="notReadNoti">
            <button style = "background-color:white ; border:0;outline:0;font-weight:bold;font-size:10px;;margin-left:-20px" @click="goNoti(item)">{{item.message}}</button>
            <i class="now-ui-icons ui-1_simple-remove" style="margin-left:5px ;margin-top:-3px" @click.prevent="deleteNoti(item)"/>
          </div>
        </div>
      </drop-down>
      <!-- <drop-down icon="now-ui-icons ui-1_bell-53"  style="margin-left:-20px"  > </drop-down> -->

      <li class="nav-item">
        <a
          class="nav-link btn btn-primary"
          v-on:click="goToLogin()"
          target="_blank"
          v-if="this.token === ''"
        >
          <i class="now-ui-icons arrows-1_share-66"></i>
          <p>로그인</p>
        </a>
        <a
          class="nav-link btn btn-primary"
          v-on:click="onClickLogout()"
          target="_blank"
          v-else
        >
          <i class="now-ui-icons arrows-1_share-66"></i>
          <p>로그아웃</p>
        </a>
      </li>
      <!-- 
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
      </li> -->
    </template>
  </navbar>
</template>

<script>
import { DropDown, Navbar, NavLink } from '@/components';
import { Popover } from 'element-ui';
import axios from 'axios';
import { mapState } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  name: 'main-navbar',
  data() {
    return {
      id: '',
      name: '',
      admin: '',
      type: '',
      token: '',
      items:[],
    };
  },
  props: {
    transparent: Boolean,
    colorOnScroll: Number,
  },
  computed: {
    ...mapState([
      'loginStatus'
    ])
  },
  components: {
    DropDown,
    Navbar,
    NavLink,
    [Popover.name]: Popover,
  },
  methods: {
    onClickLogout() {
      console.log('onclicklogout확인' + this.token + 'gd');
      localStorage.removeItem('token');
      localStorage.removeItem('email');
      localStorage.removeItem('nickname');
      localStorage.removeItem('admin');
      localStorage.removeItem('phone');
      localStorage.removeItem('region');
      this.$emit('logout');
    },
    goToLogin() {
      this.$router.replace(`/login`);
    },
    readNotification(){
      this.form = { receiveEmail: localStorage.getItem('email') };
      axios
        .get(`${SERVER_URL}/notification/read`, {
          params: this.form,
        })
        .then((res) => {
          this.items = res.data.list;
        });
    },
    goNoti(item){
      this.form = {isRead:1 , nId:item.nId};
      axios
        .put(`${SERVER_URL}/notification/update`, this.form , {
          headers: {
            'x-access-token': localStorage.getItem('token'),
          },
        })
        .then((response) => {
          if (response.data.success === 'success') {
            console.log('정보 수정에 성공하셨습니다.');
          } else console.log('정보 수정에 실패하셨습니다.');
        })
        .catch(function(error) {
          console.log(error);
        });

      this.$router.replace(item.notiUrl);
    },
    deleteNoti(item){
      this.delForm = { nId: item.nId };
      axios
        .delete(`${SERVER_URL}/notification/delete`, {
          params: this.delForm,
        })
        .then((res) => {
          if (res.data.success === 'success') {
            console.log('삭제하였습니다.');
          }else{
            console.log('실패');
          }
        });
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

<style>
#readNoti{
  /* background-color: rgb(240, 240, 240); */
  opacity: 0.5;
}
</style>
