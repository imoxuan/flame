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
            defaultExpandAll
            :showIcon="true"
            :treeData="treeData">
            <a-icon slot="icon" type="cluster" />
          </a-tree>
        </a-card>
      </a-col>
      <a-col :md="18" :sm="24">
        <a-card :bordered="false">
          nn
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<script>
  import { getAction } from '@/utils/manage'
  import { deptApi } from '@/api/index'
const departTree = [{
  key: '6d35e179cd814e3299bd588ea7daed3f',
  title: '廊坊市人民防空办公室',
  isLeaf: false,
  slots: {
    icon: 'icon'
  },
  children: [{
    key: 'bbdb2d750b3c4944aa7f357db5738cfe',
    title: '办领导',
    isLeaf: true,
    slots: {
      icon: 'icon'
    }
  }, {
    key: 'ba68db710fcc4d12b11a5b99a0b5e24c',
    title: '秘书科',
    isLeaf: true,
    slots: {
      icon: 'icon'
    }
  }
  ]
}
]
export default {
  name: 'DeptList',
  data () {
    return {
      treeData: departTree,
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
      // 加载 tree 数据
      getAction(this.url.data, null).then((res) => {
        if (res.code === 0) {
          this.treeData = res.data
        } else {
          this.$message.error(res.message)
        }
      })
    }
  }
}
</script>

<style>
</style>
