<template>

    <div class="container" id="app" v-cloak>
        <div class="row">
            <div class="col-md-12">
                <h3>채팅방 리스트</h3>
            </div>
        </div>
        <div class="input-group">
            <div class="input-group-prepend">
                <label class="input-group-text">방제목</label>
            </div>
            <input type="text" class="form-control" v-model="room_name" v-on:keyup.enter="createRoom">
            <div class="input-group-append">
                <button class="btn btn-primary" type="button" @click="createRoom">채팅방 개설</button>
            </div>
        </div>
        <ul class="list-group">
            <li class="list-group-item list-group-item-action" v-for="item in chatrooms" v-bind:key="item.roomId" v-on:click="enterRoom(item.roomId)">
                {{item.roomName}}
            </li>
        </ul>
    </div>

</template>
    <script>
    import axios from "axios";
    export default{
        data(){
            return{
                room_name : '',
                chatrooms: [
                    {
                        key: 'gId',
                        label: '그룹 id'
                    },
                    {
                        key: 'roomId',
                        label: '방 id'
                    },
                    {
                        key: 'roomName',
                        label: '방 이름'
                    }
                ]
            }
        },
            created() {
                this.findAllRoom();
            },
            methods: {
                findAllRoom: function() {
                    axios.get('http://localhost:7788/a407/chat/rooms').then(res => { this.chatrooms = res.data.data; });
                },
                createRoom: function() {
                    this.form = {
                        roomId : null,
                        roomName : this.room_name,
                        gId : "9999"
      };
                    if("" === this.room_name) {
                        alert("방 제목을 입력해 주십시요.");
                        return;
                    } else {
                        axios
                        .post('http://localhost:7788/a407/chat/room', this.form)
                        .then((res) => {
                                alert(res.data.data.roomName+"방 개설에 성공하였습니다.")
                                this.room_name = '';
                                this.findAllRoom();
                            }
                        )
                        .catch( res => { alert(res.data.roomId + "채팅방 개설에 실패하였습니다."); } );
                    }
                },
                enterRoom: function(roomId) {
                    var email = prompt('대화명을 입력해 주세요.');
                    if(email != "") {
                        localStorage.setItem('wschat.email',email);
                        localStorage.setItem('wschat.roomId',roomId);
                        this.$router.push({path: 'chatroom', querey: {roomId: roomId}});
                    }
                }
            }
    }
    </script>