import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import BoardList from "../components/Board/BoardList.vue";
import BoardWrite from "../components/Board/BoardWrite.vue";
import BoardRead from "../components/Board/BoardRead.vue";
import BoardUpdate from "../components/Board/BoardUpdate.vue";
import GroupCreate from "../components/Group/GroupCreate.vue";
import GroupList from "../components/Group/GroupList.vue";
import GroupUpdate from "../components/Group/GroupUpdate.vue";
import GroupPage from "../components/Group/GroupPage/GroupPage.vue";
import Join from "../components/User/Join.vue"
import FindPw from "../components/User/FindPw.vue"
import Login from "../components/User/Login.vue";
import MyPage from "../components/User/MyPage.vue";
import ChatRoomList from "../components/Chat/ChatRoomList.vue";
import ChatRoom from "../components/Chat/ChatRoom.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/boardlist",
    name: "BoardList",
    component: BoardList
  },
  {
    path: "/boardwrite",
    name: "BoardWrite",
    component: BoardWrite
  },
  {
    path: "/boardread",
    name: "BoardRead",
    component: BoardRead
  },
  {
    path: "/groupcreate",
    name: "GroupCreate",
    component: GroupCreate
  },
  {
    path: "/boardupdate",
    name: "BoardUpdate",
    component: BoardUpdate
  },
  {
    path: "/grouplist",
    name: "GroupList",
    component: GroupList
  },
  {
    path: "/grouppage",
    name: "GroupPage",
    component: GroupPage
  },
  {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: "/join",
    name: "Join",
    component: Join
  },
  {
    path: "/findpw",
    name: "FindPw",
    component: FindPw
  },
  {
    path: "/mypage",
    name: "MyPage",
    component: MyPage
  },
  {
    path: "/groupupdate",
    name: "GroupUpdate",
    component: GroupUpdate
  },
  {
    path: "/chatroomlist",
    name: "ChatRoomList",
    component: ChatRoomList
  },
  {
    path: "/chatroom",
    name: "ChatRoom",
    component: ChatRoom
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
