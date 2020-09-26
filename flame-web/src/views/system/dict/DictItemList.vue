<template>
  <a-card :bordered="false">
    <!-- 抽屉 -->
    <a-drawer
      title="字典项列表"
      @close="onClose"
      :visible="drawerVisible"
      :width="screenWidth"
    >
      <div class="table-operator">
        <a-button type="primary" icon="plus" @click="handleAdd">新增</a-button>
      </div>
      <a-table
        bordered
        size="middle"
        rowKey="id"
        :loading="loading"
        :columns="columns"
        :data-source="dataSource"
      >
        <template slot="action" slot-scope="text, record">
          <a @click="handleEdit(record)">编辑</a>
          <a-divider type="vertical" />
          <a-popconfirm title="确定删除吗?" @confirm="() => handleDelete(record.id)">
            <a>删除</a>
          </a-popconfirm>
        </template>

      </a-table>
      <dict-item-modal ref="itemModal" @ok="modalFormOk"></dict-item-modal>
    </a-drawer>
  </a-card>
</template>

<script>
  import DictItemModal from '@/views/system/dict/DictItemModal'
  import { ListMixin } from '@/mixins/ListMixin'
  import { dictItemApi } from '@/api/index'
  import { getAction } from '@/utils/manage'
  const columns = [
    {
      title: '名称',
      dataIndex: 'itemValue'
    },
    {
      title: '数据值',
      dataIndex: 'itemKey'
    },
    {
      title: '排序',
      dataIndex: 'sortNo'
    },
    {
      title: '操作',
      width: 200,
      dataIndex: 'action',
      scopedSlots: { customRender: 'action' }
    }
  ]

  export default {
    name: 'DictItemList',
    mixins: [ListMixin],
    components: {
      DictItemModal
    },
    data () {
      return {
        drawerVisible: false,
        visible: true,
        screenWidth: 600,
        columns: columns,
        dictCode: '',
        dictId: '',
        url: {
          list: dictItemApi.list,
          deleteBatch: dictItemApi.deleteBatch,
          delete: dictItemApi.delete
        }
      }
    },
    methods: {
      handleAdd () {
        this.$refs.itemModal.add(this.dictId, this.dictCode)
      },
      handleEdit: function (record) {
        this.visible = true
        this.$nextTick(() => {
          this.$refs.itemModal.edit(record)
          this.$refs.itemModal.title = '编辑'
          this.$refs.itemModal.disableSubmit = false
        })
      },
      edit (record) {
        this.dictCode = record.code
        this.dictId = record.id
        this.drawerVisible = true
        this.loadData(record)
      },
      onClose () {
        this.drawerVisible = false
      },
      loadData (record) {
        const params = this.getQueryParams()
        // params.dictCode = record.code
        this.loading = true
        getAction(this.url.list, params).then((res) => {
          if (res.code === 0) {
            this.dataSource = res.data
          }
        }).finally(() => {
          this.loading = false
        })
      }
    }
  }
</script>
<style scoped>
</style>
