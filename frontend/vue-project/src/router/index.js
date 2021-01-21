import Vue from "vue";
import VueRouter from "vue-router";
<<<<<<< HEAD
import Home from "../components/Home.vue";
import BoardList from "../components/BoardList.vue";
import BoardWrite from "../components/BoardWrite.vue";
import BoardRead from "../components/BoardRead.vue";
=======
import Home from "../views/Home.vue";
import BoardList from "../views/BoardList.vue";
import BoardWrite from "../views/BoardWrite.vue";
import BoardRead from "../views/BoardRead.vue";
import GroupCreate from "../views/GroupCreate.vue";
>>>>>>> 0e406f9731f544a478e9d1f5e9590f68bc01e641

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
    name: "groupCreate",
    component: GroupCreate
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
