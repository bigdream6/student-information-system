<template>
  <div class="goZhu" @click="goZhu">
     没有账号？找管理员申请
  </div>
</template>

<script>
export default {
    methods:{
        goZhu(){
            this.$router.push({path:'/zhu'})
        }
    }
}
</script>

<style>
.goZhu{
    cursor: pointer;
    text-decoration: grey;
}
</style>