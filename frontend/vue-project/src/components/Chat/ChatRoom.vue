<template>
  <div class="container" id="app" v-cloak>
    <div>
      <h2>{{ room.roomName }}</h2>
    </div>
    <ul class="list-group">
      <li class="list-group-item" v-for="message in messages" v-bind:key="message.id">
        <a>{{ message.email }} - {{ message.message }}</a>
      </li>
    </ul>
    <div class="input-group">
      <div class="input-group-prepend">
        <label class="input-group-text">내용</label>
      </div>
      <input type="text" class="form-control" v-model="message" v-on:keypress.enter="sendMessage" />
      <div class="input-group-append">
        <button class="btn btn-primary" type="button" @click="sendMessage">보내기</button>
      </div>
    </div>
    
    <div></div>
  </div>
</template>

<script>
import axios from 'axios';
import SockJS from 'sockjs-client';
import Stomp from 'stomp-websocket';

export default {
  data() {
    return {
      roomId: '',
      room: {},
      email: '',
      messages: [],
      message: null,
      reconnect: '',
    };
  },
  created() {
    this.reconnect = 0;
    this.roomId = localStorage.getItem('wschat.roomId');
    this.email = localStorage.getItem('wschat.email');
    this.findRoom();
    this.loadMessages();
    this.connect();
  },
  methods: {
    loadMessages: function() {
      axios
        .get('http://localhost:7788/a407/chat/messages', {
          params: {
            roomId: this.roomId,
          },
        })
        .then((res) => {
          this.messages = res.data.data;
        });

    },
    findRoom: function() {
      axios
        .get('http://localhost:7788/a407/chat/search', {
          params: {
            roomId: this.roomId,
          },
        })
        .then((res) => {
          this.room = res.data.data.sort((a,b) => {return a.msgId - b.msgId});
          console.log('###room : ' + res.data.data);
        });
    },
    sendMessage: function() {
      console.log('###sendMsg start');
      this.ws.send(
        '/pub/chat/message',
        {},
        JSON.stringify({
          type: 'TALK',
          roomId: this.roomId,
          email: this.email,
          message: this.message,
        })
      );

      console.log('###sendMsg end');
      this.message = '';
    },
    recvMessage: function(recv) {
      console.log('###recv msg : ' + recv.message);
      // this.messages.unshift({
      //   type: recv.type,
      //   email: recv.type == 'ENTER' ? '[알림]' : recv.email,
      //   message: recv.message,
      // });
      this.messages.push(recv)
    },
    // {"Access-Control-Allow-Credentials" : true}
    connect: function() {
      this.sock = new SockJS('http://localhost:7788/a407/ws-stomp');
      this.ws = Stomp.over(this.sock);
      this.reconnect = 0;
      console.log('a');
      // pub/sub event
      this.ws.connect(
        {},
        (frame) => {
          console.log('###connect start');
          this.ws.subscribe(
            '/sub/chat/room/' + this.roomId,
            function(message) {
              var recv = JSON.parse(message.body);
              console.log('###receive start. recv : ' + recv);
              console.log('###frame : ' + frame);
              this.recvMessage(recv);
              console.log('###received.');
            }.bind(this)
          );
          console.log(
            '###send start. json msg : ' +
              JSON.stringify({ type: 'ENTER', roomId: this.roomId, email: this.email })
          );
          this.ws.send(
            '/pub/chat/message',
            {},
            JSON.stringify({ type: 'ENTER', roomId: this.roomId, email: this.email, message: null })
          );
          console.log('###send end');
        },
        function(error) {
          if (this.reconnect++ <= 5) {
            setTimeout(function() {
              console.log('##connection reconnect' + error);
              this.sock = new SockJS('/ws-stomp');
              this.ws = Stomp.over(this.sock);
              this.connect();
            }, 10 * 1000);
          }
        }
      );
    },
  },
  mounted() {},
};
</script>
