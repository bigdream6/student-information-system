<template>
  <div class="stuSessionSelf">
    <div class="stuSessionSelfTop">
      <div>
        <div>{{ Stuinformation.self.name }}</div>
        <div>年龄：{{ Stuinformation.self.age }}</div>
        <div>性别： {{ Stuinformation.self.sex }}</div>
        <div>班级： {{ Stuinformation.self.classNo }}</div>
        <div>籍贯： {{ Stuinformation.self.ji }}</div>
      </div>
    </div>
    <hr />
    <div class="stuSessionSelfBottom">
      <table>
        <thead>
          <tr>
            <th>阶段考试科目</th>
            <th>考试成绩</th>
          </tr>
        </thead>
        <tbody>
          <h1 v-show="show">暂无考试数据</h1>
          <tr v-for="(item, index) in Stuinformation.kao" :key="index">
            <td>{{ item.kaoName }}</td>
            <td>
              <el-rate
                v-model="item.score"
                disabled
                show-score
                text-color="#ff9900"
                score-template="{value}"
              >
              </el-rate>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      show:false,
      Stuinformation: {
        self: {},

        kao: [

        ],
      },
    };
  },
  mounted() {
     console.log("----------mounted----------------")
    this.Stuinformation.kao = null
    let id = this.$route.params.name;
    this.axios
      .get("http://localhost:8080/user/getUser/" + id)
      .then((response) => {
        this.Stuinformation.self = response.data;
        
        this.axios
          .get("http://localhost:8080/user/getScore/" + id)
          .then((response) => {
            if( response.data[0] == null){
               this.Stuinformation.kao = response.data
               
               this.show = true
              
            }else{
              console.log(response.data)
                 this.Stuinformation.kao = response.data
            }
            
            
          });
      });
    this.$parent.user = this.Stuinformation.self.name;
  },
  activated() {
    console.log("----------actived----------------")
        let id = this.$route.params.name;
    this.axios
      .get("http://localhost:8080/user/getUser/" + id)
      .then((response) => {
        this.Stuinformation.self = response.data;
        
        this.axios
          .get("http://localhost:8080/user/getScore/" + id)
          .then((response) => {
            if(response.data == null || response.data.length == 0){
              this.show = true
              
            }else{
                 this.Stuinformation.kao = response.data
                console.log("-=============")
                console.log(this.show)
            }
            
            
          });
      });
    this.$parent.user = this.Stuinformation.self.name;
  },
};
</script>

<style scoped>
.stuSessionSelf {
  width: 100%;
}
.stuSessionSelfTop {
  display: flex;
}
.stuSessionSelfTop {
  padding: 0px 30px;
  text-align: left;
}
.stuSessionSelfTop > div:nth-child(1) {
  margin-left: 20px;
}
.stuSessionSelfTop > div:nth-child(1) > div {
  margin-top: 15px;
}
.stuSessionSelfTop > div:nth-child(1) > div:nth-child(1) {
  font-size: 50px;
  font-weight: bold;
  margin: 0px;
}
.stuSessionSelfBottom table {
  width: 100%;
}
.stuSessionSelfBottom table th {
  width: 50%;
}
.stuSessionSelfBottom table td {
  width: 50%;
}
.stuSessionSelfBottom tr {
  height: 40px;
  line-height: 40px;
}
.stuSessionSelfBottom tr:nth-child(even) {
  background: #fafafa;
}
</style>