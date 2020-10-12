<template>
  <a-card :bordered="false">
    <div class="table-operator">
      <a-button type="primary" icon="plus" @click="handleAdd">新增</a-button>
      <a-button type="default" icon="delete" @click="batchDel">删除</a-button>
    </div>
    <div class="ant-alert ant-alert-info" style="margin-bottom: 16px;" v-if="selectedRowKeys.length > 0">
      <i class="anticon anticon-info-circle ant-alert-icon"/>已选择&nbsp;<a style="font-weight: 600">{{ selectedRowKeys.length }}</a> 项&nbsp;&nbsp;
      <a style="margin-left: 24px" @click="onClearSelected">清空</a>
    </div>

    <a-table
      size="middle"
      bordered
      rowKey="id"
      :loading="loading"
      :columns="columns"
      :pagination="ipagination"
      :data-source="dataSource"
      :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
      @change="handleTableChange"
    >
      <template slot="action" slot-scope="text, record">
        <a @click="handleEdit(record)">编辑</a>
        <a-divider type="vertical" />
        <a-popconfirm title="确定删除吗?" @confirm="() => handleDelete(record.id)">
          <a>删除</a>
        </a-popconfirm>
      </template>
    </a-table>
    <user-modal v-if="visible" ref="modal" @close="changeModalVisible" @ok="modalFormOk" />
  </a-card>
</template>

<script>
  import UserModal from '@/views/system/user/UserModal'
  import { ListMixin } from '@/mixins/ListMixin'
  import { userApi } from '@/api/index'
  const columns = [
    {
      title: '登录名',
      dataIndex: 'loginName'
    },
    {
      title: '姓名',
      dataIndex: 'name'
    },
    {
      title: '性别',
      dataIndex: 'gender'
    },
    {
      title: '出生日期',
      dataIndex: 'birthday'
    },
    {
      title: '手机号',
      dataIndex: 'mobile'
    },
    {
      title: '邮箱',
      dataIndex: 'email'
    },
    {
      title: '入职日期',
      width: 100,
      dataIndex: 'workStartDate'
    },
    {
      title: '排序',
      width: 100,
      dataIndex: 'sortNo'
    },
    {
      title: '人员类型',
      width: 100,
      dataIndex: 'userType'
    },
    {
      title: '人员状态',
      width: 100,
      dataIndex: 'state'
    },
    {
      title: '账号状态',
      width: 100,
      dataIndex: 'accountState'
    },
    {
      title: '是否启用',
      width: 100,
      dataIndex: 'isEnable',
      customRender: function (text, record) {
        return record.enabled ? '启用' : '停用'
      }
    },
    {
      title: '操作',
      width: 100,
      dataIndex: 'action',
      scopedSlots: { customRender: 'action' }
    }
  ]
  export default {
    name: 'OrgList',
    mixins: [ListMixin],
    components: {
      UserModal
    },
    data () {
      return {
        visible: false,
        columns: columns,
        url: {
          list: userApi.list,
          deleteBatch: userApi.deleteBatch,
          delete: userApi.delete
        }
      }
    }
  }
</script>

<style>
</style>
