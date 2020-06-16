// import router from './router'
// import storage from 'store'
import NProgress from 'nprogress'

NProgress.configure({ showSpinner: false })

// const whiteList = ['login', 'register', 'registerResult']

/**
router.beforeEach((to, from, next) => {
  if (storage.get('token')) {
    NProgress.start()
    next()
  } else {
    if (whiteList.includes(to.name)) {
      // 在免登录白名单，直接进入
      next()
    } else {
      next({
        path: '/user/login',
        query: {
          redirect: to.fullPath
        }
      })
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  NProgress.done() // finish progress bar
}) */
