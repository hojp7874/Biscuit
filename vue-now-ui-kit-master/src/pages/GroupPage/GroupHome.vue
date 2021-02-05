<template>
<div id="group-page" class="container">
         <div id="group-info" class="row">
          <div id="group-picture" class="col-md-2">
            <img
              class="rounded-circle img-fluid img-raised"
              src="https://placekitten.com/300/300"
              alt="group profile img"
            />
          </div>
          <div id="group-profile" class="col-md-6">
            <p style="text-align:left;font-size:40px;margin-left:30px">
              그룹 이름 : {{ group.groupName }}
            </p>
            <p style="text-align:left;font-size:14px;margin-left:30px">
              그룹 설명 : {{ group.groupDesc }}
            </p>
           <p style="text-align:left;font-size:14px;margin-left:30px">
              카테고리 : {{ group.category }}
            </p>
            <p style="text-align:left;font-size:14px;margin-left:30px">지역 : {{ group.region }}</p>
          </div>
        </div>
</div>
</template>
<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
    data() {
    return {
      group: Object,
    };
  },
  created() {
      this.getGroup();
  },
  props: {
    gId: String,
  },
  methods :{
          getGroup: function() {
      axios
        .get(`${SERVER_URL}/group/list/`, {
          params: {
            word: this.gId,
            type: 'gId',
          },
        })
        .then((res) => {
          this.group = res.data.list[0];
        })
        .catch((err) => {
          console.log(err);
        });
    },
  }
}
</script>