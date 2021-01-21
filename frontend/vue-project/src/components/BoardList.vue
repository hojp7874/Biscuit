<template>
  <div>
    <h2>자유 게시판</h2>

    <div class="searchWrap">
      <b-select name="type" v-model="type" style="width:80px">
        <b-select-option value="" selected="selected" disabled hidden
          >전체</b-select-option
        >
        <b-select-option value="id">작성자</b-select-option>
        <b-select-option value="title">제목</b-select-option>
        <b-select-option value="word">내용</b-select-option>
      </b-select>
      <input type="text" v-model="keyword" @keyup.enter="fnSearch" />
      <b-button @click="fnSearch" class="btnSearch m-1">검색</b-button>
    </div>

    <div class="listWrap">
      <table class="tbList" width="100%">
        <colgroup>
          <col width="6%" />
          <col width="*" />
          <col width="10%" />
          <col width="15%" />
        </colgroup>

        <tr>
          <th>no</th>
          <th>제목</th>
          <th>아이디</th>
          <th>날짜</th>
        </tr>
        <tr v-for="(row, idx) in list" :key="idx">
          <td>{{ row.bid }}</td>
          <td class="txt_left"><a href="javascript:;" @click="fnView(`${row.bid}`)">{{ row.title }}</a></td>
          <td>{{ row.nickname }}</td>
          <td>{{ row.date }}</td>
        </tr>
        <tr v-if="list.length == 0">
          <td colspan="4">등록된 게시 글이 없습니다.</td>
        </tr>
      </table>
    </div>

    <div class="pagination" v-if="paging.totalCount > 0">
      <a href="javascript:;" @click="fnPage(1)" class="first">&lt;&lt;</a>
      <a
        href="javascript:;"
        v-if="paging.start_page > 10"
        @click="fnPage(`${paging.start_page - 1}`)"
        class="prev"
        >&lt;</a>
      <template v-for="(n, index) in paginavigation()">
        <template v-if="paging.page == n">
          <strong :key="index">{{ n }}</strong>
        </template>
        <template v-else>
          <a href="javascript:;" @click="fnView(`${n}`)" :key="index">
            {{ n }}</a>
        </template>
      </template>
      <a
        href="javascript:;"
        v-if="paging.total_page > paging.end_page"
        @click="fnPage(`${paging.end_page + 1}`)"
        class="next"
        >&gt;</a>
      <a
        href="javascript:;"
        @click="fnPage(`${paging.total_page}`)"
        class="last"
        >&gt;&gt;</a
      >
    </div>

    <div class="btnRightWrap">
      <b-button @click="fnAdd" class="btnAdd m-1">등록</b-button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    //변수생성
    return {
      form: '',
      type:'',
      body: '', //리스트 페이지 데이터전송
      board_code: 'news', //게시판코드
      list: '', //리스트 데이터
      templist: '',
      no: '', //게시판 숫자처리
      paging: '', //페이징 데이터
      start_page: '', //시작페이지
      page: this.$route.query.page ? this.$route.query.page : 1,
      keyword: this.$route.query.keyword,
      paginavigation: function() {
        //페이징 처리 for문 커스텀
        var pageNumber = [];
        var start_page = this.paging.start_page;
        var end_page = this.paging.end_page;
        for (var i = start_page; i <= end_page; i++) pageNumber.push(i);
        return pageNumber;
      },
    };
  },
  mounted() {
    //페이지 시작하면은 자동 함수 실행
    this.fnGetList();
  },
  methods: {
    fnGetList() {
      this.form = {
        type: '',
        word: '',
        currentPage: '',
        category: '',
      };

      axios.get('http://localhost:8877/a407/board/read', {params: this.form}).then(res=>{
             this.templist =  res.data.list;
              this.list = this.templist.sort((a,b) =>  a.date - b.date);
      })


      // axios.get('http://localhost:8877/a407/board/read').then((response) => {
      //   console.log(response.data.count);
      //   this.totalpage = response.data.count;
      //   if (this.totalpage == 0) {
      //     this.haslist = false;
      //   } else {
      //     console.log(this.totalpage);
      //     this.totalpage = this.totalpage / 5 + 1;
      //     this.haslist = true;
      //   }
      // });
      // if (this.haslist) {
      //   this.pageno = this.$route.query.pageno;
      //   axios
      //     .get('http://localhost:8877/a407/board/read', {
      //       params: {
      //         nowPage: this.pageno,
      //         word: this.word,
      //         type: '',

      //       },
      //     })
      //     .then((response) => {
      //       if (response.data.success === 'fail') {
      //         this.haslist = false;
      //       } else {
      //         this.haslist = true;
      //         this.noticelist = response.data.list;
      //         console.log(response.data.list);
      //         for (let notice of this.noticelist) {
      //           console.log(notice.date);
      //         }
      //       }
      //     })
      //     .catch(function(error) {
      //       console.log(error);
      //     });
      // }
    },
    fnAdd() {
      this.$router.push('./BoardWrite');
    },
    getList() {
      this.$axios
        .get('http://localhost:3000/api/board')
        .then((res) => {
          console.log(res);
        })
        .then((err) => {
          console.log(err);
        });
    },
     fnView(num) {
      // this.body.num = num;
      console.log(num);
			this.$router.push({path:'./BoardRead',query:{bId: num}}); //추가한 상세페이지 라우터
	},
    fnSearch() {
      //검색
      this.paging.page = 1;
      this.fnGetList();
    },
    fnPage(n) {
      //페이징 이
      if (this.page != n) {
        this.page = n;
        this.fnGetList();
      }
    },
  },
};
</script>

<style scoped>
.searchWrap {
  width: 100%;
  border-radius: 5px;
  text-align: center;
  padding: 20px 0;
  margin-bottom: 40px;
}
.searchWrap input {
  width: 60%;
  height: 36px;
  border-radius: 3px;
  padding: 0 10px;
  border: 1px solid #888;
}
.searchWrap .btnSearch {
  display: inline-block;
  height: 36px;
}
.tbList th {
  border-top: 1px solid #888;
}
.tbList th,
.tbList td {
  border-bottom: 1px solid #eee;
  padding: 5px 0;
}
.tbList td.txt_left {
  text-align: left;
}
.btnRightWrap {
  text-align: right;
  margin: 10px 0 0 0;
}

.pagination {
  margin: 20px 0 0 0;
  text-align: center;
}
.first,
.prev,
.next,
.last {
  border: 1px solid #666;
  margin: 0 5px;
}
.pagination span {
  display: inline-block;
  padding: 0 5px;
  color: #333;
}
.pagination a {
  text-decoration: none;
  display: inline-blcok;
  padding: 0 5px;
  color: #666;
}
</style>
