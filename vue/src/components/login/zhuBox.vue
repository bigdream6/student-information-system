<template>
  <div class="box">
    <div>
      请输入您的姓名
      <el-input v-model="input" placeholder="请输入您的姓名"></el-input>
    </div>
    <div>
      性别
      <el-radio v-model="sex" label="1">男</el-radio>
      <el-radio v-model="sex" label="2">女</el-radio>
    </div>

    <br />
    <div>
      身份
      <el-radio v-model="shen" label="1">教职工</el-radio>
      <el-radio v-model="shen" label="2">学生</el-radio>
    </div>

    <div v-show="banIsShow">
      班主任姓名:
      <el-input v-model="ban" placeholder="班主任姓名"></el-input>
    </div>
    <br />
    <div>
      所学专业
      <el-autocomplete
        popper-class="my-autocomplete"
        v-model="state"
        :fetch-suggestions="querySearch"
        placeholder="请输入内容"
        @select="handleSelect"
      >
        <i
          class="el-icon-edit el-input__icon"
          slot="suffix"
          @click="handleIconClick"
        >
        </i>
        <template slot-scope="{ item }">
          <div class="name">{{ item.value }}</div>
          <span class="addr">{{ item.address }}</span>
        </template>
      </el-autocomplete>
    </div>
    <div>
      邮箱：
      <el-input placeholder="请输入您的邮箱" v-model="email"></el-input>
      <br />
      <div class="emailTitle">邮箱将接收审核结果或审核成功分配的账号和密码</div>
    </div>
    <div>
      <el-button type="primary" @click="kong">
       
          提交申请
        >
      </el-button>
      <el-button type="info" @click="fan">
       
          取消
        ×
      </el-button>
    </div>
    <div class="warning" v-show="warningIsShow">
      输入内容不能为空，请检查后重新输入
    </div>
  </div>
</template>

<script >
export default {
  data() {
    return {
      input: "",
      shen: "1",
      banIsShow: false,
      ban: "",
      email: "",
      sex: "1",

      restaurants: [],
      state: "",
      warningIsShow: false,
      isSend: false,
    };
  },
  watch: {
    shen() {
      if (this.shen == "2") {
        this.banIsShow = true;
      } else {
        this.banIsShow = false;
      }
    },
  },
  mounted() {
    this.restaurants = this.loadAll();
  },
  methods: {
    fan(){
      this.$router.push({path:"/login"})
    },
    kong() {
      if (this.banIsShow) {
        if (
          this.input.length == 0 ||
          this.ban.length == 0 ||
          this.email.length == 0 ||
          this.state.length == 0
        ) {
          this.warningIsShow = true;
        } else {
          this.warningIsShow = false;
          this.isSend = true;
          this.$cookies.set("isSend", this.isSend);
          this.$router.push({ path: "/zhu/jin" });
        }
      } else if (
        this.input.length == 0 ||
        this.email.length == 0 ||
        this.state.length == 0
      ) {
        this.warningIsShow = true;
      } else {
        this.warningIsShow = false;
        this.isSend = true;
        this.$cookies.set("isSend", this.isSend);
        this.$router.push({ path: "/zhu/jin" });
      }
    },
    querySearch(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString
        ? restaurants.filter(this.createFilter(queryString))
        : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(results);
    },
    createFilter(queryString) {
      return (restaurant) => {
        return (
          restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) ===
          0
        );
      };
    },
    loadAll() {
      return [
        { value: "app软件开发" },
        {
          value: "软件开发",
        },
        {
          value: "电子商务",
        },
        { value: "网络工程" },
        {
          value: "创意设计",
        },
        { value: "VR" },
        {
          value: "人工智能",
        },
        {
          value: "UI设计",
        },
        { value: "电子竞技" },
      ];
    },
    handleSelect(item) {
      console.log(item);
    },
    handleIconClick(ev) {
      console.log(ev);
    },
  },
  beforeCreate(){
      if(this.$cookies.get("isSend") ){
          this.$router.push({path:'/zhu/jin'})
      }
      
  }
};
</script>

<style scoped>
.emailTitle {
  color: grey;
  font-size: 13px;
}
.box > div {
  margin-top: 20px;
}
.warning {
  color: #f56c6c;
  font-size: 16px;
}
</style>