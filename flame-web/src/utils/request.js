import axios from 'axios'
import { VueAxios } from './vue-axios'
// 创建 axios 实例
const request = axios.create({
  // 跨越请求时是否需要使用凭证
  // withCredentials: true,
  // 超时时间(毫秒)
  timeout: 90000,
  baseURL: '/flame'
})

request.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8'
// 异常拦截处理器
const errorHandler = (error) => {
  if (error.response) {
    /* const data = error.response.data
    const token = storage.get(ACCESS_TOKEN)
    if (error.response.status === 403) {
      notification.error({
        message: 'Forbidden',
        description: data.message
      })
    }
    if (error.response.status === 401 && !(data.result && data.result.isLogin)) {
      notification.error({
        message: 'Unauthorized',
        description: 'Authorization verification failed'
      })
      if (token) {
        store.dispatch('Logout').then(() => {
          setTimeout(() => {
            window.location.reload()
          }, 1500)
        })
      }
    } */
  }
  return Promise.reject(error)
}
// 请求拦截器
request.interceptors.request.use((config) => {
  return config
}, errorHandler)

// 响应拦截器
request.interceptors.response.use((response) => {
  return response.data
}, errorHandler)

const installer = {
  vm: {},
  install (Vue) {
    Vue.use(VueAxios, request)
  }
}
export default request

export {
  installer as VueAxios,
  request as axios
}
