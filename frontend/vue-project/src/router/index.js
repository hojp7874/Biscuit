import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import BoardList from "../views/BoardList.vue";
import BoardWrite from "../views/BoardWrite.vue";
import BoardRead from "../views/BoardRead.vue";

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
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
