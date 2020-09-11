<template>
  <a-spin :spinning="confirmLoading">
    <a-form :form="form" v-bind="formItemLayout">
      <a-card title="部门基本信息" :bordered="false" class="form-card--mt">
        <a-form-item label="上级">
          <a-input disabled/>
        </a-form-item>
        <a-form-item label="部门名称">
          <a-input auto-focus/>
        </a-form-item>
        <a-form-item label="部门编码">
          <a-input auto-focus/>
        </a-form-item>
        <a-form-item label="部门排序">
          <a-input-number defaultValue="3"/>
        </a-form-item>
      </a-card>
      <a-card title="部门管理信息" :bordered="false" class="form-card--mt">
        <a-form-item label="部门主管">
          <a-input/>
        </a-form-item>
        <a-form-item label="部门分管领导">
          <a-input/>
        </a-form-item>
        <a-form-item v-bind="tailFormItemLayout">
          <a-button type="primary">
            Submit
          </a-button>
        </a-form-item>
      </a-card>
    </a-form>
  </a-spin>
</template>

<script>
  export default {
    name: 'DeptForm',
    data () {
      return {
        form: this.$form.createForm(this),
        formItemLayout: {
          labelCol: {
            xs: { span: 24 },
            sm: { span: 4 }
          },
          wrapperCol: {
            xs: { span: 24 },
            sm: { span: 16 }
          }
        },
        tailFormItemLayout: {
          wrapperCol: {
            xs: {
              span: 24,
              offset: 0
            },
            sm: {
              span: 16,
              offset: 4
            }
          }
        },
        confirmLoading: false
      }
    }
  }
</script>

<style>
.form-card--mt {
  margin-top: -16px;
}
</style>
