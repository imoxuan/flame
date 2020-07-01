import axios from 'axios'

// 创建 axios 实例
const service = axios.create({
  // 跨越请求时是否需要使用凭证
  // withCredentials: true,
  // 超时时间(毫秒)
  timeout: 90000,
  baseURL: '/flame'
})

service.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8'

// 请求拦截器
service.interceptors.request.use((config) => {
  return config
}, (error) => {
  return Promise.reject(error)
  // return Promise.error(error)
})

// 响应拦截器
service.interceptors.response.use((response) => {
  // 如果返回的状态码为200，说明接口请求成功，可以正常拿到数据
  // 否则的话抛出错误
  if (response.status === 200) {
    return Promise.resolve(response)
  } else {
    return Promise.reject(response)
  }
}, (error) => {
  return Promise.reject(error)
})

export default service
