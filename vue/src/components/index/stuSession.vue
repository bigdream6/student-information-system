<template>
  <div
    style="width: 100%; height: 100%; max-height:100% max-width: 100%;  overflow: scroll;  overflow-x:hidden;"
  >
    <h2>{{ data }}</h2>
    <table style="width: 100%" class="stuSessionTable">
      <thead>
        <tr>
          <th>序号</th>
          <th>姓名</th>
          <th>年龄</th>
          <th>性别</th>
          <th>班级</th>
          <th>籍贯</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in tableData" :key="item">
          <td>{{ index + 1 }}</td>
          <td>
            <router-link :to="'/home/indexStu/stuSessionSelf/' + item.id">{{
              item.name
            }}</router-link>
          </td>
          <td>{{ item.age }}</td>
          <td>{{ item.sex }}</td>
          <td>{{ item.classNo }}</td>
          <td>{{ item.ji }}</td>
          <td>
            <el-button type="warning" @click="updateIitem(item)"
              >修改</el-button
            >

            <el-button type="danger" @click="del(item.id)">删除</el-button>
          </td>

          <div class="add1" v-show="add">
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
                type="Number"
                v-model="selfInformation.age"
                placeholder="请输入内容"
                style="width: 80%"
              ></el-input>
            </div>
            <div style="display: flex; align-items: center">
              <div style="width: 14%; line-height:40px text-align:left">
                性别：
              </div>
              <div style="width: 80%">
                <el-radio v-model="selfInformation.sex" label="男">男</el-radio>
                <el-radio v-model="selfInformation.sex" label="女">女</el-radio>
              </div>
            </div>
            <div style="display: flex; flex: 1">
              <div style="width: 14%; line-height: 40px">
                班级：
                <span style="color: grey">{{ selfInformation.classNo }}</span>
              </div>
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
              <el-button type="primary" @click="addMeth">添加</el-button>
              <el-button type="info" @click="add = false">取消</el-button>
            </div>
          </div>
        </tr>
      </tbody>
    </table>
    <div class="add" @click="add = !add">
      增<br />
      加
    </div>
    <tan class="tan" :selfInformation="selectItem" v-show="tanIsShow">
      <el-button type="info" @click="tanIsShow = false">取消</el-button>
    </tan>
  </div>
</template>

<script>
import tan from "./tan";

export default {
  components: {
    tan,
  },
  data() {
    return {
      selectItem: {},
      data: "",
      tanIsShow: false,
      add: false,
      selfInformation: {
        name: "",
        age: 0,
        sex: "男",
        classNo: "",
        ji: "",
      },
      tableData: [],
    };
  },
  computed() {},
  methods: {
    updateIitem(row) {
      this.tanIsShow = !this.tanIsShow;
      this.selectItem = JSON.parse(JSON.stringify(row));
    },
    del(index) {
      this.$confirm("此操作将永久删除信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.axios
            .get("http://localhost:8080/user/deleteUser/" + index)
            .then((response) => {
              if (response.data) {
                
                this.getData();
              } else {
                this.$message({
                  type: "info",
                  message: "删除失败!",
                });
              }
            });

          this.$message({
            type: "success",
            message: "删除成功!",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    addMeth() {
      if (
        this.selfInformation.name.length == 0 ||
        this.selfInformation.age.length == 0 ||
        this.selfInformation.classNo.length == 0 ||
        this.selfInformation.ji.length == 0
        
      ) {
        this.$message.error("请检查输入框内字符是否合法");
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
            if(response.data != true){
               this.$message({
                type: "info",
                message: "添加失败!",
              });
            }else{
               this.getData();
              this.add = false;
              this.$message({
                type: "success",
                message: "添加成功!",
              });
            }
           
          });
      }
    },
    getData(){
       this.axios
      .get("http://localhost:8080/user/findClass/" + this.$route.params.id)
      .then((response) => {
        this.tableData = JSON.parse(JSON.stringify(response.data));
        console.log("----------父组件查询tableData")
         console.log(this.tableData)
           console.log("----------父组件查询tableData-------------------结束")
      });
    }
  },
  mounted() {
    this.data = this.$route.params.id;
    this.selfInformation.classNo = this.$route.params.id;
    this.getData()
   
  },
  activated() {},
};
</script>

<style>
.tan,
.add1 {
  position: fixed;
  left: 50%;
  top: 50%;
  width: 50%;
  height: 50%;
  transform: translate(-50%, -50%);
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);

  background: white;
  padding: 20px 10px;
}
.stuSessionTable td {
  height: 60px;
  line-height: 60px;
  border-bottom: 1px solid #ebeef5;
}
.stuSessionTable tbody > tr:nth-child(even) {
  background: #fafafa;
}
.add {
  position: fixed;
  right: 0px;
  height: 60px;
  line-height: 30px;
  top: 50%;
  background: yellowgreen;
  cursor: pointer;
  width: 48px;
  color: white;
}
</style>