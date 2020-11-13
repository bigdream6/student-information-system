<template>
  <div>
    <div style="margin-top: 30px">
      <el-input placeholder="手机号" v-model="input1">
        <template slot="prepend">中国+86</template>
      </el-input>
    </div>
    <div style="margin-top: 15px">
      <el-input placeholder="请输入验证码" v-model="input2">
        <template slot="append" style="cursor: pointer">接收</template>
      </el-input>
    </div>
    <div class="warning" v-show="warning">
      您输入的手机号尚未注册，请联系管理员注册
    </div>
    <br />
    <goZhu></goZhu>
    <el-button
      @click="warning = !warning"
      type="success"
      class="button"
      style="margin-top: 20px"
      >立即登录</el-button
    >
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
      input1: "",
      input2: "",
      stuNum: 1234,
      teaNum: 5678,
      warning: false,
    };
  },
  methods: {
    
  },
};
</script>

<style>
.warning {
  color: #f56c6c;
}
</style>