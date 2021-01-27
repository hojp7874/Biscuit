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
            <td v-bind="title">{{ title }}</td>
          </tr>
          <tr>
            <th>내용</th>
            <td class="txt_cont" v-bind="contents">{{ contents }}</td>
          </tr>
        </table>
      </form>
    </div>

    <div class="btnWrap">
      <b-button @click="fnList" class="btnList m-1">목록</b-button>
      <b-button v-if="email" @click="fnUpdate" class="btnUpdate m-1"
        >수정</b-button
      >
      <b-button v-if="email" @click="fnDelete" class="btnDelete m-1"
        >삭제</b-button
      >
    </div>
    <div>
      <reply-write :bId="bId" />
      <reply-list v-for="(reply,index) in list" :reply="list[index]" :key="index" />
      <b-pagination v-model="replyPage" pills :total-rows="pageCnt" align="center" ></b-pagination><!--여깁니다-->
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import ReplyWrite from '../Reply/ReplyWrite.vue';
import ReplyList from '../Reply/ReplyList.vue';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
   components: {
    ReplyWrite,
    ReplyList,
  },
  data() {
    return {
      form: '',
      bId: this.$route.query.bId,
      email: '',
      title: '',
      contents: '',
      noticeFlag: '',
      date: '',
      category: '',
            
      list : [],
      replyPage : 1,
      pageCnt : 1
    };
  },
   created() {
    this.getList();
  },
  mounted() {
    this.fnGetView();
  },
  methods: {
    fnGetView() {
      this.$axios
        .get(`${SERVER_URL}/board/read`, {
          params: { type: 'bId', word: this.$route.query.bId },
        })
        .then((res) => {
          this.title = res.data.list[0].title;
          this.contents = res.data.list[0].contents;
          this.email = res.data.list[0].email;
          this.noticeFlag = res.data.list[0].noticeFlag;
          this.date = res.data.list[0].date;
          this.category = res.data.list[0].category;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    fnList() {
      this.$router.push({ path: './BoardList' });
    },
    fnUpdate() {
      this.form = {
        bId: this.bId,
        email: this.email,
        title: this.title,
        contents: this.contents,
        noticeFlag: this.noticeFlag,
        date: this.date,
        category: this.category,
      };
      this.$router.push({ path: './BoardUpdate', query: this.form });
    },
    fnDelete() {
      if (confirm('정말로 삭제하시겠습니까?')) {
        axios
          .delete(`${SERVER_URL}/board/delete`, {
            headers: {
              bId: this.bId,
            },
          })
          .then((res) => {
            if (res.data.success === 'success') {
              // alert('게시글이 삭제 되었습니다.');
              this.fnList();
            } else {
              alert('게시글 삭제에 실패하셨습니다.');
            }
          })
          .catch(function (error) {
            console.log(error);
          });
      }
    },
    getList() {
      console.log("getList IN : "+this.$route.query.bId);
      this.$axios
        .get(`${SERVER_URL}/reply/list`, {
          params: {page: this.replyPage, bId: this.$route.query.bId},
        })
        .then((res) => {
          console.log(res.data);
          this.list = res.data["list"];
          console.log(res.data["list"]);
          this.pagination = res.data["pagination"];
          this.pageCnt = this.pagination.pageCnt;
        })
        .catch((err) => {
          console.log(err);
        });
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
