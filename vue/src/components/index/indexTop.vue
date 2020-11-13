<template>
  <div class="indexTop">
    <div class="indexTopCon">
      <div class="indexTopConLeft">
        <div>
          <img src="../../assets/logo.png" alt="" />
        </div>
        <div v-for="item in indexTopItem" :key="item">
         
            <router-link tag="div" :to="item.path" active-class="indexTopactItem"> {{item.title}} </router-link>
          
          
        </div>
        
        <div style="display: flex">
          <el-input v-model="stuName" :placeholder="plac"></el-input>
          <el-button type="primary" icon="el-icon-search" @click="tiao">
            搜索
            </el-button>
        </div>
      </div>
      <div class="indexTopConRight">
        <el-avatar> {{ teaName }} </el-avatar>
        <el-tooltip
          class="item"
          effect="dark"
          content="点击退出"
          placement="top"
        >
          <router-link to="/login" tag="a"> {{ teaName }}</router-link
        >
        </el-tooltip>
        ,欢迎登录
      </div>
    </div>
  </div>
</template>

<script>
export default {
    props:["indexTopItem","plac","teaName"],
  data() {
    return {
      stuName: "",
     
    };
  },
  methods:{
    tiao(){
      if(this.stuName.length == 0){
          this.$message({
          message: '搜索内容为空',
          type: 'warning'
        });
      }else{
        console.log(this.stuName)
         this.$router.push({path:'/home/search/'+this.stuName})
      }
     
    }
  },
 
};
</script>

<style>
.indexTop {
  width: 100%;
  height: 56px;
  background: linear-gradient(
    to right,
    rgba(140, 140, 141, 0.123),
    rgb(93, 124, 228)
  );
  box-sizing: border-box;
  text-align: left;
  border: #e7e7e7;
  box-shadow: 0 0px 10px black;
}
.indexTopCon {
  width: 98%;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.indexTopConLeft {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.indexTopConLeft > div {
  margin-left: 20px;
  cursor: pointer;
}
.indexTopConLeft > div:nth-child(1) {
  margin-left: 0px;
}
.indexTopConRight {
  display: flex;
  align-items: center;
}
.indexTopConRight > a {
  margin-left: 10px;
}
.indexTopactItem{
  color: red;
}
</style>