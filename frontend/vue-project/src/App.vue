<template>
  <div id="app">
    <!-- 추가된 헤더 컴포넌트 사용 -->
    <Header />

    <div class="container"> <!-- class 추가 -->
      <router-view />
    </div>
    
    <!-- 추가된 풋터 컴포넌트 사용 -->
    <Footer />
  </div>
</template>

<script>
import Header from './components/Header'; //import 헤더 추가
import Footer from './components/Footer'; //import 풋터 추가

export default {
  name: 'App',
  components: {
    Header          //헤더 컴포넌트 추가
   ,Footer
    
  }
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