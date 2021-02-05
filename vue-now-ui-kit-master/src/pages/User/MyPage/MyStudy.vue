<template>
<div>
  <center>
   <h2 style="font-weight:bold ; margin-top:30px"> 나의 스터디</h2>
    </center>
   <b-card-group
        deck
        class="d-flex flex-row"
      >
        <b-col cols="3"
          v-for="(group, idx) in myGroups"
          :key="idx"
          :group="group"
        >
          <!-- @click="goDetail(group)" -->
            <!-- v-b-modal.group-13 -->
          <b-card
            @click="goGroupPage(group)"
            v-bind:title="group.groupName"
            :img-src="group.img"
            img-alt="Image"
            img-top
          >
            <b-card-text>
              {{group.groupDesc}}
            </b-card-text>
            <template #footer>
              <small class="text-muted">Last updated 3 mins ago</small>
            </template>
          </b-card>
          <b-modal
            :id="'group-'+idx"
            size="xl"
            :title="''+group.groupName"
          >
          </b-modal>
        </b-col>
      </b-card-group>
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
            console.log("길이길이: " + res.data.list.length);
            // this.$emit('studyNum',res.data.list.length);
            this.loginStatus.myStudyNum = res.data.list.length;
            //console.log("dd" + loginStatus.myStudyNum);
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