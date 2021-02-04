<template>
<div>
 <center style="font-size: 30px; margin-top:30px">나의 일정</center>
 <center>
  <Schedule v-on:createSchedule="createSchedule" v-on:getSchedule="getSchedule" :scheduleType="mySchedule" :items="items"/>
 </center>
</div>
</template>
<script>

import Schedule from '../../components/Schedule';
import { Button, FormGroupInput } from '@/components';
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data:function(){
    return{
    mySchedule :'mySchedule',
    list:[],
    items:[],
    color:'',
    cnt:0,
    }
  },
  components : {
    Schedule,
      [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
  },

  methods: {
    getSchedule(){
      this.form = { email: localStorage.getItem('email') };
      axios
        .get(`${SERVER_URL}/schedule/perlist`, {
          params: this.form,
        })
        .then((res) => {
          this.list = res.data.list;
          this.items =[];
          this.insertItems();
          console.log('ㅎㅇ');
          console.log('아이템' + this.list.length);
        });
    },
    createSchedule(data){
      console.log(data);
      axios
          .post(`${SERVER_URL}/schedule/create`, data)
          .then((response) => {
            if (response.data.success === 'success') {
              alert('일정 등록에 성공하셨습니다.');
              this.getSchedule();
            } else alert('일정 등록에 실패하셨습니다.');
            //window.location.reload();
            //this.back();
          })
          .catch(function(error) {
            console.log(error);
          });
    },
    insertItems() {
      console.log('아이템z' + this.list.length);
      for (var i in this.list) {
        // this.items[i].id = 'e' + this.list[i].sId;
        // this.items[i].startDate = this.list[i].sdate;
        // this.items[i].endDate = this.list[i].edate;
        // this.items[i].title = this.list[i].title;
        if(this.list[i].sId % 10 === 0){
          this.color = "pink"
        }else if(this.list[i].sId % 10 === 1){
          this.color=""
        }else if(this.list[i].sId % 10 === 2){
          this.color = "purple"
        }else if(this.list[i].sId % 10 === 3){
          this.color = "orange"
        }else if(this.list[i].sId % 10 === 4){
          this.color = "mint"
        }else if(this.list[i].sId % 10 === 5){
          this.color = "lemon"
        }else if(this.list[i].sId % 10 === 6){
          this.color = "red"
        }else if(this.list[i].sId % 10 === 7){
          this.color = "green"
        }else if(this.list[i].sId % 10 === 8){
          this.color = "nureng"
        }else if(this.list[i].sId % 10 === 9){
          this.color = "ocean"
        }
        this.items.push({
          id: 'e' + this.list[i].sId,
          startDate: this.list[i].sdate,
          endDate: this.list[i].edate,
          title: this.list[i].title,
          url:'#',
          classes: this.color
        });
      }
    },
  },
}
</script>