<template>
  <div class="home">
    <h1 class=m-5>메인페이지입니당</h1>
    <GroupList />
  </div>
</template>

<script>
import GroupList from '@/components/Group/GroupList'

// @ is an alias to /src
export default {
  name: "Home",
  components: {
    GroupList
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
        window.location.reload();
    },
  },
  
};
</script>
