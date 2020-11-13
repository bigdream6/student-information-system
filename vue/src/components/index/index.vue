<template>
  <div>
    
    <indexTop :indexTopItem="indexTopItem" :teaName="user" plac = "查询请输入学生姓名"></indexTop>
    

       <router-view :key="($route.name +($route.params.stuName||''))">

      </router-view>
     
    
  </div>
</template>

<script>
import indexTop from './indexTop'
export default {
  components:{
    indexTop
  },
  data(){
    return{
      indexTopItem:[
        {
          title:'学生信息',
          path:'/home/indexStu'
        },{
           title:'考试信息',
          path:'/home/kao'
        }
        
      ],
      user:""
    }
  },
  mounted(){
    console.log("==============================")
    this.user = this.$cookies.get("id")
  },
  activated(){
     this.user = this.$cookies.get("id")
  }
};
</script>

<style>
</style>