<template>
<div>
  <center>
   <h2 style="font-weight:bold ; margin-top:30px"> 나의 스터디</h2>
    </center>

     <div class="row">

        

     


          <b-col class="col-12 col-sm-12 col-md-6 col-lg-4"
            v-for="(group, idx) in myGroups"
            :key="idx"
            :group="group"
          >
            <b-card
              @click="goGroupPage(group)"
              class="my-3"
              style="min-height:400px; max-height:400px; min-width:350px; overflow:hidden"
            >
            <div style="max-height:200px; min-height:200px; width:100%; overflow:hidden; ">
               <b-card-img :src="group.img" alt="Image" style=" z-index:2;" top></b-card-img>
               
            </div>
               <b-card-body>
                  <b-card-title style="font-size:23px; font-weight:bold; color:#222; margin-right:5px; margin-bottom:10px; white-space: nowrap; overflow: hidden; text-overflow:ellipsis;">{{group.groupName}}</b-card-title>
      <b-card-sub-title class="mb-2">{{group.groupName}}</b-card-sub-title>
      <b-card-text style="padding:10px">
        {{group.nickname}}
      </b-card-text>
    </b-card-body>
            
              <b-card-text>
                {{group.groupDesc}}
              </b-card-text>
              <template #footer>
                <!-- <small class="text-muted">Last updated 3 mins ago</small> -->
              </template>
               
            </b-card>
          </b-col>

      </div>

   </div>
</template>

<script>
 import {mapState} from 'vuex'
  import axios from 'axios'
//   import card from '@/components/Cards/Card'
  const SERVER_URL = process.env.VUE_APP_SERVER_URL

export default {
   data() {
      return {
        params: {
          type: '',
          word: '',
        },
        groups: Object,
        myGroups: Object,
        permission: '',
      }
    },
   components: {
      // card
    },
    computed: {
      ...mapState([
        'loginStatus','myStudyNum'
      ]),
    },
   created() {
      this.myGroupList();
    },
   methods:{
      myGroupList: function() {
        axios
          .get(`${SERVER_URL}/group/member/apply/user/list`, {
            params: {
              email: this.loginStatus.email,
            },
          })
          .then((res) => {
            this.myGroups = res.data.list;
            // this.$emit('studyNum',res.data.list.length);
            this.loginStatus.myStudyNum = res.data.list.length;
          })
          .catch((err) => {
            console.log(err);
          });
      },
      goGroupPage: function(myGroup) {
        this.$router.push({ path: './GroupPage', query: { gId: myGroup.gId } });
      },
   }
}
</script>