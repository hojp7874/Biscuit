<template>
  <div>
    <div class="page-header clear-filter" filter-color="orange">
      <parallax class="page-header-image" style="background-image:url('img/bg5.jpg')"> </parallax>
      <div class="container">
        <div class="photo-container">
          <img src="img/ryan.jpg" alt="" />
        </div>
        <h3 class="title">{{ loginStatus.nickname }}</h3>
        <p class="category">{{ loginStatus.phone }}</p>
        <div class="content">
          <div class="social-description">
            <h2>26</h2>
            <p>내 게시글</p>
          </div>
          <div class="social-description">
            <h2>26</h2>
            <p>내 댓글</p>
          </div>
          <div class="social-description">
            <h2>48</h2>
            <p>가입한 스터디</p>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="button-container">
          <a v-on:click="loadStudy()" class="btn btn-primary btn-round btn-lg" >나의 스터디</a>
          <a v-on:click="loadSchedule()" class="btn btn-primary btn-round btn-lg">나의 일정</a>
          <a v-on:click="loadUpdate()" class="btn btn-primary btn-round btn-lg" >개인 정보 수정</a>
          
        </div>
        <component :is="componentLoading()"></component>
  </div>
    </div>
    </div>
  
</template>
<script>
import { Tabs, TabPane,Button, FormGroupInput } from '@/components';
import MyStudy from './User/MyPage/MyStudy';
import MySchedule from './User/MyPage/MySchedule';
import UpdateUser from './User/MyPage/UpdateUser';
 import {mapState} from 'vuex'
export default {
  name: 'profile',
  bodyClass: 'profile-page',
  data() {
    return {
      user: {
        email: '',
        nickname: '',
        picture: '',
        region: '',
        phone: '',
      },
      active:0,
    };
  },
  created() {
    this.user.region = localStorage.getItem('region');
    this.user.email = localStorage.getItem('email');
    this.user.nickname = localStorage.getItem('nickname');
    this.user.phone = localStorage.getItem('phone');
  },
  computed: {
      ...mapState([
        'loginStatus',
      ]),
    },
  components: {
    Tabs,
    TabPane,MySchedule,UpdateUser,MyStudy,
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
  },
  methods: {
    componentLoading(){
          switch(this.active){
              case 0 :
                  return 'MyStudy';
              case 1 :
                  return 'MySchedule';
              case 2 :
                  return 'UpdateUser';    
          }
      },

      loadStudy(){
           this.active = 0;
      },
      loadSchedule(){
           this.active = 1;
      },
      loadUpdate(){
          this.active = 2;
      }
  }
};
</script>
<style></style>
