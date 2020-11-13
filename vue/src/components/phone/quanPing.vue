<template>
  <div class="quanPing">
    <router-link
      @click="test()"
      v-for="(item, index) in quanPing"
      :key="index"
      :to="item.path"
      tag="div"
      >
      <div @click="test">
           {{ item.name }}
      </div>
     </router-link
    >
    <slot></slot>
  </div>
</template>

<script>
export default {
  data(){
    return{
      
    }
  },
  props: ["quanPing"],
  methods: {
    test() {
      console.log("aaa");
      this.$parent.fixIsShow = false;
    },
  },
};
</script>

<style >
.quanPing {
  z-index: 9;
  background: rgba(0, 0, 0, 0.918);
  position: fixed;
  height: 100%;
  overflow: scroll;
  width: 100%;
  top: 56px;
  left: 0px;
}
.quanPing > div {
  height: 48px;
  line-height: 48px;
  color: white;
}

</style>