<template>
  <div class="tan">
    <img src="../../assets/logo.png" alt="" />
    <div style="display: flex; flex: 1"></div>
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
      <el-input
        v-model="selfInformation.classNo"
        placeholder="请输入内容"
        style="width: 80%"
      ></el-input>
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
      <el-button type="primary" @click="aa">修改</el-button>
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  props: ["selfInformation"],
  mounted() {
    console.log(this.selfInformation);
    console.log(this.$parent.selectItem);
  },
  watch: {
    selfInformation: {
      deep: true,
      handler: function (newVal, oldVal) {
        this.selfInformation = newVal;
      },
    },
  },
  methods: {
    aa() {
      console.log("---------------------");
      console.log(this.selfInformation);
      this.axios
        .get(
          "http://localhost:8080/user/setUser/" +
            this.selfInformation.id +
            "/" +
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
            console.log(this.selfInformation);
            this.$parent.getData();

            this.$message({
              type: "success",
              message: "修改成功!",
            });
          } else {
            this.$message({
              type: "info",
              message: "删除失败!",
            });
          }
        });
      this.$parent.tanIsShow = false;
    },
  },
};
</script>

<style>
</style>