<template>
  <div>
    
    <indexTop :indexTopItem="indexTopItem" :teaName="user" plac = "查询请输入学科名称"></indexTop>
    <stuSessionSelf></stuSessionSelf>
  </div>
</template>

<script>
import indexTop from './indexTop'
import stuSessionSelf from './stuSessionSelf'
export default {
  components:{
    indexTop,stuSessionSelf
  },
  data(){
    return{
      indexTopItem:[
        {
          title:"个人信息",
          path:""
        },
        
        
      ],
      user:""
    }
  },
  mounted(){
   
         let id = this.$route.params.name;
     this.axios.get("http://localhost:8080/user/getUser/"+id).then((response) => {
      
      this.user = response.data.name
     })
    
  },
  activated(){
   
         let id = this.$route.params.name;
     this.axios.get("http://localhost:8080/user/getUser/"+id).then((response) => {
      
      this.user = response.data.name
     })
    
  }
};
</script>

<style>
</style>