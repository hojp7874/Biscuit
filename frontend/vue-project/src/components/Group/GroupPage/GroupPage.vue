<template>
<div>
  <h4 :group="group">{{group.groupName}}</h4>
</div>
</template>
<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  data() {
    return {
      group: Object,
      gId: this.$route.query.gId,
    };
  },
  created() {
      this.getGroup();
  },
  methods: {
    getGroup: function() {
      axios
        .get(`${SERVER_URL}/group/list/`, { params: {
            word : this.gId,
            type : 'gId',
            }})
        .then((res) => {
          this.group = res.data.list[0];
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>
