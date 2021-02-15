<template>
  <div>
    <div class="page-header clear-filter" filter-color="orange">
      <parallax
        class="page-header-image"
        style="background-image:url('img/header.jpg')"
      >
      </parallax>
          
      <div class="content-center brand">
        <img class="n-logo" src="img/bisWhite.png" alt="" />
        <h2 class="h2-seo">스터디 그룹 페이지 입니다</h2>
        <h3>비스킷에서 전국 39291개의 스터디를 찾고 함께 공부하세요</h3>
        <div class="searchWrap">
          <b-input-group>
            <template #prepend>
            <b-input-group>
              <b-select name="type" style="border-radius:30px" v-model="params.type">
                <b-select-option value="groupName">스터디 이름</b-select-option>
                <b-select-option value="groupDesc">스터디 설명</b-select-option>
                <b-select-option value="category">카테고리</b-select-option>
                <b-select-option value="region">지역</b-select-option>
              </b-select>
            </b-input-group>
            </template>

            <b-form-input type="text" style="border-radius:10px; color:white; background-color:#11111155" v-model="params.word" @keypress.enter="searchGroup"></b-form-input>
            <b-input-group-append>
              <b-button class="mt-0" style="border-radius:10px" text="Button" variant="primary" @click="searchGroup">검색<i class="now-ui-icons ui-1_zoom-bold" style="margin-left:10px"></i></b-button>
            </b-input-group-append>
          </b-input-group>
        </div>
         <div><i class="now-ui-icons arrows-1_minimal-down"></i></div>
      </div>
    </div>
    <div class="col-md-8">
    </div>
    <div class="container" style="margin-top:50px">
      <div class="row">
        <div class="col-md-8">
          <button class="btn col-md-8">wowwow</button>
        </div>
      </div>
      <div v-if="loginStatus.nickname">
        <div role="alert" class="alert alert-info">
          <div class="container">
            <div class="alert-icon"><i class="now-ui-icons travel_info"></i></div>
              <h3 class="btn-lg" v-if="existMyGroups">{{loginStatus.nickname}}님의 스터디 목록입니다</h3>
          </div>
        </div>
        <button class="btn-lg" v-if="existMyGroups">{{loginStatus.nickname}}님의 스터디 목록입니다!!</button>
        <h3 v-if="!existMyGroups" class="text-center">현재 가입한 스터디가 없습니다</h3>
        <b-card-group
          deck
          class="d-flex flex-row"
        >
          <b-col cols="4"
            v-for="(group, idx) in myGroups"
            :key="idx"
            :group="group"
          >
            <b-card
              @click="goGroupPage(group)"
              v-bind:title="group.groupName"
              :img-src="group.img"
              img-alt="Image"
              img-top
              class="my-3"
            >
              <b-card-text>
                {{group.groupDesc}}
              </b-card-text>
              <template #footer>
                <small class="text-muted"></small>
              </template>
            </b-card>
          </b-col>
        </b-card-group>
      </div>
      <div class="d-flex justify-content-end">
        <b-button v-show="loginStatus.email" variant="primary" @click="goCreate">스터디생성</b-button>
      </div>
      <hr>
      <h3 class="text-center"> <i class="now-ui-icons loader_refresh"></i>새로운 스터디를 찾아보세요</h3>


      <div class="container">
        <div class="row">
    
        <div class="col-12 col-sm-6 col-md-4 col-lg-4"
          v-for="(group, idx) in groups.slice().reverse()"
          :key="idx"
          :group="group"
        >
          <!-- @click="goDetail(group)" -->
            <!-- v-b-modal.group-13 -->
            
          <b-card
            data-aos="flip-left"
            @click="$bvModal.show(`group-${idx}`), getPermission(group.gId), getPicture(group.email)"
            :img-src="group.img"
            img-alt="Image"
            img-top
            class="my-3"
          >
            <b-card-text>
              <h3 style="font-size:20px; color:#000000; margin-right:5px">{{group.groupName}}</h3>
              <h5 style="font-size:14px;  color:#000000; margin-right:5px"><i style="margin-right:5px" class="now-ui-icons business_badge"></i> {{group.nickname}}</h5>
              <span class="badge badge-info" style="font-size:12px; font-weight:bold; color:#FFFFFF; margin-right:5px"><i class="now-ui-icons users_single-02"></i> {{ group.max }}</span>
              <!-- <b>온라인 여부: {{ group.onoff }}</b><br> -->
              <!-- <b>모집기간: {{ group.edate }}</b><br> group.nickname-->
              <span class="badge badge-success" style="font-size:12px; color:#FFFFFF; margin-right:5px"><i class="now-ui-icons location_pin"></i> {{ group.region }}</span>
              <span class="badge badge-primary" style="font-size:12px; color:#FFFFFF; margin-right:5px"><i class="now-ui-icons location_bookmark"></i> {{ group.category }}</span>
              <span class="badge badge-danger" style="font-size:12px; color:#FFFFFF; margin-right:5px"><i class="now-ui-icons ui-1_calendar-60" id="dday"></i> {{ group.edate }}</span>
              <!-- <b>모임 주기: {{ group.cycle }}</b> -->
            </b-card-text>
            <template #footer>
              <!-- <small class="text-muted">Last updated 3 mins ago</small> -->
            </template>
          </b-card>
          <b-modal
            :id="'group-'+idx"
            hide-footer
            size="lg"
            :title="''+group.groupName"
          >
            <!-- hide-header -->
            <div>
            
              <div class="bannerImg jumbotron-image clear-filter" filter-color="black" style="position:relative">
              <img :src="group.img" alt="">
                  <div style=" font-size: 1.8em; font-weight: bold; color:white; position: absolute;">
                     {{group.groupName}}
                  </div>
              </div>
               <h3 class="text-center">{{group.groupName}}</h3>
                <div class="content-center brand">
                  <div class="jumbotron text-white jumbotron-image shadow">
                    <div class="content-center brand">
                      <div class="content-center">
                        <div class="col-md-4"><img class="rounded-circle" :src="picture" alt="" id="pic"></div>
                        <div class="col-md-5"><h4>{{group.nickname}}</h4></div>
                        <h5>모집인원: {{ group.max }}명</h5>
                        <p>온라인 여부: {{ group.onoff }}</p>
                        <p>모집기간: {{ group.edate }}</p>
                        <p>지역: {{ group.region }}</p>
                        <p>모임 주기: {{ group.cycle }}</p>
                      </div>
                      <div>
                        <b-button id="none" @click="applyGroup(group.gId,group.email,group.groupName)" pill variant="primary">스터디 참가하기</b-button>
                        <b-button id="wait" @click="removeApply(group.gId)" pill variant="secondary">스터디 참가 신청 취소하기</b-button>
                        <b-button id="mine" pill variant="primary">당신의 스터디 그룹입니다</b-button>
                        <b-button id="ban" pill variant="danger">당신은 이 스터디에서 추방되었습니다</b-button>
                        <b-button v-if="!loginStatus.token" @click="goLogIn()" pill variant="secondary">스터디에 참여하려면 로그인 해주세요</b-button>
                      </div>
                    </div>
                  <hr style="height:50px">
                  <p v-html="group.groupDesc.replace(/(?:\r\n|\r|\n)/g, '<br />')"></p><!--{{ group.groupDesc }}-->
                </div>
              </div>

              <hr>

              <div v-if="group.nickname == loginStatus.nickname" class="d-flex justify-content-end">
                <form action="" method="post" @submit.prevent="updateGroup(group.gId)">
                  <b-button type="submit" pill variant="warning">스터디 정보 수정하기</b-button>
                </form>
                <form action="" method="post" @submit.prevent="deleteGroup(group.gId)">
                  <b-button type="submit" pill variant="danger">스터디 삭제하기</b-button>
                </form>
              </div>
            </div>
          </b-modal>
        </div>
        </div>
     </div> 




    </div>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  import axios from 'axios'
  
  const SERVER_URL = process.env.VUE_APP_SERVER_URL


  import VueMoment from 'vue-moment'
 


  export default {
    name: "Group",
    components: {
    },
    data() {
      return {
        picture: '',
        params: {
          type: 'groupName',
          word: '',
        },
        groups: [],
        myGroups: [],
        permission: '',
        existMyGroups: false,
      }
    },
    created() {
      this.myGroupList();
      this.groupList();

    },
    computed: {
      ...mapState([
        'loginStatus',
      ]),
    },
    methods: {
      searchGroup: function() {
        console.log('searchGroup')
        axios.get(`${SERVER_URL}/group/list/`, {params: this.params})
          .then(res => {
            for (let i = 0; i < res.data.list.length; i++) {
              res.data.list[i].edate = res.data.list[i].edate.split(' ')[0];
            }
            this.groups = res.data.list;
          })
          .catch(err => {
            console.log(err)
          })
      },
      getPermission: function(gId) {
        console.log({gId: gId, nickname: this.loginStatus.nickname})
        axios.get(`${SERVER_URL}/group/member/apply/state`, {params: {gId: gId, nickname: this.loginStatus.nickname}})
          .then(res => {
            console.log(`state:${res.data.state}`)
            const none = document.querySelector("#none")
            const wait = document.querySelector("#wait")
            const mine = document.querySelector("#mine")
            const ban = document.querySelector("#ban")
            if (this.loginStatus.token == null) {
              none.style.display = "none"
              wait.style.display = "none"
              mine.style.display = "none"
              ban.style.display = "none"
            } else if (res.data.state == 0 || res.data.state == 4) {
              none.style.display = "none"
              wait.style.display = "block"
              mine.style.display = "none"
              ban.style.display = "none"
            } else if (res.data.state == 1 || res.data.state == 3) {
              none.style.display = "none"
              wait.style.display = "none"
              mine.style.display = "block"
              ban.style.display = "none"
            } else if (res.data.state == 5) {
              none.style.display = "none"
              wait.style.display = "none"
              mine.style.display = "none"
              ban.style.display = "block"
            } else {
              none.style.display = "block"
              wait.style.display = "none"
              mine.style.display = "none"
              ban.style.display = "none"

            }
          })
          .catch(err => {
            console.log(err)
            const none = document.querySelector("#none")
            const wait = document.querySelector("#wait")
            const mine = document.querySelector("#mine")
            const ban = document.querySelector("#ban")
            none.style.display = "none"
            wait.style.display = "none"
            mine.style.display = "none"
            ban.style.display = "none"
          })
      },
      getPicture(email) {
        axios.get(`${SERVER_URL}/user/profile`, {params: {email: email}})
          .then(res => {
            const picture = res.data.User.picture
            if(picture == null) {
              this.picture = "https://images.unsplash.com/photo-1519400197429-404ae1a1e184?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=80"
            } else {
              this.picture = picture
            }

         })
         .catch(err => {
           console.log(err)
         })

      },
      removeApply: function(gId) {
        axios.delete(`${SERVER_URL}/group/member/cancel`,
        {data: {gId: gId, nickname: this.loginStatus.nickname}})
         .then(res => {
           console.log(res)
           const none = document.querySelector("#none")
           const wait = document.querySelector("#wait")
           none.style.display = "block"
           wait.style.display = "none"
         })
         .catch(err => {
           console.log(err)
         })
      },
      applyGroup: function(gId,email,groupname) {
        axios.post(`${SERVER_URL}/group/member/apply`,
        {gId: gId, email: this.loginStatus.email, nickname: this.loginStatus.nickname})
          .then(res => {
            console.log(res)
            const none = document.querySelector("#none")
            const wait = document.querySelector("#wait")
            none.style.display = "none"
            wait.style.display = "block"
          })
          .catch(err => {
            console.log(err)
          })

        this.$axios
          .post(`${SERVER_URL}/notification/create`, {
            receiveEmail : email,
            sendEmail :  this.loginStatus.email,
            isRead : 0,
            type : 'apply',
            contentId : gId,
            message : this.loginStatus.nickname + ' 님이 [' + groupname + ']에 참가 신청을 하였습니다.',
            notiUrl : '/GroupPage?gId=' + gId,
          })
          .then((res) => {
            if (res.data.success) {
              console.log("receiveEmail >>> "+email);
              // alert('등록되었습니다.');
            } else {
              console.log('알림 전송 실패');
            }
          })
          .catch((err) => {
            console.log(err);
          });
      },
      goCreate: function() {
        // const data = [item]
        this.$router.push({path: './GroupCreate'})
      },
      goDetail: function(group) {
        this.$router.push({path: './GroupDetail', query: {gId: group.gId}})
      },
      updateGroup: function(gId) {
        this.$router.push({path: './GroupUpdate', query: { gId: gId}})
      },
      deleteGroup: function(gId) {
        axios.delete(`${SERVER_URL}/group/delete/`, {headers: {gId: gId}})
          .then(res => {
            console.log(res)
            console.log(this.idx)
            //임시방편
            window.location.reload();
            // 모달창 닫기
            let targetModal = document.querySelector('#group-'+this.idx)
            console.log(targetModal)
            // 리스트에서 해당 스터디
          })
          .catch(err => {
            console.log(err)
          })
      },
      goGroupPage: function(myGroup) {
        this.$router.push({ path: './GroupPage', query: { gId: myGroup.gId } });
      },
      myGroupList: function() {
        axios.get(`${SERVER_URL}/group/member/apply/user/list`, {
            params: {
              email: this.loginStatus.email,
            },
          })
          .then((res) => {
            // console.log(res)
            if (res.data.list.length != 0) {
              this.existMyGroups = true
            }
            this.myGroups = res.data.list;
          })
          .catch((err) => {
            console.log(err);
          });
      },
      groupList: function() {
        axios
          .get(`${SERVER_URL}/group/list/`, { params: this.params })
          .then((res) => {
            for (let i = 0; i < res.data.list.length; i++) {
              res.data.list[i].edate = res.data.list[i].edate.split(' ')[0];
            }
            this.groups = res.data.list;
          })
          .catch((err) => {
            console.log(err);
          });

    
      },
      goLogIn: function(){
        this.$router.push({ path: './login' });
      },
    }
  }

  function counter(dates){
    var dday2=dates;
//var dday = new Date("Apr 7,2018,09:00:00").getTime(); //디데이
		var dday = new Date("Jun 10,2020,23:59:59").getTime(); //디데이
		setInterval(function(){
			var now = new Date(); //현재 날짜 가져오기
			var distance = dday - now;
			var d = Math.floor(distance / (1000 * 60 * 60 * 24));
			var h = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
			var m = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
			var s = Math.floor((distance % (1000 * 60)) / 1000);
			var view = '';
			if(s < 10){
				s = '0'+s;
			}
			if (distance<0) {
				//$('#dday-view').html('마감되었습니다.');
			//	$('#dday-div').hide();
			} else {
				if (d>0) {
					view = view+d+'일 ';
				}
				if (h>0) {
					view = view+h+'시간 ';
				}
				if (m>0) {
					view = view+m+'분 ';
				}
				$('#dday-view').html(view);
        document.getElementById('dday').value = view;
			}
		}, 1000);
	}
	counter();
</script>

<style scoped>
.jumbotron{
  background-image: url(https://images.unsplash.com/photo-1552152974-19b9caf99137?fit=crop&w=1350&q=80) ;
}

.bannerImg{
  width: 100%;
  height: 300px;
  overflow: hidden;
}
</style>
