<template>
  <div>
    <div v-if="isLoading === false" class="loading">
      <b-spinner
        class="my-5"
        style="width: 10rem; height: 10rem; border: 1em solid currentColor; border-right-color: transparent;"
        label="Large Spinner"
      ></b-spinner>
      <h2>로딩 중 ...</h2>
    </div>
    <div v-else>
        <div class="row">
        <div class="col-md-6">
      <h3>신청자 목록</h3>
      <ul class="list-group">
        <li
          class="list-group-item list-group-item-action"
          v-for="item in applys"
          v-bind:key="item.mId"
        >
          <div 
            class="d-flex justify-content-between align-items-center"
          >
            <span>
              {{ item.nickname }}
            </span>
            <span>
              신청합니다
            </span>
            <div>
              <b-button @click="accept(item.mId)">
                승인
              </b-button>
              <b-button @click="deny(item.mId)">
                거절
              </b-button>
            </div>
          </div>
        </li>
      </ul>
      </div>
      <div class="col-md-6">
      <h3>스터디원 목록</h3>
      <ul class="list-group">
        <li
          class="list-group-item list-group-item-action"
          v-for="item in members"
          v-bind:key="item.mId"
        >
          <div 
            class="d-flex justify-content-between align-items-center"
          >
            <span>
              {{ item.nickname }}
            </span>            
            <div v-if="item.permission != 3"> 
              <b-button @click="[updateState(item.mId, 3), updateState(mId, 1)]">
                그룹장 위임
              </b-button>
              <b-button @click="kick(item.mId)">
                추방
              </b-button>
            </div>
          </div>
        </li>
      </ul>
      </div>
        </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios';

import { mapState } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      isLoading: false,
      applys: Object,
      members: Object,
       groupPagePath : "/grouppage?gId=" + this.gId,
       mId: Number
    };
  },
  created() {
    this.applyList();
    this.memberList();
  },
  
  computed: {
    ...mapState(['loginStatus']),
  },
  props: {
    gId: String,
  },
  methods: {
    memberList: function() {
      console.log('gId : ' + this.gId);
      axios
        .get(`${SERVER_URL}/group/member/list`, {
          params: {
            gId: this.gId,
          },
        })
        .then((res) => {
            if(res.data.success == 'success'){

            for(const item in res.data.list){
                if(res.data.list[item].nickname == this.loginStatus.nickname){
                    this.mId = res.data.list[item].mId;
                    console.log(this.mId);
                }
            }
          this.members = res.data.list;
            }
        });
      this.isLoading = true;
    },
    updateState: function(mid, state) {
      axios
        .put(`${SERVER_URL}/group/member/permission`, {
          mId: mid,
          permission : state
        })
        .then((res) => {
          if (res.data.success == 'success') {
               this.$router.go(this.$router.currentRoute);
          }
        });
    },
    kick: function(mid) {
      axios
        .put(`${SERVER_URL}/group/member/kick`, {
          mId: mid,
        })
        .then((res) => {
          if (res.data.success == 'success') {
               this.$router.go(this.$router.currentRoute);
          }
        });
    },
    applyList: function() {
      console.log('gId : ' + this.gId);
      axios
        .get(`${SERVER_URL}/group/member/apply/group/list`, {
          params: {
            gId: this.gId,
          },
        })
        .then((res) => {
            
          if (res.data.success == 'success') {
          this.applys = res.data.list;
          }
        });
      this.isLoading = true;
    },
    accept: function(mid) {
      axios
        .put(`${SERVER_URL}/group/member/accept`, {
          mId: mid,
        })
        .then((res) => {
          if (res.data.success == 'success') {
               this.$router.go(this.$router.currentRoute);
          }
        });
    },
    deny: function(mid) {
      axios
        .put(`${SERVER_URL}/group/member/deny`, {
          mId: mid,
        })
        .then((res) => {
          if (res.data.success == 'success') {
               this.$router.go(this.$router.currentRoute);
          }
        });
    },
  },
};
</script>
