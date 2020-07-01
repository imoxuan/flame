const path = require('path')
const DuplicatePackageCheckerPlugin = require("duplicate-package-checker-webpack-plugin")

function resolve (dir) {
  return path.join(__dirname, dir)
}

// vue.config.js
const vueConfig = {
  publicPath: '/',
  chainWebpack: (config) => {
    // 添加别名
    config.resolve.alias.set('@$', resolve('src'))
    // 修改HMR
    config.resolve.symlinks(true)

    const svgRule = config.module.rule('svg')
    svgRule.uses.clear()
    svgRule
      .oneOf('inline')
      .resourceQuery(/inline/)
      .use('vue-svg-icon-loader')
      .loader('vue-svg-icon-loader')
      .end()
      .end()
      .oneOf('external')
      .use('file-loader')
      .loader('file-loader')
      .options({
        name: 'assets/[name].[hash:8].[ext]'
      })
  },
  css: {
    loaderOptions: {
      less: {
        lessOptions: {
          javascriptEnabled: true
        }
      }
    }
  },
  devServer: {
    // development server port 8000
    port: 8088,
    proxy: {
       '/flame': {
         target: 'http://localhost:8099',
         // 是否启用 websockets
         ws: false,
         // 使用的是http协议则设置为false，https协议则设置为true
         secure: false,
         // 开启代理：在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样客户端端和服务端进行数据的交互就不会有跨域问题
         changeOrigin: true,
         pathRewrite: {
           '^/flame': ''
         }
       }
     }
  },
  lintOnSave: undefined,
  // disable source map in production
  productionSourceMap: false,
  // babel-loader no-ignore node_modules/*
  transpileDependencies: [],
  configureWebpack: {
    plugins: [new DuplicatePackageCheckerPlugin()]
  }
}

module.exports = vueConfig
