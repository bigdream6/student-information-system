<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>
<script>
export default {};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
* {
  margin: 0;
  padding: 0;
}
html,
body,
#app {
  height: 100%;
}
@media (max-width: 867px) {
  .zhu .zuoImg {
    display: none;
  }
  .zhu .box {
    width: 100%;
  }
}
@media (max-width: 767px) {
  .login .title {
    font-size: 20px !important;
  }
  .tan,
  .add1 {
    width: 96% !important;
  }
  .stuSessionSelfTop {
    display: block !important;
  }
}
@media (max-width: 576px) {
  .login .title {
    font-size: 16px !important;
  }
  .login .title::after {
    content: "学生管理" !important;
  }
  .login .box {
    width: 100% !important;
  }
}
</style>
