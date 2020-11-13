<template>
  <div
    style="width: 100%; margin-top:20px; height: 100%; max-height:100% max-width: 100%;  overflow: scroll;  overflow-x:hidden;"
  >
  
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

          
        </tr>
      </tbody>
    </table>
    <h1 v-show="h1Show">暂无查询结果（支持模糊查询）</h1>
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
      h1Show:false,
      selectItem: {},
      data: "",
      tanIsShow: false,
      add: false,
      selfInformation: {
        name: "",
        age: "",
        sex: "男",
        classNo: "",
        ji: "",
      },
      tableData: [],
    };
  },
  methods: {
    getData(){
      
    this.axios
      .get("http://localhost:8080/user/getUserByName/" + this.$route.params.stuName)
      .then((response) => {
        if(response.data == null || response.data.length ==0){
          this.h1Show = true
        }else{
           this.tableData = response.data;
        }
       
      });
    },
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
                
                this.getData()
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
    
  },
  mounted() {
   
    this.selfInformation.classNo = this.$route.params.stuName;
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