<template>
  <div class="login">
    <div class="title"></div>
    <div class="box">
      <div class="boxTitle">登录</div>
      <div class="boxBody">
        <div class="boxTop">
          <router-link tag="div" active-class="boxAct" to="/login/zhang"
            >账号登录</router-link
          >
          <router-link tag="div" active-class="boxAct" to="/login/phoneLogin"
            >验证码登录</router-link
          >
        </div>
        <keep-alive>
         
            <router-view > </router-view>
         
          
        </keep-alive>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "新华电脑学校学生管理系统",
    };
  },
};
</script>

<style scoped>

.login {
  width: 100%;
  height: 100%;
 
  background:  url("../../assets/ChMkJlbKwaOIZAwgAAiOBr8t3TwAALGbQOejjUACI4e063.jpg")  no-repeat ;
  background-size: cover;
}
.box {
  width: 500px;
  height: 500px;
  background: white;
  background: rgba(0, 0, 0, 0.5);
  box-shadow: 0 0 10px 2px black;
  position: fixed;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -40%);
}
.title {
  color: white;
  font-size: 50px;
  font-weight: bold;
  text-shadow: 0 2px 10px black;
  height: 150px;
  line-height: 150px;
  letter-spacing: 30px;
  text-align: center;
}
.title::after {
  content: "新华电脑学生管理系统";
}

.boxTop > div {
  width: 50%;
  color: rgb(129, 169, 214);
  height: 40px;
  font-size: 25px;
  line-height: 40px;
  cursor: pointer;
}
.boxTop {
  display: flex;
}
.boxTitle {
  font-size: 30px;
  color: white;
  text-shadow: 0 2px 10px rgb(255, 255, 255);
  background: rgb(129, 169, 214);
  height: 50px;
  line-height: 50px;
}
.boxAct {
  background: white;
}
.boxBody {
  padding: 0 10px;
}
.boxTop > div:hover {
  background: white;
}
</style>