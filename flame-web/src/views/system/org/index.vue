<template>
  <a-card :bordered="false">
    <div class="table-operator">
      <a-button type="primary" icon="plus" @click="handleAdd">新增</a-button>
      <a-button type="default" icon="delete" @click="batchDel">删除</a-button>
    </div>
    <div class="ant-alert ant-alert-info" style="margin-bottom: 16px;" v-if="selectedRowKeys.length > 0">
      <i class="anticon anticon-info-circle ant-alert-icon"/>已选择&nbsp;<a style="font-weight: 600">{{ selectedRowKeys.length }}</a> 项&nbsp;&nbsp;
      <a style="margin-left: 24px">清空</a>
    </div>

    <a-table
      size="middle"
      bordered
      rowKey="id"
      :columns="columns"
      :pagination="localPagination"
      :data-source="dataSource"
      :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
    >
      <span slot="action" slot-scope="text, record">
        <a @click="handleEdit(record)">编辑</a>
      </span>
    </a-table>
    <org-modal v-if="visible" ref="modal" @close="changeModalVisible" @ok="modalFormOk" />
  </a-card>
</template>

<script>
  import OrgModal from '@/views/system/org/OrgModal'
  import { ListMixin } from '@/mixins/ListMixin'
  import OrgApi from '@/api/org'
  const columns = [
    {
      title: '名称',
      dataIndex: 'name'
    },
    {
      title: '英文名称',
      dataIndex: 'enName'
    },
    {
      title: '简称',
      dataIndex: 'shortName'
    },
    {
      title: '编码',
      dataIndex: 'code'
    },
    {
      title: '排序',
      dataIndex: 'sortNo'
    },
    {
      title: '是否启用',
      dataIndex: 'isEnable',
      customRender: function (text, record) {
        return record.enabled ? '启用' : '停用'
      }
    },
    {
      title: '操作',
      width: 80,
      dataIndex: 'action',
      scopedSlots: { customRender: 'action' }
    }
  ]
  export default {
    name: 'Index',
    mixins: [ListMixin],
    components: {
      OrgModal
    },
    data () {
      return {
        visible: false,
        columns: columns,
        url: {
          list: OrgApi.list,
          deleteBatch: OrgApi.deleteBatch
        }
      }
    }
  }
</script>

<style>
</style>
