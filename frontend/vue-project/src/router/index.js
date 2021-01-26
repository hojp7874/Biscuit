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
import Join from "../components/User/Join.vue"
import FindPw from "../components/User/FindPw.vue"
import Login from "../views/Login.vue";


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
    path: "/groupupdate",
    name: "GroupUpdate",
    component: GroupUpdate
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
