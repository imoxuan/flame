import { filterObj } from '@/utils/util'
import { deleteAction, getAction } from '@/utils/manage'

export const ListMixin = {
  data () {
    return {
      // token
      // 查询条件
      queryParam: {},
      // 数据源
      dataSource: [],
      // 分页参数
      ipagination: {
        current: 1,
        pageSize: 10,
        pageSizeOptions: ['10', '20', '30'],
        showTotal: (total, range) => {
          return `${range[0]}-${range[1]} 共${total}条`
        },
        showQuickJumper: true,
        showSizeChanger: true,
        total: 0
      },
      // 排序
      isorter: {
        column: 'createTime',
        order: 'desc'
      },
      // 筛选参数
      filters: {},
      loading: false,
      selectedRowKeys: [],
      selectionRows: []
    }
  },
  created () {
    if (!this.disableMixinCreated) {
      this.loadData()
    }
  },
  methods: {
    loadData () {
      if (!this.url.list) {
        this.$message.error('请设置url.list属性！')
        return
      }
      const params = this.getQueryParams()
      this.loading = true
      getAction(this.url.list, params).then((res) => {
        if (res.code === '00000') {
          this.dataSource = res.data.records
          this.ipagination.total = res.data.total
        } else {
          this.$message.warning(res.message)
        }
        this.loading = false
      })
    },
    getQueryParams () {
      const sqp = {}
      const param = Object.assign(sqp, this.queryParam, this.isorter, this.filters)
      param.pageNo = this.ipagination.current
      param.pageSize = this.ipagination.pageSize
      return filterObj(param)
    },
    onSelectChange (selectedRowKeys, selectionRows) {
      this.selectedRowKeys = selectedRowKeys
      this.selectionRows = selectionRows
    },
    onClearSelected () {
      this.selectedRowKeys = []
      this.selectionRows = []
    },
    batchDel () {
      if (!this.url.deleteBatch) {
        this.$message.error('请设置url.deleteBatch属性!')
        return
      }
      if (this.selectedRowKeys.length <= 0) {
        this.$message.warning('请选择一条记录！')
      } else {
        const ids = this.selectedRowKeys.join(',')
        const that = this
        this.$confirm({
          title: '确认删除',
          content: '是否删除选中数据?',
          onOk: function () {
            that.loading = true
            deleteAction(that.url.deleteBatch, { ids: ids }).then((res) => {
              if (res.code === '00000') {
                that.$message.success('删除成功')
                that.loadData()
                that.onClearSelected()
              } else {
                that.$message.warning(res.message)
              }
            }).finally(() => {
              that.loading = false
            })
          }
        })
      }
    },
    handleDelete (id) {
      if (!this.url.delete) {
        this.$message.error('请设置url.delete属性!')
        return
      }
      const that = this
      deleteAction(that.url.delete, { id: id }).then((res) => {
        if (res.code === '00000') {
          that.$message.success('删除成功')
          that.loadData()
        } else {
          that.$message.warning(res.message)
        }
      })
    },
    handleEdit: function (record) {
      this.visible = true
      this.$nextTick(() => {
        this.$refs.modal.edit(record)
        this.$refs.modal.title = '编辑'
        this.$refs.modal.disableSubmit = false
      })
    },
    handleAdd () {
      this.visible = true
      this.$nextTick(() => {
        this.$refs.modal.add()
        this.$refs.modal.title = '新增'
        this.$refs.modal.disableSubmit = false
      })
    },
    handleTableChange (pagination, filters, sorter) {
      // 分页、排序、筛选变化时触发
      // TODO 筛选
      if (Object.keys(sorter).length > 0) {
        this.isorter.column = sorter.field
        this.isorter.order = sorter.order === 'asc' ? 'asc' : 'desc'
      }
      this.ipagination = pagination
      this.loadData()
    },
    handleToggleSearch () {
      this.toggleSearchStatus = !this.toggleSearchStatus
    },
    modalFormOk () {
      // 新增/修改 成功时，重载列表
      this.loadData()
    },
    changeModalVisible () {
      this.visible = false
    }
  }
}
