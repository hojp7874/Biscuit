import Vue from 'vue'
import App from './App.vue'
import router from './router'
import VModal from 'vue-js-modal'
Vue.use(VModal, { dynamic: true })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router, 
  components: { App }, 
  template: '<App/>'
})
 