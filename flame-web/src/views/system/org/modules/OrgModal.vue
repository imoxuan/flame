<template>
  <a-modal
    :title="title"
    :visible="visible"
    :maskClosable="maskClosable"
    @ok="handleOk"
    @cancel="handleCancel">
    <a-spin :spinning="spinning">
      <a-form :form="form">
        <a-form-item label="集团名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="['orgName', validatorRules.orgName]" v-focus/>
        </a-form-item>
        <a-form-item label="外文名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="['orgEnName', validatorRules.orgEnName]"/>
        </a-form-item>
        <a-form-item label="集团简称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="['shortName', validatorRules.shortName]"/>
        </a-form-item>
        <a-form-item label="集团编码" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="['orgCode', validatorRules.orgCode]"/>
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
        spinning: false,
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
          orgName: {
            rules: [
              {
                required: true,
                message: '请输入集团名称'
              },
              {
                max: 4,
                message: '长度超出 4 个字符'
              }
            ]
          },
          orgEnName: {
            rules: [
              {
                required: false,
                message: '请输入外文名称'
              },
              {
                max: 4,
                message: '长度超出 4 个字符'
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
                max: 4,
                message: '长度超出 4 个字符'
              }
            ]
          },
          orgCode: {
            rules: [
              {
                required: true,
                message: '请输入集团编码'
              },
              {
                max: 4,
                message: '长度超出 4 个字符'
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
        this.form.validateFields((err, values) => {
          if (!err) {
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
