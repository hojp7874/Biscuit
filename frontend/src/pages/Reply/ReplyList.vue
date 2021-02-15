<template>
      <b-row class="mb-1">
        <b-col>
          <div border-variant="info" class="row" no-body style="background-color:#f0f0f0; min-height:80px; border-radius:10px;">
            <div class="col-md-1 col-sm-1"> <img src="img/ryan.jpg" class="rounded-circle" style="margin-top:15px" alt="" /> </div>
            <div class="col-md-11" style="padding:0px"> 
                <div class="text-left" 
                  ><div class="d-flex align-items-center" style="margin-top:10px; padding:0">
                   
                    <strong style="margin-right:10px">{{items.nickname}}</strong>
                    <small>({{items.date}})</small>
                  </div>
                </div>
                <b-col class="text-right" v-show="user.email===items.email" >
                  <b-button @click="modifyClick" variant="link">수정</b-button>
                  <b-button @click="deleteReplyConfirm" variant="link">삭제</b-button>
                </b-col>
          
            <!-- </template> -->
            <hr style="margin:0px;">
            <div class="text-left">
              <div id="viewcomment" v-show="isView" v-html="items.contents.replace(/(?:\r\n|\r|\n)/g, '<br />')" style=" margin-top:10px; margin-right:30px; margin-bottom:10px; font-size:10pt">
                <!-- {{items.contents}} -->
              </div>

              <div id="modifyinput" v-show="!isView">
                <b-form @submit="onSubmit">
                  <b-row class="mb-3 mt-2">
                    <b-col cols="11">
                      <b-form-textarea
                        id="modicontents"
                        v-model="modicontents"
                        placeholder="댓글을 입력하세요."
                        rows="2"
                      ></b-form-textarea>
                    </b-col>
                    <b-col><b-button type="submit" variant="dark">수정</b-button> </b-col> 
                  </b-row>
                </b-form>
              </div>
            </div>
            </div>

            <!-- <template> -->
               
             
          </div>
        </b-col>
      </b-row>
</template>

<script>
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "ReplyList",
  props : { reply : {} },
  data() {
    return {
      isView : true,
      modicontents : "",
      user : {
        nickname : localStorage.getItem("nickname"),
        email : localStorage.getItem("email")  //"ssafy@ssafy.com", //로그인 되어있는 유저 이메일 -> 현재 로그인 되어있는 유저로 바꿔야함
      },
      // items : [],
    }
  },
  props: ['items'],
  computed: {
    // itmes: function() {
    //   return this.$props.reply;
    // }
  },
  created() {
    // console.log(this.$props.reply)
    // this.items = this.$props.reply;
  },
  methods: {
    modifyClick(){
      this.modicontents = this.items.contents;
      this.isView = !this.isView;
    },
    onSubmit(event) {
      event.preventDefault();
      console.log("수정 : "+this.user.email +" / "+this.modicontents+" / "+this.rId);

      if(this.modicontents == '' || this.modicontents.trim() ==""){
         alert('작성된 댓글 내용이 존재하지 않습니다.');
      }else{
        this.$axios
        .put(`${SERVER_URL}/reply/update`, {
          email : this.user.email,
          contents : this.modicontents.length>300? this.modicontents.substr(0,300): this.modicontents,
          rId : this.items.rId
        })
        .then((res) => {
          if (res.data.success) {
            alert('수정되었습니다.');
            this.$router.go(this.$router.currentRoute);
          } else {
            alert('실행중 실패했습니다.\n다시 이용해 주세요');
          }
        })
        .catch((err) => {
          console.log(err);
        });
      }
    },
    deleteReplyConfirm() {
      if(confirm("정말로 삭제하시겠습니까?")){
        this.deleteReply();
      }
    },
    deleteReply(){
      console.log("삭제 메소드");
      this.$axios
      .delete(`${SERVER_URL}/reply/delete`, {params: {rId : this.items.rId}})
      .then((res) => {
        if (res.data.success) {
          alert('삭제되었습니다.');
          this.$router.go(this.$router.currentRoute);
        } else {
          alert('실행중 실패했습니다.\n다시 이용해 주세요');
        }
      })
      .catch((err) => {
        console.log(err);
      })
    }
  },
};
</script>

<style>
#viewcomment {
  margin-left: 30px;
  margin-bottom: 10px;
}
</style>