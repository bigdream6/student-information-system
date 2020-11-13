<template>
  <div>
    <h1>考试安排</h1>
    <div>
      <table style="width:100%">
      <thead>
        <tr>
          <th>考试科目</th>
          <th>考试时间</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item,index) in kaoList" :key="index">
          <td>{{item.kaoDate}}</td>
          <td>{{item.kaoName}}</td>
        </tr>
      </tbody>
    </table>
    </div>
    
  </div>
</template>

<script>
export default {
  data(){
    return{
      kaoList:[]
    }
  },
  mounted(){
      this.axios.get("http://localhost:8080/user/getKao").then((response) => {
      console.log(response.data)
      this.kaoList = response.data
     })
  },
  activated(){
     this.axios.get("http://localhost:8080/user/getKao").then((response) => {
      
      this.kaoList = response.data
     })
  }
};
</script>

<style>
</style>