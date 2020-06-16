import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// 引入 ant-design-vue 组件
import '@/core/lazy_use'
// 权限控制
import './permission'
// 全局样式
import '@/assets/style/global.less'

Vue.config.productionTip = false

Vue.directive('focus', {
  // 当被绑定的元素插入到 DOM 中时……
  inserted: function (el) {
    // 聚焦元素
    el.focus()
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
