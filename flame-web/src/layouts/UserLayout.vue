<template>
  <div id="userLayout" :class="['user-layout-wrapper']">
    <div class="container">
      <div class="top">
        <div class="header">
          <a href="/">
            <img src="~@/assets/logo.png" class="logo" alt="logo">
          </a>
        </div>
      </div>
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserLayout'
}
</script>

<style lang="less" scoped>
#userLayout.user-layout-wrapper {
  height: 100%;

  .container {
    background-color: #f5f5f5;
    min-height: 100%;

    .top {
      text-align: center;

      .header {
        padding-top: 80px;

        .logo {
          width: 72px;
          height: 72px;
        }
      }
    }
  }
}
</style>
