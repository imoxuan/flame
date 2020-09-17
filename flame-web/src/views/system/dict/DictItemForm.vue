<template>
  <a-spin :spinning="confirmLoading">
    <a-form :form="form" v-bind="formItemLayout">
      <a-form-item label="名称">
        <a-input v-decorator="['itemValue', validatorRules.itemValue]" auto-focus/>
      </a-form-item>
      <a-form-item label="数据值">
        <a-input v-decorator="['itemKey', validatorRules.itemKey]"/>
      </a-form-item>
      <a-form-item label="描述">
        <a-textarea />
      </a-form-item>
      <a-form-item label="排序">
        <a-input-number v-decorator="['sortNo', validatorRules.sortNo]" />
      </a-form-item>
      <a-form-item label="是否启用">
        <a-radio-group v-decorator="['enabled', validatorRules.enabled]">
          <a-radio :value="true">启用</a-radio>
          <a-radio :value="false">停用</a-radio>
        </a-radio-group>
      </a-form-item>
    </a-form>
  </a-spin>
</template>

<script>
  import { httpAction } from '@/utils/manage'
  import pick from 'lodash.pick'
  import { dictItemApiApi } from '@/api/index'
  export default {
    name: 'DictForm',
    data () {
      return {
        form: this.$form.createForm(this),
        model: {},
        confirmLoading: false,
        dictCode: '',
        dictId: '',
        formItemLayout: {
          labelCol: {
            xs: { span: 24 },
            sm: { span: 5 }
          },
          wrapperCol: {
            xs: { span: 24 },
            sm: { span: 16 }
          }
        },
        validatorRules: {
          itemValue: {
            rules: [
              {
                required: true,
                message: '请输入名称'
              }
            ]
          },
          itemKey: {
            rules: [
              {
                required: true,
                message: '请输入编码'
              },
              {
                max: 10,
                message: '长度超出 10 个字符'
              }
            ]
          },
          enabled: {
            rules: [
              {
                required: true,
                message: '请选择是否启用'
              }
            ],
            initialValue: true
          },
          sortNo: {
            rules: [
              {
                required: true,
                message: '请输入排序值'
              },
              {
                type: 'number',
                min: 1,
                message: '排序不能小于 1'
              }
            ],
            initialValue: 1
          }
        },
        url: {
          add: dictItemApiApi.add,
          edit: dictItemApiApi.edit
        }
      }
    },
    methods: {
      add (dictId, dictCode) {
        this.dictCode = dictCode
        this.dictId = dictId
        this.edit({})
      },
      edit (record) {
        this.form.resetFields()
        this.model = Object.assign({}, record)
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model, 'itemValue', 'itemKey', 'description', 'sortNo', 'enabled'))
        })
      },
      submitForm () {
        const that = this
        // 触发表单验证
        this.form.validateFields({
          first: true
        }, (err, values) => {
          if (!err) {
            that.confirmLoading = true
            let httpUrl = ''
            let method
            let formData
            if (!that.model.id) {
              httpUrl += this.url.add
              method = 'post'
              formData = Object.assign(that.model, values)
            } else {
              httpUrl += that.url.edit
              method = 'put'
              const diffData = {}
              for (const k in values) {
                if (Object.prototype.hasOwnProperty.call(values, k)) {
                  if (values[k] !== that.model[k]) {
                    diffData[k] = values[k]
                  }
                }
              }
              formData = Object.assign({}, diffData, { id: that.model.id })
            }
            httpAction(httpUrl, formData, method).then((res) => {
              if (res.code === 0) {
                that.$message.success('操作成功')
                that.$emit('ok')
              } else {
                that.$message.warning(res.message)
              }
            }).finally(() => {
              that.confirmLoading = false
            })
          }
        })
      }
    }
  }
</script>

<style>

</style>
