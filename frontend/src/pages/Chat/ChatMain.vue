<template>
<div>
    <br/>
    <div class="section">
      <div class="container">
        <div class="button-container">
        <button v-on:click="loadChatRoomList();" class="btn btn-primary" type="button" style="background-color:rgb(40, 24, 83)">방 목록</button>
        <button v-on:click="loadChatFriendList()" class="btn btn-primary" type="button" style="background-color:rgb(40, 24, 83)">멤버 목록</button>
        </div>
        <component :is="componentLoading()" v-bind:mode="mode"></component>
      </div>
    </div>
</div>
</template>

<script>

import ChatRoomList from './ChatRoomList';
import ChatFriendList from './ChatFriendList';
import { mapState } from 'vuex';
export default {
    name: 'chatmain',
  bodyClass: 'chatmain-page',
  data() {
    return {
      user: {
        email: '',
        nickname: '',
        picture: '',
        region: '',
        phone: '',
      },
      active: 0,
      mode: 0,
    };
  },
      created() {
    this.user.region = localStorage.getItem('region');
    this.user.email = localStorage.getItem('email');
    this.user.nickname = localStorage.getItem('nickname');
    this.user.phone = localStorage.getItem('phone');
  },
  computed: {
    ...mapState(['loginStatus']),
  },
  components: {
      ChatRoomList,
      ChatFriendList,
  },
  methods: {
    componentLoading() {
      console.log("component change");
      switch (this.active) {
        case 0:
          return 'ChatRoomList';
        case 1:
          return 'ChatFriendList';
      }
    },
    
    loadChatRoomList() {
      this.active = 2;
      this.active = 0;
      this.mode = 0;
    },
    loadChatFriendList() {
      this.active = 1;
    },
  }
}
</script>