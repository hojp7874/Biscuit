<template>
  <div id="app">
    <router-view name="header" v-on:logout="logout"/>
    <div class="wrapper">
      <router-view />
    </div>
    <router-view name="footer" />
  </div>
</template>
<script>
export default {
  beforeDestroy() {
    window.addEventListener('beforeunload', this.logout()) // logs to my logger)
    // document.addEventListener('beforeunload', this.leaving)
    // document.onbeforeunload = function() {
    //   return alert('정말 나가시겠습니까?')
    // }
  },
  // beforeDestroy() {
  //   this.logout()
  // },
  methods: {
    logout() {
      console.log("로그아웃 테스트");
        if (localStorage.getItem('token') !== null) {
          localStorage.removeItem('token');
          localStorage.removeItem('email');
          localStorage.removeItem('nickname');
          localStorage.removeItem('admin');
          localStorage.removeItem('phone');
          localStorage.removeItem('region');
          localStorage.removeItem('picture');
        }
        this.$router.push('/');
        window.location.reload();
    },
  },
};
</script>