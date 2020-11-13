<template>
  <div class="zhu">
    <h1 style="margin-top:30px">新华学生(教职工)信息登入申请</h1>
    <img src="../../assets/logo.png" alt="" />
    <h3>非本院人员请勿申请注册</h3>
    <div class="zhu_con">
      <div class="zuoImg"><img src="../../assets/limg.jpg" alt="" /></div>
      <keep-alive>
          <router-view></router-view>
      </keep-alive>
    
     
    </div>
  </div>
</template>

<script>
export default {
 
   
};
</script>

<style scoped>
.zhu {
  width: 100%;
  height: 100%;
}
.zhu_con {
  display: flex;
  width: 80%;
  margin: 0 auto;
  justify-content: space-between;
  margin-top: 15px;
}
.box {
  text-align: left;
}
.emailTitle{
  color: grey;
  font-size: 13px;
}
.box>div{
  margin-top: 20px;
}
.warning{
  color: #F56C6C;
  font-size: 16px;
}
</style>