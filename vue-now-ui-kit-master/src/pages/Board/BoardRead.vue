<template>
  <div>
    <div>
      <div class="content-center brand">
        <img class="n-logo" src="img/bisWhite.png" alt="" />
        <div class="container">
          <br /><br />
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
                  <th>작성자</th>
                  <td v-bind="nickname">{{ nickname }}</td>
                </tr>
                <!-- <tr>
                  <th>내용</th>
                  <td class="txt_cont" v-bind="contents">{{ contents }}</td>
                </tr> -->
              </table>
                            <Viewer v-if="contents != null" :initialValue="contents" />

            </form>
          </div>

          <div class="btnWrap d-flex justify-content-center">
            <b-button @click="fnList" class="btn btnList m-1">목록</b-button>
            <div v-if="loginStatus.nickname == nickname">
              <b-button
                v-if="email"
                @click="fnUpdate"
                class="btn-info btnUpdate m-1"
                >수정</b-button
              >
              <b-button
                v-if="email"
                @click="fnDelete"
                class="btn-danger btnDelete m-1"
                >삭제</b-button
              >
            </div>
          </div>
          <ReplyWrite :bId="bId" v-if="this.loginStatus.nickname" />
          <div>
            <ReplyList
              v-for="(reply, index) in showList"
              :reply="reply"
              :key="index"
            />
            <b-pagination
              v-model="replyPage"
              pills
              :total-rows="pageCnt"
              per-page="10"
              align="center"
            ></b-pagination
            ><!--여깁니다-->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import axios from 'axios';
import ReplyWrite from '../Reply/ReplyWrite.vue';
import ReplyList from '../Reply/ReplyList.vue';
import "codemirror/lib/codemirror.css"; 
import "@toast-ui/editor/dist/toastui-editor.css";
import { Viewer } from "@toast-ui/vue-editor";

// import { getBoardDetailAPI } from '@/api/index';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  components: {
    ReplyWrite,
    ReplyList,
    Viewer,
  },
  data() {
    return {
      form: '',
      bId: this.$route.query.bId,
      email: '',
      nickname: '',
      title: '',
      contents: null,
      noticeFlag: '',
      date: '',
      category: '',

      list: [],
      replyPage: '',
      pageCnt: '',
    };
  },
  computed: {
    ...mapState(['loginStatus']),
    showList: function() {
      return this.list.slice(10 * (this.replyPage - 1), 10 * this.replyPage);
    },
  },
  created() {
    this.getList();
    // this.getPage();
  },
  mounted() {
    this.fnGetView();
    //   getBoardDetailAPI({
    //   params: {
    //     docNo: this.$route.query.docNo,
    //   },
    // })
    //   .then(response => {
    //     this.$refs.viewer.setContent(response.data.content)
    //   })
    //   .catch(error => {
    //     console.log(error)
    //   })
  },
  methods: {
    changePage: function() {
      this.showList = this.list.slice(
        10 * (this.replyPage - 1),
        10 * this.replyPage
      );
      // console.log(this.replyPage)
      // console.log(temporaryList)
    },
    fnGetView() {
      this.$axios
        .get(`${SERVER_URL}/board/read`, {
          params: { type: 'bId', word: this.$route.query.bId },
        })
        .then((res) => {
          this.title = res.data.list[0].title;
          this.contents = res.data.list[0].contents;
          this.email = res.data.list[0].email;
          this.nickname = res.data.list[0].nickname;
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
        nickname: this.nicknmae,
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
              alert('게시글이 삭제 되었습니다.');
              this.fnList();
            } else {
              alert('게시글 삭제에 실패하셨습니다.');
            }
          })
          .catch(function(error) {
            console.log(error);
          });
      }
    },
    getList() {
      console.log('getList IN : ' + this.$route.query.bId);
      this.$axios
        .get(`${SERVER_URL}/reply/list`, {
          params: { page: 1, bId: this.$route.query.bId },
        })
        .then((res) => {
          console.log('######');
          console.log(res.data);
          this.list = res.data['list'];
          // console.log(res.data["list"]);
          this.pageCnt = this.list.length;
        })
        .catch((err) => {
          console.log(err);
        });
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
