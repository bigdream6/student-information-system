<template>
  <div>
    <phoneIndexTop></phoneIndexTop>
    <stuSessionSelf class="phoneStuIndex1"></stuSessionSelf>
    <quanPing v-show="fixIsShow" :quanPing="quanPing">
       <div class="IndexUser">
        <el-avatar> {{ user }} </el-avatar>
        <el-tooltip
          class="item"
          effect="dark"
          content="点击退出"
          placement="top"
        >
         <div class="stuIndexA" @click="tiao">{{user}}</div>
        </el-tooltip>
        ,欢迎登录
      </div>
    </quanPing>
  </div>
</template>

<script>
import quanPing from "./quanPing";
import phoneIndexTop from "./PhoneIndexTop";
import stuSessionSelf from "../index/stuSessionSelf";
export default {
  components: {
    phoneIndexTop,
    stuSessionSelf,
    quanPing,
  },
  data() {
    return {
      fixIsShow: false,
      quanPing: [
       
      ],
      user:""
    };
  },
  methods:{
    tiao(){
      this.fixIsShow =false
      this.$router.push({path:"/login"})
    }
  }
};
</script>

<style>
.phoneStuIndex1{
  margin-top: 56px;
}
.IndexUser{
  display: flex;
  justify-content: center;
  align-items: center;
}
.stuIndexA{
  text-decoration: aqua;
  color: aqua;
}
</style>