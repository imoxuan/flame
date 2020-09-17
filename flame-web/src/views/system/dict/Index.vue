<template>
  <a-card :bordered="false">
    <div class="table-operator">
      <a-button type="primary" icon="plus" @click="handleAdd">新增</a-button>
      <a-button type="default" icon="delete" @click="batchDel">删除</a-button>
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
        <a @click="editDictItem(record)">字典配置</a>
        <a-divider type="vertical" />
        <a-popconfirm title="确定删除吗?" @confirm="() => handleDelete(record.id)">
          <a>删除</a>
        </a-popconfirm>
      </template>
    </a-table>
    <dict-modal v-if="visible" ref="modal" @close="changeModalVisible" @ok="modalFormOk" />
    <dict-item-list ref="dictItemList"></dict-item-list>
  </a-card>
</template>

<script>
  import DictModal from '@/views/system/dict/DictModal'
  import DictItemList from '@/views/system/dict/DictItemList'
  import { ListMixin } from '@/mixins/ListMixin'
  import { dictApi } from '@/api/index'
  const columns = [
    {
      title: '名称',
      dataIndex: 'name'
    },
    {
      title: '编码',
      dataIndex: 'code'
    },
    {
      title: '描述',
      dataIndex: 'description'
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
      width: 200,
      dataIndex: 'action',
      scopedSlots: { customRender: 'action' }
    }
  ]
  export default {
    name: 'DictList',
    mixins: [ListMixin],
    components: {
      DictModal,
      DictItemList
    },
    data () {
      return {
        visible: false,
        columns: columns,
        url: {
          list: dictApi.list,
          deleteBatch: dictApi.deleteBatch,
          delete: dictApi.delete
        }
      }
    },
    methods: {
      editDictItem (record) {
        this.$refs.dictItemList.edit(record)
      }
    }
  }
</script>

<style>
</style>
