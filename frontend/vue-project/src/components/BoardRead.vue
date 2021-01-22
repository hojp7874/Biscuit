<template>
  <div>
    <h1>게시판 상세보기</h1>

    <div class="AddWrap">
      <form>
        <table class="tbAdd" width="100%">
          <colgroup>
            <col width="20%" />
            <col width="80%" />
          </colgroup>
          <tr>
            <th>제목</th>
            <td v-bind="title"> {{title}}</td>
          </tr>
          <tr>
            <th>내용</th>
            <td class="txt_cont" v-bind="contents">{{contents}}</td>
          </tr>
        </table>
      </form>
    </div>

    <div class="btnWrap">
      <b-button @click="fnList" class="btnList m-1">목록</b-button>
      <b-button v-if="userid" @click="fnUpdate" class="btnUpdate m-1">수정</b-button>
      <b-button v-if="userid" @click="fnDelete" class="btnDelete m-1">삭제</b-button>
    </div>

    <div class="commentWrap">
      댓글
    </div>
  </div>
</template>

<script>

import axios from 'axios';

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  data() {
    return {
      body: this.$route.query,
      title: '',
      contents: '',
      view: '',
    //   userid:this.$route.query.userid,
    userid:'hello',
      num: this.$route.query.num,
    };
  },
  mounted() {
    this.fnGetView();
  },
  methods: {
    fnGetView() {
       this.form = {
        type: 'bId',
        word: this.$route.query.bId,
      };
     console.log(this.$route.query.bId);
      this.$axios
        .get('http://localhost:8877/a407/board/read', {
          params: this.form,
        })
        .then((res) => {
          this.title = res.data.list[0].title;
          console.log(this.title);
          this.contents = res.data.list[0].contents;
          console.log(this.contents);

        })
        .catch((err) => {
          console.log(err);
        });
    },
    fnList() {
      delete this.body.num;
      this.$router.push({ path: './BoardList', query: this.body });
    },
    fnUpdate() {
        delete this.body.num;
      this.$router.push({ path: './BoardWrite', query: this.body });
    },
    fnDelete() {
        if (confirm('정말로 삭제하시겠습니까?')) {
        axios
          .delete(`${SERVER_URL}/notice/delete/`, {
            headers: {
              num: this.detail.num,
            },
          })
          .then((response) => {
            if (response.data.success === 'success') {
              alert('공지 삭제에 성공하셨습니다.');
              this.$router.push({ path: 'noticelist', query: { pageno: 1 } });
            } else {
              alert('공지 삭제에 실패하셨습니다.');
            }
          })
          .catch(function(error) {
            console.log(error);
          });
      }
    },
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
  text-align: left;
}
.tbAdd td.txt_cont {
  height: 300px;
  vertical-align: top;
}
.btnWrap {
  text-align: center;
  margin: 20px 0 0 0;
}
</style>
