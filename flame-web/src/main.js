import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// 引入 ant-design-vue 组件
import '@/core/lazy_use'
// 全局样式
import '@/assets/style/global.less'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
