<template>
  <div>
    <table style="width: 100%" class="stuSessionTable">
      <thead>
        <tr>
          <th>序号</th>
          <th>姓名</th>
          <th>年龄</th>
          <th>性别</th>
          <th>班级</th>
          <th>籍贯</th>
        </tr>
      </thead>
      <tbody>
        <tr
          class="stuSessionTableTr"
          v-for="(item, index) in tableData"
          :key="item"
          @click="show(index)"
        >
          <td>{{ index + 1 }}</td>
          <td>
            <router-link :to="'/phoneHome/selfsession/' + item.id">{{
              item.name
            }}</router-link>
          </td>
          <td>{{ item.age }}</td>
          <td>{{ item.sex }}</td>
          <td>{{ item.classNo }}</td>
          <td>{{ item.ji }}</td>
          <div class="abTan" v-show="abTanShow == index">
           <el-button type="warning" @click="updateIitem(item)"
              >修改</el-button
            >
            <el-button type="danger" @click="del(item.id)">删除</el-button>
          </div>
          
        
        </tr>
      </tbody>
      
    </table>
    <div class="add" @click="add = !add">
      增<br />
      加
    </div>
     <tan
            class="tan"
            :selfInformation="selectItem"
            v-show="tanIsShow"
          >
           <el-button type="info" @click="tanIsShow = false">取消</el-button>
          </tan>
    <add class="add1" :addMeth1="addMeth" v-show="add" :classNo="classNo">
      <el-button type="info" @click="add = false">取消</el-button>
    </add>
  </div>
</template>

<script>
import tan from "../index/tan";
import add from '../index/add';
export default {
  components: {
    tan,add
  },
  data() {
    return {
      selectItem:{},
      classNo:"",
      abTanShow: "null",
      tanIsShow:false,
      add:false,
      selfInformation: {
        name: "",
        age: "",
        sex: "男",
        classNo: "",
        ji: "",
      },
      tableData: [
        
      ],
    };
  },
  methods: {
   updateIitem(row){
      this.tanIsShow=!this.tanIsShow;
      this.selectItem=JSON.parse(JSON.stringify(row))
    },
    show(index) {
      if (this.abTanShow == index) {
        this.abTanShow = null;
      } else {
        this.abTanShow = index;
      }
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
                for (let i = 0; i < this.tableData.length; i++) {
                  if (this.tableData[i].id == index) {
                    this.tableData.splice(i, 1);
                  }
                }
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
    addMeth(){
      console.log("meth------clic")
      this.tableData.push(this.selfInformation);
    },
    getData(){
      this.classNo = this.$route.params.name;
    console.log( this.$route.params.name)
    this.axios.get("http://localhost:8080/user/findClass/"+this.$route.params.name).then((response) => {
    
     this.tableData = response.data
     })
    }
  },
  mounted(){
    this.getData();
  },
  activated(){
   this.getData();
  }
};
</script>

<style>
.stuSessionTable td {
  height: 60px;
  line-height: 60px;
  border-bottom: 1px solid #ebeef5;
}
.stuSessionTable tbody > tr:nth-child(even) {
  background: #fafafa;
}
.stuSessionTableTr {
  position: relative;
}
.abTan {
  position: absolute;
  right: 10px;
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
.tan,.add1{
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

</style>