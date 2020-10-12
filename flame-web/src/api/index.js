// api接口的统一出口
import user from '@/api/user'
import org from '@/api/org'
import dept from '@/api/dept'
import dict from '@/api/dict'
import dictItem from '@/api/dictItem'

export {
  user as userApi,
  org as orgApi,
  dept as deptApi,
  dict as dictApi,
  dictItem as dictItemApi
}
