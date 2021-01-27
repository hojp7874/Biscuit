import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import BootstrapVue from 'bootstrap-vue'
import axios from 'axios'; //axios 호출

import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)
Vue.config.productionTip = true;

Vue.prototype.$axios = axios; //전역변수로 설정 컴포넌트에서 this.$axios 호출할 수 있음


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
