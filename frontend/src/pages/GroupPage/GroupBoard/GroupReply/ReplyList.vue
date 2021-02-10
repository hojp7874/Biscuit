<template>
      <b-row class="mb-1">
        <b-col>
          <b-card border-variant="info" class="mb-2" no-body>
            <!-- <template> -->
              <b-row class="m-1">
                <b-col class="text-left ml-3" 
                  ><div class="d-flex align-items-center">
                    <i class="now-ui-icons users_circle-08"></i>
                    <strong>{{items.nickname}}</strong>
                    <small>({{items.date}})</small>
                  </div>
                </b-col>
                <b-col class="text-right mr-3" v-show="user.email===items.email" >
                  <b-button @click="modifyClick" variant="link">수정</b-button>
                  <b-button @click="deleteReplyConfirm" variant="link">삭제</b-button>
                </b-col>
              </b-row>
            <!-- </template> -->
            <b-card-body class="text-left">
              <div id="viewcomment" v-show="isView">
                {{items.contents}}
              </div>

              <div id="modifyinput" v-show="!isView">
                <b-form @submit="onSubmit">
                  <b-row class="mb-3 mt-2">
                    <b-col cols="11">
                      <b-form-textarea
                        id="modicontents"
                        v-model="modicontents"
                        placeholder="댓글 입력을 입력하세요."
                        rows="2"
                      ></b-form-textarea>
                    </b-col>
                    <b-col><b-button type="submit" variant="dark">수정</b-button> </b-col> 
                  </b-row>
                </b-form>
              </div>
            </b-card-body>
          </b-card>
        </b-col>
      </b-row>
</template>

<script>
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  props : ['items'],
  data() {
    return {
      isView : true,
      modicontents : "",
      user : {
        nickname : localStorage.getItem("nickname"),
        email : localStorage.getItem("email")  //"ssafy@ssafy.com", //로그인 되어있는 유저 이메일 -> 현재 로그인 되어있는 유저로 바꿔야함
      },
    }
  },
  created() {
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
        .put(`${SERVER_URL}/greply/update`, {
          email : this.user.email,
          contents : this.modicontents,
          rId : this.items.rId,
          gId : this.items.gId,
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
      .delete(`${SERVER_URL}/greply/delete`, {params: {rId : this.items.rId}})
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