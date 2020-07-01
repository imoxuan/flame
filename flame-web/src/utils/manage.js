import axios from '@/utils/request'

// 封装 axios 常用方法
// get
export function getAction (url, parameter) {
  return axios({
    url: url,
    method: 'get',
    params: parameter
  })
}

// post
export function postAction (url, parameter) {
  return axios({
    url: url,
    method: 'post',
    data: parameter
  })
}
