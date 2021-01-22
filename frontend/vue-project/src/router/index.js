import Vue from "vue";
import VueRouter from "vue-router";
import BoardList from "../components/board/BoardList.vue";
import BoardWrite from "../components/board/BoardWrite.vue";
import BoardRead from "../components/board/BoardRead.vue";
import BoardUpdate from "../components/board/BoardUpdate.vue";
import GroupCreate from "../components/Group/GroupCreate.vue";
import CommentList from "../components/comment/CommentList.vue";
import GroupList from "../components/Group/GroupList.vue";

Vue.use(VueRouter);

const routes = [

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
    path: "/boardupdate",
    name: "BoardUpdate",
    component: BoardUpdate
  },
  {
    path: "/groupcreate",
    name: "GroupCreate",
    component: GroupCreate
  },
  {
    path: "/commentList",
    name: "CommentList",
    component: CommentList
  },
  {
    path: "/grouplist",
    name: "GroupList",
    component: GroupList
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
