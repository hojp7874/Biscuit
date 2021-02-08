<template>
  <div>
    <div>
      <p></p>
      <ul class="list-group">
        <li
          class="list-group-item list-group-item-action"
          v-for="item in applys"
          v-bind:key="item.mId"
          v-on:click="applyList()"
        >
          {{ item.nickname }}
          <b-button 
          @click="accept(item.mId)"
          >
          승인
          </b-button>
          <b-button
          @click="deny(item.mId)"
          >
          거절
          </b-button>
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      applys: Object,
    };
  },
  created() {
    this.applyList();
  },
  props: {
    gId: String,
  },
  methods: {
    applyList: function() {
      console.log('gId : ' + this.gId);
      axios
        .get(`${SERVER_URL}/group/member/apply/group/list`, {
          params: {
            gId: this.gId,
          },
        })
        .then((res) => {
          this.applys = res.data.list;
        });
    },
    accept: function(mid) {
      axios
        .put(`${SERVER_URL}/group/member/accept`, {
          mId : mid
        })
        .then((res) =>{
            if(res.data.success == "success"){
                this.applyList();            
            }
        });
    },
    deny: function(mid) {
      axios
        .put(`${SERVER_URL}/group/member/deny`, {
          mId : mid
        })
        .then((res) =>{
            if(res.data.success == "success"){
                this.applyList();            
            }
        });
    },
  },
};
</script>
