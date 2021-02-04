<template>
  <div>
    <div class="page-header clear-filter" filter-color="orange">
      <parallax class="page-header-image" style="background-image:url('img/bg5.jpg')"> </parallax>
      <div class="container">
        <div class="photo-container">
          <img src="img/ryan.jpg" alt="" />
        </div>
<<<<<<< HEAD
        <h3 class="title">{{ loginStatus.nickname }}</h3>
        <p class="category">{{ loginStatus.phone }}</p>
=======
        <h3 class="title">{{loginStatus.nickname}}</h3>
        <p class="category">{{loginStatus.phone}}</p>
>>>>>>> 8457ec5233697e62c2d5608759d1d60893128732
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
<<<<<<< HEAD
          <a v-on:click="loadSchedule()" class="btn btn-primary btn-round btn-lg">나의 일정</a>
          <a v-on:click="loadUpdate()" class="btn btn-primary btn-round btn-lg">개인 정보 수정</a>
        </div>
        <component :is="componentLoading()"></component>
      </div>
    </div>
=======
          <a v-on:click="loadStudy()" class="btn btn-primary btn-round btn-lg" >나의 스터디</a>
          <a v-on:click="loadSchedule()" class="btn btn-primary btn-round btn-lg">나의 일정</a>
          <a v-on:click="loadUpdate()" class="btn btn-primary btn-round btn-lg" >개인 정보 수정</a>
          
        </div>
        <component :is="componentLoading()"></component>
>>>>>>> 8457ec5233697e62c2d5608759d1d60893128732
  </div>
    </div>
    </div>
  
</template>
<script>
<<<<<<< HEAD
import { Tabs, TabPane } from '@/components';
import MyStudy from './components/User/MyPage/MyStudy';
import MySchedule from './components/User/MyPage/MySchedule';
import UpdateUser from './components/User/MyPage/UpdateUser';
import { mapState } from 'vuex';
=======
import { Tabs, TabPane,Button, FormGroupInput } from '@/components';
import MyStudy from './User/MyPage/MyStudy';
import MySchedule from './User/MyPage/MySchedule';
import UpdateUser from './User/MyPage/UpdateUser';
 import {mapState} from 'vuex'
>>>>>>> 8457ec5233697e62c2d5608759d1d60893128732
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
<<<<<<< HEAD
      active: 1,
=======
      active:0,
>>>>>>> 8457ec5233697e62c2d5608759d1d60893128732
    };
  },
  created() {
    this.user.region = localStorage.getItem('region');
    this.user.email = localStorage.getItem('email');
    this.user.nickname = localStorage.getItem('nickname');
    this.user.phone = localStorage.getItem('phone');
  },
  computed: {
<<<<<<< HEAD
    ...mapState(['loginStatus']),
  },
  components: {
    Tabs,
    TabPane,
    MySchedule,
    UpdateUser,
    MyStudy,
  },
  methods: {
    componentLoading() {
      switch (this.active) {
        case 0:
          return 'MyStudy';
        case 1:
          return 'MySchedule';
        case 2:
          return 'UpdateUser';
      }
    },

    loadStudy() {
      this.active = 0;
    },
    loadSchedule() {
      this.active = 1;
    },
    loadUpdate() {
      this.active = 2;
    },
  },
=======
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
>>>>>>> 8457ec5233697e62c2d5608759d1d60893128732
};
</script>
<style></style>
