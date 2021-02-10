<template>
  <div>
    <div class="page-header clear-filter" filter-color="orange">
      <parallax class="page-header-image" style="background-image:url('img/bg5.jpg')"> </parallax>
      <div class="container">
        <div class="photo-container">
          <img src="img/ryan.jpg" alt="" />
        </div>
        <h3 class="title">{{ group.groupName }}</h3>
        <p class="category">{{ group.category}}</p>
        <div class="description">{{group.groupDesc}}</div>
       
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="button-container">
          <!-- button -->
          <a v-on:click="loadHome()" class="btn btn-primary btn-round btn-lg">홈</a>
          <a v-on:click="joinMeeting()" class="btn btn-primary btn-round btn-lg">화상 채팅</a>
          <tag v-if="state == 3">
          <a type="primary" v-on:click="loadApplyList()" class="btn btn-primary btn-round btn-lg">
            <span>
              신청 현황
            <span v-if="applyCount != 0" class="badge badge-warning badge-pill">{{applyCount}}</span>
            </span>
          </a>
          </tag>
        </div>
        <component :is="componentLoading()" :gId="gId"></component>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
import GroupHome from './GroupHome.vue';
import ApplyList from './ApplyList.vue';
import { mapState } from 'vuex';
export default {
  name: 'profile',
  bodyClass: 'profile-page',
  data() {
    return {
       group: Object,
      gId: this.$route.query.gId,
      state: Number,
      applyCount: Number,
      active: 0,
    };
  },
  created() {
    this.getState();
    this.getGroup();
    this.getApplyCount();
  },
  computed: {
    ...mapState(['loginStatus']),
  },
  components: {
    GroupHome,
    ApplyList,
  },
  methods: {
    componentLoading() {
      switch (this.active) {
        case 0:
          return 'GroupHome';
        case 1:
           return 'ApplyList';
      }
    },

    loadHome() {
      this.active = 0;
    },
    loadApplyList() {
      this.active = 1;
    },
    getState: function() {
      axios
        .get(`${SERVER_URL}/group/member/apply/state`, {
          params: {
            gId: this.gId,
            nickname: this.loginStatus.nickname,
          },
        })
        .then((res) => {
          this.state = res.data.state;
        })
        .catch((err) => {
          console.log(err);
        });
    },
 getGroup: function() {
      axios
        .get(`${SERVER_URL}/group/list/`, {
          params: {
            word: this.gId,
            type: 'gId',
          },
        })
        .then((res) => {
          this.group = res.data.list[0];
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getApplyCount: function() {
      axios
        .get(`${SERVER_URL}/group/member/apply/group/count`, {
          params: {
            gId: this.gId,
          },
        })
        .then((res) => {
          this.applyCount = res.data.applyCount;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    joinMeeting() {
      //var VUE_RTC_LOCAL_SERVER_URL = `http://localhost:9001/demos/dashboard/`;
       var VUE_RTC_SERVER_URL = `https://i4a407.p.ssafy.io:9001/demos/dashboard/`;
      // var nickname = localStorage.getItem('nickname');
      window.open(
        `${VUE_RTC_SERVER_URL}?gId=${this.gId}&nickname=${this.loginStatus.nickname}`,
        '_blank'
      );
    },
  },
};
</script>
<style></style>
