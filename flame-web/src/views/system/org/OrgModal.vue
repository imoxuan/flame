<template>
  <a-modal
    :title="title"
    :visible="visible"
    :maskClosable="maskClosable"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    :okButtonProps="{ props: { disabled: disableSubmit }}"
    @cancel="handleCancel">
    <org-form ref="modalForm" @ok="submitCallback"/>
  </a-modal>
</template>

<script>
  import OrgForm from '@/views/system/org/OrgForm'
  export default {
    name: 'OrgModal',
    components: {
      OrgForm
    },
    data () {
      return {
        form: this.$form.createForm(this),
        title: '',
        confirmLoading: false,
        visible: false,
        maskClosable: false,
        disableSubmit: false
      }
    },
    methods: {
      add () {
        this.visible = true
        this.$nextTick(() => {
          this.$refs.modalForm.add()
        })
      },
      edit (record) {
        this.visible = true
        this.$nextTick(() => {
          this.$refs.modalForm.edit(record)
        })
      },
      close () {
        // this.handleReset()
        this.$emit('close')
        this.visible = false
      },
      handleOk () {
        this.$refs.modalForm.submitForm()
      },
      handleCancel () {
        this.close()
      },
      handleReset () {
        this.form.resetFields()
      },
      submitCallback () {
        console.log('=============')
        this.$emit('ok')
        this.visible = false
      }
    }
  }
</script>

<style>

</style>
