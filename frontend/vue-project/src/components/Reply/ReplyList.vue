<template>
  <!-- <ol>
    <oi v-for="(reply) in list" :key={reply}> -->
      <b-row class="mb-1">
        <b-col>
          <b-card border-variant="info" class="mb-2" no-body>
            <!-- <template> -->
              <b-row class="m-1">
                <b-col class="text-left ml-3" 
                  ><strong>{{items.email}}</strong> ({{items.date}})
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
    <!-- </oi>
    <oi>
      {{this.isView}}
    </oi>
  </ol> -->
</template>

<script>
export default {
  name: "ReplyList",
  props : { reply : {} },
  data() {
    return {
      items : {
        bId : "",
        email : "",
        contents : "",
        date : "",
        rId : Number,
      },
      isView : true,
      modicontents : "",
      user : {
        email : "ssafy@ssafy.com", //로그인 되어있는 유저 이메일 -> 현재 로그인 되어있는 유저로 바꿔야함
      },
      items2 : [],
    }
  },
  created() {
    this.items.rId = this.$props.reply.rId;
    this.items.bId = this.$props.reply.bId;
    this.items.email = this.$props.reply.email;
    this.items.contents = this.$props.reply.contents;
    this.items.date = this.$props.reply.date;
    this.items2 = this.$props.reply;
    console.log(this.items2);
    console.log(this.items.rId);
  },
  methods: {
    modifyClick(){
      this.isView = !this.isView;
    },
    onSubmit(event) {
      event.preventDefault();
      console.log("수정 : "+this.user.email +" / "+this.modicontents+" / "+this.rId);
      this.$axios
      .put('http://localhost:8877/a407/reply/update', {
        email : this.user.email,
        contents : this.modicontents,
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
    },
    deleteReplyConfirm() {
      if(confirm("정말로 삭제하시겠습니까?")){
        this.deleteReply();
      }
    },
    deleteReply(){
      console.log("삭제 메소드");
      this.$axios
      .delete('http://localhost:8877/a407/reply/delete', {params: {rId : this.items.rId}})
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