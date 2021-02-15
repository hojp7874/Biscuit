<template>
  <div class="container" id="app" v-cloak>
    <div class="row">
      <div>
        <h2>닉네임 : {{ nickname }}</h2>
      </div>
      <div class="col-md-12">
        <h3>채팅방 리스트</h3>
      </div>
    </div>
    
    <div class="input-group">
      <b-input-group>
      <b-form-input style="border-radius:10px" type="text" v-model="searchName"  placeholder="이름을 검색해주세요"/>
      
    </b-input-group>
    </div>
    
<!-- eslint-disable vue/no-use-v-if-with-v-for,vue/no-confusing-v-for-v-if -->
    <ul class="list-group">
      <li
        class="list-group-item list-group-item-action"
        v-for="item in chatrooms"
        v-if="item.roomName.includes(searchName)"
        v-bind:key="item.roomId"
        v-on:click="enterRoom(item.roomId)"
      >
        {{ item.roomName }}
      </li>
    </ul>
  </div>
</template>
<script>
import axios from 'axios';

import { mapState } from 'vuex';
const CHAT_SERVER_URL = process.env.VUE_APP_CHAT_SERVER_URL;
export default {
  data() {
    return {
      room_name: '',
      chatrooms: [
        {
          key: 'roomId',
          label: '방 id',
        },
        {
          key: 'roomName',
          label: '방 이름',
        },
      ],
      user: {
        email: '',
        nickname: '',
        picture: '',
        region: '',
        phone: '',
      },
      nickname: '',
      searchName: '',
      type: 'title',
    };
  },
  created() {

    
    this.user.region = localStorage.getItem('region');
    this.user.email = localStorage.getItem('email');
    this.user.nickname = localStorage.getItem('nickname');
    this.user.phone = localStorage.getItem('phone');

    this.findAllRoom();
    this.nickname = localStorage.getItem('nickname');
  },
  
  computed: {
    ...mapState(['loginStatus']),
  },
  methods: {
    findAllRoom: function() {
      axios.get(`${CHAT_SERVER_URL}/chat/myroom`,
      {
        params:{
          email : this.user.email
        }
      }).then((res) => {
        this.chatrooms = res.data.data;
      });
    },
    
    enterRoom: function(roomId) {
      if (this.nickname != '') {
        localStorage.setItem('wschat.roomId', roomId);
        this.$router.push({ path: 'chatroom', querey: { roomId: roomId } });
      }
    },
    
  },
};
</script>
