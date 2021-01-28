<template>
  <div id="app">
    <!-- 추가된 헤더 컴포넌트 사용 -->
    <Header v-on:logout="logout"></Header>


    <div class="container">
      <router-view />
    </div>
    
    <!-- 추가된 풋터 컴포넌트 사용 -->
    <Footer />
  </div>
</template>

<script>
import Header from './components/Header'; //import 헤더 추가
import Footer from './components/Footer'; //import 풋터 추가
// import axios from 'axios';
// const SERVER_URL = process.env.VUE_APP_LOCAL_SERVER_URL;

export default {
  name: 'App',
  computed: {
    LoginStatus: function() {
      if (localStorage.getItem('email') !== null) {
        return true
      } else {
        return false
      }
    }
  },
  components: {
    Header,          //헤더 컴포넌트 추가
    Footer
  },
  methods: {
    logout() {
      console.log("로그아웃 테스트");
        if (localStorage.getItem('token') !== null) {
          localStorage.removeItem('token');
          localStorage.removeItem('id');
          localStorage.removeItem('name');
          localStorage.removeItem('admin');
        }
        // this.$router.replace('/');
        // window.location.reload();
        this.$router.push('/');
        window.location.reload();
    },
  },
}
</script>

<style>
html,body{padding:0; margin:0;}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin:0; padding:0;
}
</style>