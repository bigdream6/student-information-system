<template>
  <div>
    <div id="myChart1" :style="{ width: '100%', height: '300px' }"></div>
    <div id="myChart2" :style="{ width: '100%', height: '300px' }"></div>
    <div id="myChart3" :style="{ width: '100%', height: '300px' }"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      className: [],
      classCountTotal: [],
      ageCountTotal: [],
      ageFen:[]
    };
  },
  mounted() {
    this.axios.get("http://localhost:8080/user/classCount").then((response) => {
      this.classCountTotal = response.data;
      this.classCountTotal.forEach((v, i) => {
        this.$set(v, "name", v.classNo);
        this.$set(v, "value", v.count);
        this.className.push(v.classNo);
      });
      this.axios.get("http://localhost:8080/user/ageCount").then((response) => {
        this.ageCountTotal = response.data;
        this.ageCountTotal.forEach((v, i) => {
          this.$set(v, "name", v.age);
          this.$set(v, "value", v.count);
          this.ageFen.push(v.age)
        });
        this.drawLine();
      });
      
    });
  },
  methods: {
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart1 = this.$echarts.init(document.getElementById("myChart1"));
      let myChart2 = this.$echarts.init(document.getElementById("myChart2"));
      let myChart3 = this.$echarts.init(document.getElementById("myChart3"));
      // 绘制图表
      myChart1.setOption({
        title: { text: "2017 - 2020 年招生人数趋势图" },
        tooltip: {},
        xAxis: {
          data: ["2017", "2018", "2019", "2020"],
        },
        yAxis: {},
        series: [
          {
            name: "销量",
            type: "bar",
            data: [5, 20, 36, 10, 10],
          },
        ],
      });
      console.log(this.classCountTotal);

      myChart2.setOption({
        title: {
          text: "各班级人数饼图",
          subtext: "纯属虚构",
          x: "center",
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)",
        },

        series: [
          {
            name: "访问来源",
            type: "pie",
            radius: "55%",
            center: ["50%", "60%"],
            data: this.classCountTotal,
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)",
              },
            },
          },
        ],
      });
      myChart3.setOption({
        title: {
          text: "各年龄段比例图",
          subtext: "纯属虚构",
          x: "center",
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)",
        },
        legend: {
          orient: "vertical",
          left: "left",
          data: this.ageFen,
        },
        series: [
          {
            name: "年龄：",
            type: "pie",
            radius: "55%",
            center: ["50%", "60%"],
            data:this.ageCountTotal,
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)",
              },
            },
          },
        ],
      });
    },
  },
};
</script>

<style>
</style>