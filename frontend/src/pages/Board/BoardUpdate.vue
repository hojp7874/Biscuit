<template>
  <div>
    <div>
      <div class="content-center brand">
        <img class="n-logo" src="img/bisWhite.png" alt="" />
        <div>
          <br><br>
          <center>
          <h1>게시판 수정</h1>
          <div class="UpdateWrap" style="width: 80%">
            <form>
              <table class="tbAdd" width="100%">
                <colgroup>
                  <col width="20%" />
                  <col width="80%" />
                </colgroup>
                <tr>
                  <th>제목</th>
                  <td>
                    <!-- v-model 양뱡향데이터전송으로 상세 데이터 넣어준다 -->
                    <input type="text" v-model="title" ref="title" />
                  </td>
                </tr>
                <tr>
                  <th>내용</th>
                  <td><textarea v-model="contents" ref="contents"  @input="counting()" ></textarea></td>
                </tr>
              </table>
              <!-- <div >글자수 : <span>{{count}}</span> / 5000</div> -->
            </form>
          </div>

          <div class="btnWrap">
            <b-button @click="fnList" class="btnList m-1">취소</b-button>
            <b-button @click="fnModProc" class="btnReset m-1">확인</b-button>
          </div>
          </center>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  data() {
    return {
      temptitle: '',
      bId: this.$route.query.bId,
      email: this.$route.query.email,
      title: this.$route.query.title,
      contents: this.$route.query.contents,
      noticeFlag: 0,
      date: this.$route.query.date,
      category: this.$route.query.category,
      count : 0,
    };
  },

  mounted() {
    //최초 로딩 시 실행

  },
  methods: {
    fnList() {
      this.$router.push({ path: './BoardList' });
    },
    // fnGetView() {
    //   console.log(this.$route.query);
    //   this.$axios
    //     .get('http://i4a407.p.ssafy.io:8877/a407/board/update')
    //     .then((res) => {
    //       this.title = res.data.list[0].title;
    //       //console.log(this.title);
    //       this.contents = res.data.list[0].contents;
    //       //console.log(this.contents);
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    // },
    fnView() {
      this.$router.push({ path: './BoardRead', query: { bId: this.bId } }); //추가한 상세페이지 라우터
    },
    fnAddProc() {
      this.form = {
        bId: this.bId,
        email: this.email,
        title: this.title,
        contents: this.contents,
        noticeFlag: this.noticeFlag,
        category: this.category,
      };

        this.$axios
        .post(`${SERVER_URL}/board/update`, this.form)
        .then((res) => {
          if (res.data.success) {
            alert('등록되었습니다.');
            this.fnList();
          } else {
            alert('실행중 실패했습니다.\n다시 이용해 주세요');
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    fnModProc() {
      this.temptitle = this.title.replace(/ /g, '');
      if (!this.temptitle || !this.temptitle.trim()) {
        alert('제목을 입력해 주세요');
        this.$refs.title.focus(); //방식으로 선택자를 찾는다.
        return;
      }
      if (!this.contents || !this.contents.trim()) {
        alert('내용을 입력해 주세요');
        this.$refs.contents.focus(); //방식으로 선택자를 찾는다.
        return;
      }

      this.form = {
        title: this.title,
        contents: this.contents.length>5000? this.contents.substr(0,5000): this.contents,
        noticeFlag: this.noticeFlag,
        category: this.category,
        bId: this.bId,
        email: this.email
      };
      this.$axios
        .put(`${SERVER_URL}/board/update`, this.form)
        .then((res) => {
          if (res.data.success) {
            // console.log("########################")
            console.log(res)
            alert('수정되었습니다.');
            this.fnView();
          } else {
            alert('실행중 실패했습니다.\n다시 이용해 주세요');
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    counting(){
      this.count = this.contents.length;
      if(this.count >5000){
        this.contents = this.contents.substr(0,5000);
      }
    }
  },
};
</script>

<style scoped>
.tbAdd {
  border-top: 1px solid #888;
}
.tbAdd th,
.tbAdd td {
  border-bottom: 1px solid #eee;
  padding: 5px 0;
}
.tbAdd td {
  padding: 10px 10px;
  box-sizing: border-box;
}
.tbAdd td input {
  width: 100%;
  min-height: 30px;
  box-sizing: border-box;
  padding: 0 10px;
}
.tbAdd td textarea {
  width: 100%;
  min-height: 300px;
  padding: 10px;
  box-sizing: border-box;
}
.btnWrap {
  text-align: center;
  margin: 20px 0 0 0;
}
</style>
