<template>
  <div>
    <img src="../../assets/logo.png" alt="" />

    <div style="display: flex; flex: 1">
      <div style="width: 14%; line-height: 40px">姓名：</div>
      <el-input
        v-model="selfInformation.name"
        placeholder="请输入内容"
        style="width: 80%"
      ></el-input>
    </div>
    <div style="display: flex; flex: 1">
      <div style="width: 14%; line-height: 40px">年龄：</div>
      <el-input
        v-model="selfInformation.age"
        placeholder="请输入内容"
        style="width: 80%"
      ></el-input>
    </div>
    <div style="display: flex; align-items: center">
      <div style="width: 14%; line-height:40px text-align:left">性别：</div>
      <div style="width: 80%">
        <el-radio v-model="selfInformation.sex" label="男">男</el-radio>
        <el-radio v-model="selfInformation.sex" label="女">女</el-radio>
      </div>
    </div>
    <div style="display: flex; flex: 1">
      <div style="width: 14%; line-height: 40px">班级：</div>
      <span style="color: grey">{{ classNo }}</span>
    </div>

    <div style="display: flex; flex: 1">
      <div style="width: 14%; line-height: 40px">籍贯：</div>
      <el-input
        v-model="selfInformation.ji"
        placeholder="请输入内容"
        style="width: 80%"
      ></el-input>
    </div>
    <div>
      <el-button type="primary" @click="aa">添加</el-button>
       <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  props: ["classNo"],
  data() {
    return {
      selfInformation: {
        name: "",
        age: "",
        sex: "男",
        classNo: "",
        ji: "",
      },
    };
  },
  methods: {
    aa() {
      this.selfInformation.classNo = this.classNo
      if (
        this.selfInformation.name.length == 0 ||
        this.selfInformation.age.length == 0 ||
        this.selfInformation.classNo.length == 0 ||
        this.selfInformation.ji.length == 0
      ) {
        this.$message.error("输入框为空");
      } else {
        this.axios
          .get(
            "http://localhost:8080/user/addUser/" +
              this.selfInformation.name +
              "/" +
              this.selfInformation.age +
              "/" +
              this.selfInformation.sex +
              "/" +
              this.selfInformation.classNo +
              "/" +
              this.selfInformation.ji
          )
          .then((response) => {
            if (response.data) {
              this.$parent.getData();
              this.$parent.add = false;
              this.$message({
                type: "success",
                message: "添加成功!",
              });
            }else{
              this.$message({
                type: "info",
                message: "添加失败!",
              });
            }
          });
      }
    },
  }
};
</script>

<style>
</style>