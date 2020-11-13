<template>
  <div style="width: 100%" >
    <div class="gaiLan">
      <tu class="tu"></tu>
      <div class="gaiLanTitle">
            <img src="../../assets/logo.png" alt="" />
        <h1>当前时间</h1>
        <h2>
          {{ nowDate }} {{nowTime}} {{nowWeek}}
        </h2>
        <div class="gaiLanTitle1">
            工作的同时也不要忘记休息呦
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import tu from "./tu";
export default {
  components: {
    tu,
  },
  data() {
    return {
      nowDate: "", // 当前日期
      nowTime: "", // 当前时间
      nowWeek: "", // 当前星期
    };
  },
  methods: {
    
    dealWithTime(data) {
      // 获取当前时间
      let formatDateTime;
      let Y = data.getFullYear();
      let M = data.getMonth() + 1;
      let D = data.getDate();
      let H = data.getHours();
      let Min = data.getMinutes();
      let S = data.getSeconds();
      let W = data.getDay();
      H = H < 10 ? "0" + H : H;
      Min = Min < 10 ? "0" + Min : Min;
      S = S < 10 ? "0" + S : S;
      switch (W) {
        case 0:
          W = "日";
          break;
        case 1:
          W = "一";
          break;
        case 2:
          W = "二";
          break;
        case 3:
          W = "三";
          break;
        case 4:
          W = "四";
          break;
        case 5:
          W = "五";
          break;
        case 6:
          W = "六";
          break;
        default:
          break;
      }
      this.nowDate = Y + "年" + M + "月" + D + "日 ";
      this.nowWeek = "周" + W;
      this.nowTime = H + ":" + Min + ":" + S;
      // formatDateTime = Y + "年" + M + "月" + D + "日 " + " 周" +W + H + ":" + Min + ":" + S;
    },
  },
  mounted() {
    this.$forceUpdate()
   
    // 页面加载完后显示当前时间
    this.dealWithTime(new Date());
    // 定时刷新时间
    this.timer = setInterval(() => {
      this.dealWithTime(new Date()); // 修改数据date
    }, 500);
  },
  destroyed() {
    if (this.timer) {
      // 注意在vue实例销毁前，清除我们的定时器
      clearInterval(this.timer);
    }
  },
  
};
</script>

<style >
.tu {
  max-height: 100%;
  overflow: scroll;
  width: 300px;
  overflow-x: hidden;
  min-width: 300px;
}
.gaiLan {
  display: flex;
  max-height: 100%;
  height: 100%;
}
.gaiLanTitle {
  width: 100%;
}
.gaiLanTitle1{
    font-size: 50px;
    color: royalblue;
}
</style>