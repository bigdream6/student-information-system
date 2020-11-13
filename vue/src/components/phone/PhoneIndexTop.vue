<template>
  <div class="PhoneIndexTopAll">
    <div class="PhoneIndexTop">
      <div>
        <img src="../../assets/logo.png" alt="" />
      </div>
      <div @click="show">
        <img src="../../assets/Flod.png" alt=""  />
      </div>
    </div>
    
  </div>
</template>

<script>
export default {
  data() {
    return{
      drawer: false
    }
    
  },
  methods:{
    show(){
      
      this.$parent.fixIsShow = !this.$parent.fixIsShow

      if(this.$cookies.get("shen") == "student"){
           let id = this.$route.params.name;
     this.axios.get("http://localhost:8080/user/getUser/"+id).then((response) => {
      
      this.$parent.user = response.data.name
     })
      }else{
        this.$parent.user = this.$cookies.get("id")
      }
      
     
    }
  }
};
</script>

<style>
.PhoneIndexTopAll{
  background: white;
  width: 100%;
  max-width: 100%;
  position: fixed;
  left: 0px;
  top: 0px;
  z-index: 10;
}
.PhoneIndexTop {
  display: flex;
  justify-content: space-between;
  height: 56px;
  align-items: center;
}
.PhoneIndexTop > div:nth-child(1) {
  width: 70%;
}
.PhoneIndexTop > div:nth-child(2) {
  width: 15%;
}
.PhoneIndexTopIcon {
  height: 100%;
}
.PhoneIndexTop img {
  height: 100%;
  width: 100%;
}
.fixDrawer{
    width: 80%;
    height: 100%;
    position: fixed;
    left: 0px;
    top: 0px;
    transform: translateX(-100%);
    background: red;
    
}

</style>