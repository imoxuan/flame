<template>
  <a-spin :spinning="confirmLoading">
    <a-form :form="form" v-bind="formItemLayout">
      <a-form-item label="登录名">
        <a-input v-decorator="['loginName', validatorRules.loginName]" auto-focus/>
      </a-form-item>
      <a-form-item label="密码">
        <a-input-password v-decorator="['password', validatorRules.password]" />
      </a-form-item>
      <a-form-item label="确认密码">
        <a-input-password v-decorator="['confirmPassword', validatorRules.confirmPassword]" @blur="handleConfirmBlur" />
      </a-form-item>
      <a-form-item label="姓名">
        <a-input v-decorator="['name', validatorRules.name]"/>
      </a-form-item>
      <a-form-item label="性别">
        <a-radio-group v-decorator="['gender', validatorRules.gender]">
          <a-radio :value="1">男</a-radio>
          <a-radio :value="2">女</a-radio>
        </a-radio-group>
      </a-form-item>
      <a-form-item label="是否启用">
        <a-radio-group v-decorator="['enabled', validatorRules.enabled]">
          <a-radio :value="true">启用</a-radio>
          <a-radio :value="false">停用</a-radio>
        </a-radio-group>
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
  import { userApi } from '@/api/index'
  export default {
    name: 'OrgForm',
    data () {
      return {
        confirmDirty: false,
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
          loginName: {
            rules: [
              {
                required: true,
                message: '请输入登录名'
              }
            ]
          },
          password: {
            rules: [
              {
                required: true,
                message: '请输入密码'
              },
              {
                validator: this.validateToNextPassword
              }
            ]
          },
          confirmPassword: {
            rules: [
              {
                required: true,
                message: '请输入确认密码'
              },
              {
                validator: this.compareToFirstPassword
              }
            ]
          },
          name: {
            rules: [
              {
                required: true,
                message: '请输入机构名称'
              }
            ]
          },
          gender: {
            rules: [
              {
                required: true,
                message: '请选择性别'
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
          add: userApi.add,
          edit: userApi.edit
        }
      }
    },
    methods: {
      compareToFirstPassword (rule, value, callback) {
        const form = this.form
        if (value && value !== form.getFieldValue('password')) {
          const message = '两次输入的密码不一致'
          callback(message)
        } else {
          callback()
        }
      },
      validateToNextPassword (rule, value, callback) {
        const form = this.form
        if (value && this.confirmDirty) {
          form.validateFields(['confirm'], { force: true })
        }
        callback()
      },
      handleConfirmBlur (e) {
        const value = e.target.value
        this.confirmDirty = this.confirmDirty || !!value
      },
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
