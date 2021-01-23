import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../components/Home.vue";
import BoardList from "../components/Board/BoardList.vue";
import BoardWrite from "../components/Board/BoardWrite.vue";
import BoardRead from "../components/Board/BoardRead.vue";
import BoardUpdate from "../components/Board/BoardUpdate.vue";
import GroupCreate from "../components/Group/GroupCreate.vue";
import GroupList from "../components/Group/GroupList.vue";
import GroupDetail from "../components/Group/GroupDetail.vue";
import GroupUpdate from "../components/Group/GroupUpdate.vue";

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
    path: "/groupupdate",
    name: "GroupUpdate",
    component: GroupUpdate
  },
  {
    path: "/groupdetail",
    name: "GroupDetail",
    component: GroupDetail
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
