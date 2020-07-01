<template>
  <a-modal
    :title="title"
    :visible="visible"
    :maskClosable="maskClosable"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    @cancel="handleCancel">
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">
        <a-form-item label="集团名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="['name', validatorRules.name]" v-focus/>
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
  </a-modal>
</template>

<script>
  export default {
    name: 'OrgModal',
    data () {
      return {
        form: this.$form.createForm(this),
        title: '操作',
        confirmLoading: false,
        visible: false,
        maskClosable: false,
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
                required: true,
                message: '请输入集团编码'
              },
              {
                max: 10,
                message: '长度超出 10 个字符'
              }
            ]
          }
        }
      }
    },
    created () {
      console.log('org-modal create')
    },
    methods: {
      add () {
        this.visible = true
      },
      close () {
        this.handleReset()
        this.$emit('close')
        this.visible = false
      },
      handleOk () {
        const that = this
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true
            const formData = Object.assign({}, values)
            that.$api.org.add(formData).then((res) => {
              console.log(res)
            }).finally(() => {
              that.close()
            })
          }
        })
      },
      handleCancel () {
        this.close()
      },
      handleReset () {
        this.form.resetFields()
      }
    }
  }
</script>

<style scoped>

</style>
