<template>
  <a-spin :spinning="confirmLoading">
    <a-form :form="form" v-bind="formItemLayout">
      <a-form-item label="机构名称">
        <a-input v-decorator="['name', validatorRules.name]" auto-focus/>
      </a-form-item>
      <a-form-item label="英文名称">
        <a-input v-decorator="['enName', validatorRules.enName]"/>
      </a-form-item>
      <a-form-item label="机构简称">
        <a-input v-decorator="['shortName', validatorRules.shortName]"/>
      </a-form-item>
      <a-form-item label="机构编码">
        <a-input v-decorator="['code', validatorRules.code]"/>
      </a-form-item>
      <a-form-item label="是否启用">
        <a-switch checked-children="启用" un-checked-children="停用" v-decorator="['enabled', validatorRules.enabled]" />
      </a-form-item>
      <a-form-item label="排序">
        <a-input-number v-decorator="['sortNo', validatorRules.sortNo]" />
      </a-form-item>
    </a-form>
  </a-spin>
</template>

<script>
  import { httpAction } from '@/utils/manage'
  import pick from 'lodash.pick'
  import { orgApi } from '@/api/index'
  export default {
    name: 'OrgForm',
    data () {
      return {
        form: this.$form.createForm(this),
        model: {},
        confirmLoading: false,
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
          name: {
            rules: [
              {
                required: true,
                message: '请输入机构名称'
              }
            ]
          },
          enName: {
            rules: [
              {
                required: false,
                message: '请输入英文名称'
              },
              {
                max: 60,
                message: '长度超出 60 个字符'
              }
            ]
          },
          shortName: {
            rules: [
              {
                required: false,
                message: '请输入机构简称'
              },
              {
                max: 16,
                message: '长度超出 16 个字符'
              }
            ]
          },
          code: {
            rules: [
              {
                required: true,
                message: '请输入机构编码'
              },
              {
                max: 10,
                message: '长度超出 10 个字符'
              }
            ]
          },
          enabled: {
            valuePropName: 'checked',
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
          add: orgApi.add,
          edit: orgApi.edit
        }
      }
    },
    methods: {
      add () {
        this.edit({})
      },
      edit (record) {
        this.form.resetFields()
        this.model = Object.assign({}, record)
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model, 'name', 'enName', 'shortName', 'code', 'enabled', 'sortNo'))
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
