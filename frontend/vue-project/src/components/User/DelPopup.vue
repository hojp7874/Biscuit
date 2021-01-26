<template>
    <div class="container" id = "popup" >
        <p>
        회원을 탈퇴하시면, 그동안 쌓여왔던 모든 자료와 데이터가 삭제되며<br>
        참여하고 있던 모든 스터디 공간에 접근 할 수 없게 됩니다.<br>
        그럼에도 꼭 탈퇴하고 싶으시다면 탈퇴사유를 남겨주시길 부탁드립니다.
        </p>
        <br><br>
        <div class="input-group col-md-3">
            <input type="textarea" v-model="withdraw_reason" class="form-control col-md-2" style = "width : 450px ; height : 40px" placeholder="탈퇴 사유를 남겨주세요">
            <input type="password" class="form-control col-md-2" style = "width : 450px ;  height : 40px" placeholder="비밀번호를 입력 해 주세요">
        </div>
        <div class="row col-md-6" style="margin-top : 20px">
            <input class="btn btn-default col-md-3" @click="del_data" type="button" value="탈퇴하기">
            <input class="btn btn-default col-md-3" @click="$emit('close')" type="button" value="취소" style="margin-left : 200px">
        </div>
    </div>
</template>
<script>
export default {
  data:function(){
      return {
          withdraw_reason:''
      }
  },props : [
      'hot_table',
  ],methods : {
      del_data(){
          
          this.$emit('close')
      }
  }
}
</script>

<style>
 
</style>
