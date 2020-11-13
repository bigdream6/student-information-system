<template>
  <div>
    <el-container class="indexStuCon" :style="{height:height1+'px'}">
      <el-aside  style="background-color: rgb(238, 241, 246)">
        <el-menu >
          <router-link to="/home/indexStu/gaiLan" tag="div" active-class="indexStuLeftAct" style="height: 56px; line-height:56px">概览</router-link>
          <el-submenu v-for="(item,index) in indexStuLeftList" :key="index" :index="index">
            <template slot="title"
              ><i class="el-icon-s-custom"></i>{{item[0]}}</template
            >
            <el-menu-item-group v-for="(item1,index1) in item[1]" :key="index1">
              <template slot="title">{{item1.title}}</template>
              <el-menu-item v-for="(item2,index2) in item1.arr" :key="index2">
                
              <router-link :to="{path:'/home/indexStu/stuSession/'+item2}" tag="div" active-class="indexStuLeftAct" >{{item2}}</router-link>
              </el-menu-item>
              
            </el-menu-item-group>
            
          </el-submenu>
          
        </el-menu>
      </el-aside>
      <keep-alive include="gaiLan">
        <router-view :key="($route.name + ($route.params.id || $route.params.name ||''))"></router-view>
      </keep-alive>
      
    </el-container>
  </div>
</template>

<script>
export default {
  data(){
    return{
      height1:0,
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
      ]
    }
  },
  
  methods:{
    getHeight(){
      console.log(this.height1)
      this.height1=window.innerHeight-86;
    }
  },
 
  created(){
    window.addEventListener('resize', this.getHeight);
    this.getHeight()
  },
 
  destroyed(){
    window.removeEventListener('resize', this.getHeight)
  }
}
</script>

<style >
.indexStuCon {
  border: 1px solid #eee;
  margin-top: 30px;
}
.indexStuLeftAct{
  background: rgba(236, 245, 255);
  color: rgb(2, 2, 2);
}
</style>