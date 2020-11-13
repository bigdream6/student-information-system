<template>
  <div class="phoneIndex">
    <phoneIndexTop></phoneIndexTop>
    <quanPing v-show="fixIsShow" :quanPing="quanPing"> 
       <el-menu >
       
          <el-submenu v-for="(item,index) in indexStuLeftList" :key="index" :index="index">
            <template slot="title"
              ><i class="el-icon-s-custom"></i>{{item[0]}}</template
            >
            <el-menu-item-group v-for="(item1,index1) in item[1]" :key="index1">
              <template slot="title">{{item1.title}}</template>
              <el-menu-item  @click="hidden" v-for="(item2,index2) in item1.arr" :key="index2">
                
              <router-link :to="{path:'/phoneHome/phoneStuSession/'+item2}" tag="div" active-class="indexStuLeftAct" >{{item2}}</router-link>
              </el-menu-item>
              
            </el-menu-item-group>
            
          </el-submenu>
          
        </el-menu>
         <div class="IndexUser">
        <el-avatar> {{ user }} </el-avatar>
        <el-tooltip
          class="item"
          effect="dark"
          content="点击退出"
          placement="top"
        >
        <a  @click.prevent="tiao" style="  color: aqua;">{{user}}</a>
         
        </el-tooltip>
        ,欢迎登录
      </div>
    </quanPing>
    <router-view :key="($route.name + ($route.params.id || $route.params.name ||''))" style="margin-top:56px"></router-view>
  </div>
</template>

<script>
import phoneIndexTop from "./PhoneIndexTop";
import quanPing from "./quanPing";
export default {
  components: {
    phoneIndexTop,
    quanPing,
  },
  data() {
    return {
      fixIsShow: false,
      user:"",
      indexStuLeftList:[
        [
          "20届",
          [
            {
            title:'20 app',
            arr :['20app1','20app2'],
          },
          {
            title:'20 VR',
            arr :['20VR1','20VR2'],
          }
          ]
          
        ],
        [
          "19届",
          [
            {
            title:'19 app',
            arr :['19app1','19app2'],
          },
          {
            title:'19 VR',
            arr :['19VR1','19VR2'],
          }
          ]
          
        ],
        [
          "18届",
          [
            {
            title:'18 app',
            arr :['18app1','18app2'],
          },
          {
            title:'18 VR',
            arr :['18VR1','18VR2'],
          }
          ]
          
        ],
        [
          "17届",
          [
            {
            title:'17 app',
            arr :['17app1','17app2'],
          },
          {
            title:'17 VR',
            arr :['17VR1','17VR2'],
          }
          ]
          
        ]
      ],
      quanPing: [
        {
          name: "概览",
          path: "/phoneHome/tu",
        },
        {
          name: "考试信息",
          path: "/phoneHome/phoneKao",
        },
      ],
    };
  },
  methods:{
    tiao(){
      this.fixIsShow = false;
      this.$router.push({path:"/login"})
    },
    hidden(){
      console.log("--------hidden---------------")
      this.fixIsShow = false
    }
  }
};
</script>

<style>
.phoneIndex {
  width: 100%;
  overflow: hidden;
  max-width: 100%;
}
.IndexUser{
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>