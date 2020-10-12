<template>
  <div>
    <a-layout id="components-layout-demo-side" style="min-height: 100vh">
      <a-layout-sider v-model="collapsed" :trigger="null">
        <div class="logo" style="height:64px;color:#fff">Flame----</div>
        <a-menu theme="dark" :default-selected-keys="['2']" :defaultOpenKeys="['sub1']" mode="inline">
          <a-sub-menu key="sub1">
            <span slot="title"><a-icon type="apartment" /><span>组织结构设置</span></span>
            <a-menu-item key="2">
              <router-link to="/org">机构管理</router-link>
            </a-menu-item>
            <a-menu-item key="3">
              <router-link to="/dept">部门管理</router-link>
            </a-menu-item>
            <a-menu-item key="4">
              <router-link to="/user">人员管理</router-link>
            </a-menu-item>
            <a-menu-item key="5">
              <router-link to="/dict">数据字典</router-link>
            </a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <span slot="title"><a-icon type="team" /><span>Team</span></span>
            <a-menu-item key="6">
              Team 1
            </a-menu-item>
            <a-menu-item key="8">
              Team 2
            </a-menu-item>
          </a-sub-menu>
          <a-menu-item key="9">
            <a-icon type="file" />
            <span>File</span>
          </a-menu-item>
        </a-menu>
      </a-layout-sider>
      <a-layout>
        <a-layout-header style="background: #fff; padding: 0; margin-bottom: 12px;">
          <a-icon :type="collapsed ? 'menu-unfold' : 'menu-fold'" class="collapsed-icon" @click="collapsed = !collapsed" />
          头部
        </a-layout-header>
        <a-layout-content style="margin: 0 12px">
          <router-view/>
        </a-layout-content>
        <a-layout-footer style="text-align: center">
          Ant Design ©2020 Created by Flame
        </a-layout-footer>
      </a-layout>
    </a-layout>

  </div>
</template>

<script>
  export default {
    name: 'BasicLayout',
    data () {
      return {
        collapsed: false
      }
    }
  }
</script>

<style scoped>
.collapsed-icon {
  padding: 0 20px;
  font-size: 20px;
}
</style>
