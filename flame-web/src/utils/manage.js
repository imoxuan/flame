import axios from '@/utils/request'

// 封装 axios 常用方法
export function httpAction (url, parameter, method) {
  return axios({
    url: url,
    method: method,
    data: parameter
  })
}

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

// delete
export function deleteAction (url, parameter) {
  return axios({
    url: url,
    method: 'delete',
    params: parameter
  })
}
