<template>
  <div class="jin">
    <h3>
      您的信息已经成功提交到服务端，请耐心等待管理员审核。
      <br />
      审核结果将发送到您的邮箱
    </h3>

    <el-timeline style="margin-top:30px">
      <el-timeline-item
        v-for="(activity, index) in activities"
        :key="index"
        :icon="activity.icon"
        :type="activity.type"
        :color="activity.color"
        :size="activity.size"
        :timestamp="activity.timestamp"
      >
        {{ activity.content }}
      </el-timeline-item>
    </el-timeline>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activities: [
        {
          content: "信息成功提交",
          timestamp: "2020-11-7 20:46",
          size: "large",
          type: "primary",
          icon: "el-icon-more",
        },
        {
          content: "管理员开始审核",
          timestamp: "预计 2020-11-08 20:46",
          color: "#0bbd87",
        },
        {
          content: "审核结束",
          timestamp: "预计 2020-11-09 20:46",
          size: "large",
        },
        {
          content: "发送审核结果",
          timestamp: "预计 2020-11-11 20:46",
        },
      ],
    };
  },
};
</script>

<style >

</style>