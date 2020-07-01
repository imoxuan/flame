import { postAction } from '@/utils/manage'

const orgUrl = {
  add: '/sys/org/add'
}

const org = {
  add (params) {
    return postAction(orgUrl.add, params)
  }
}
export default org
