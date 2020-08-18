<template>
  <a-spin :spinning="confirmLoading">
    <a-form :form="form">
      <a-form-item label="集团名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
        <a-input v-decorator="['name', validatorRules.name]" ref="firstInput" auto-focus/>
      </a-form-item>
      <a-form-item label="英文名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
        <a-input v-decorator="['enName', validatorRules.enName]"/>
      </a-form-item>
      <a-form-item label="集团简称" :labelCol="labelCol" :wrapperCol="wrapperCol">
        <a-input v-decorator="['shortName', validatorRules.shortName]"/>
      </a-form-item>
      <a-form-item label="集团编码" :labelCol="labelCol" :wrapperCol="wrapperCol">
        <a-input v-decorator="['code', validatorRules.code]"/>
      </a-form-item>
    </a-form>
  </a-spin>
</template>

<script>
  import { httpAction } from '@/utils/manage'
  import pick from 'lodash.pick'
  import OrgApi from '@/api/org'
  export default {
    name: 'OrgForm',
    data () {
      return {
        form: this.$form.createForm(this),
        model: {},
        // 编辑之前的数据
        preData: {},
        confirmLoading: false,
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 }
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 }
        },
        validatorRules: {
          name: {
            rules: [
              {
                required: true,
                message: '请输入集团名称'
              },
              {
                max: 30,
                message: '长度超出 30 个字符'
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
                required: true,
                message: '请输入集团简称'
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
                required: false,
                message: '请输入集团编码'
              },
              {
                max: 10,
                message: '长度超出 10 个字符'
              }
            ]
          }
        },
        url: {
          add: OrgApi.add,
          edit: OrgApi.edit
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
        this.preData = Object.assign({}, record)
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model, 'name', 'enName', 'shortName', 'code'))
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
            if (!this.model.id) {
              httpUrl += this.url.add
              method = 'post'
              formData = Object.assign(this.model, values)
            } else {
              httpUrl += this.url.edit
              method = 'put'
              const diffData = {}
              for (const k in this.preData) {
                if (this.preData[k] !== this.model[k]) {
                  diffData[k] = this.model[k]
                }
              }
              formData = Object.assign({}, diffData)
            }
            httpAction(httpUrl, formData, method).then((res) => {
              console.log(res)
              if (res.code === '00000') {
                that.$message.success(res.message)
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
