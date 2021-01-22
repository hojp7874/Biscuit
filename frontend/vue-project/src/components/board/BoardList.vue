<template>
  <div>
    <h2>자유 게시판</h2>

    <div class="searchWrap">
      <b-select name="type" v-model="type" style="width:80px">
        <b-select-option value="" selected="selected" disabled hidden
          >전체</b-select-option
        >
        <b-select-option value="email">작성자</b-select-option>
        <b-select-option value="title">제목</b-select-option>
        <b-select-option value="contents">내용</b-select-option>
      </b-select>
      <input type="text" v-model="word" @keyup.enter="fnSearch" />
      <b-button @click="fnSearch" class="btnSearch m-1">검색</b-button>
    </div>

    <div class="listWrap">
      <b-table
        id="my-table"
        :items="list"
        :per-page="perPage"
        :fields="column"
         :current-page="currentPage"
        @row-clicked="rowClick"
      ></b-table>

      <b-pagination
        v-model="currentPage"
        :total-rows="this.list.length"
        :per-page="perPage"
        aria-controls="my-table"
      ></b-pagination>
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
      column: [
        // 'Bid', 'Title', 'Date'
        {
          key: 'bid',
          label: '순번',
        },
        {
          key: 'title',
          label: '제목',
        },
        {
          key: 'email',
          label: '작성자',
        },
        {
          key: 'date',
          label: '작성일',
        },
      ],
      perPage: 10,
      form: '',
      body: '', //리스트 페이지 데이터전송
      // board_code: 'news', //게시판코드
      list: '', //리스트 데이터
      type: '',
      word: '',
      currentPage: this.$route.query.page ? this.$route.query.page : 1,
      category: '',
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
  computed: {},
  mounted() {
    //페이지 시작하면은 자동 함수 실행
    this.fnGetList();
    
  },
  methods: {
    fnGetList() {
      this.form = {
        type: this.type,
        word: this.word,
        currentPage: '',
        category: '',
      };

      axios
        .get('http://localhost:8877/a407/board/read', { params: this.form })
        .then((res) => {
          this.list = res.data.list.sort((a,b) => {return b.bid - a.bid});
          console.log(this.list.length);
        });
    },

    fnAdd() {
      this.$router.push('./BoardWrite');
    },

    fnView(num) {
      // this.body.num = num;
      this.$router.push({ path: './BoardRead', query: { bId: num } }); //추가한 상세페이지 라우터
    },
    rowClick(record) {
      // 'record' will be the row data from items
      // `index` will be the visible row number (available in the v-model 'shownItems')
      
      this.fnView(record.bid);

    },
    fnSearch() {
      //검색
      console.log(this.type);
      console.log(this.word);
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
