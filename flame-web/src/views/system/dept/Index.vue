<template>
  <div>
    <div class="table-operator">
      <a-button type="primary" icon="plus">新增</a-button>
      <a-button type="default" icon="delete">删除</a-button>
    </div>
    <a-row :gutter="16">
      <a-col :md="6" :sm="24">
        <a-card :bordered="false">
          <a-tree
            v-if="treeData.length"
            :loading="loading"
            :treeData="treeData"
            defaultExpandAll
            showIcon
            @select="select">
            <a-icon slot="switcherIcon" type="down" />
            <a-icon slot="icon" type="apartment" style="font-size: 12px;" />
          </a-tree>
        </a-card>
      </a-col>
      <a-col :md="18" :sm="24">
        <a-card :bordered="false">
          <dept-form />
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<script>
  import { getAction } from '@/utils/manage'
  import { deptApi } from '@/api/index'
  import DeptForm from '@/views/system/dept/DeptForm'
  export default {
    name: 'DeptList',
    components: {
      DeptForm
    },
    data () {
      return {
        loading: false,
        treeData: [],
        selectedNode: '',
        url: {
          data: deptApi.tree
        }
      }
    },
    created () {
      this.loadData()
    },
    methods: {
      loadData () {
        this.loading = true
        // 加载 tree 数据
        getAction(this.url.data, {
          orgId: '1298178547300851713'
        }).then((res) => {
          if (res.code === 0) {
            this.treeData = res.data
          } else {
            this.$message.error(res.message)
          }
          this.loading = false
        })
      },
      select (selectedKeys, e) {
        this.selectedNode = e.selectedNodes[0].data.props
      }
    }
  }
</script>

<style>
</style>
