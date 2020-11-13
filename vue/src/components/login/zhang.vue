<template>
  <div class="zhang">
    <div class="zhangTitle">账号</div>
    <div class="zhangInput">
      <input type="text" placeholder="请输入您的账号" v-model="userName" />
    </div>
    <div class="zhangTitle">密码</div>
    <div class="zhangInput">
      <input type="password" v-model="password" placeholder="请输入您的密码" />
    </div>
    <div class="warning" v-show="warning">
      您输入的账号或者密码不对请重新输入
    </div>
    <br />
    <goZhu></goZhu>
    <el-button @click="tiao" type="success" class="button">立即登录</el-button>
  </div>
</template>

<script>
import goZhu from "./goZhu";
export default {
  components: {
    goZhu,
  },
  data() {
    return {
      userName: "",
      password: "",
      stuName: "geng",
      stuPass: "geng",
      teaUser: "root",
      teaPass: "root",
      warning: false,
     
      
    };
  },
  methods:{
    tiao() {
      let that = this;
      this.axios.get("http://localhost:8080/user/findUser/"+this.userName+"/"+this.password).then((response) => {
        
        this.result = response.data;
        if(this.result.shen == "student"){
        that.warning = false;
        this.$cookies.set("shen", this.result.shen);
        this.$cookies.set("id", this.result.id);
        if (
          navigator.userAgent.match(
            /(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i
          )
        ) {
          this.$router.push({
            path: "/phoneStuIndex/"+this.result.id,
          });
        } else {
          this.$router.push({
            path: "/stuIndex/" + this.result.id,
          });
        }
      } else if (
        this.result.shen == "teacher"
      ) {
        that.warning = false;
        this.$cookies.set("shen", this.result.shen);
        this.$cookies.set("id", this.userName);
        if (
          navigator.userAgent.match(
            /(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i
          )
        ) {
          this.$router.push({ path: "/phoneHome" });
        } else {
          this.$router.push({ path: "/home" });
        }
      } else {
        that.warning = true;
      }
      });

      
    },
  },
};
</script>

<style scoped>
* {
  text-align: left !important;
}
.zhangInput > input {
  background: none !important;
  color: white;
  border: none;
  outline: none;
  border-bottom: 2px solid white;
  width: 100%;
}
.zhangInput > input::placeholder {
  color: white;
  font-size: 15px;
}
.zhangTitle {
  font-size: 20px;
  color: white;
  text-shadow: 0 1px 5px lavenderblush;
}
.zhang > div {
  margin-top: 20px;
}
button {
  margin-top: 30px;
}
.warning {
  color: #f56c6c;
}
</style>