import Vue from 'vue'
import App from './App.vue'
import './plugins/element.js'
import router from './router'
import VueCookies from 'vue-cookies'
import echarts from 'echarts'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)
Vue.use(VueCookies)

Vue.prototype.$echarts = echarts
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
