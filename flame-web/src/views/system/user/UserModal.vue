<template>
  <a-modal
    :width="600"
    :title="title"
    :visible="visible"
    :maskClosable="maskClosable"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    :okButtonProps="{ props: { disabled: disableSubmit }}"
    @cancel="handleCancel">
    <user-form ref="modalForm" @ok="submitCallback"/>
  </a-modal>
</template>

<script>
  import UserForm from '@/views/system/user/UserForm'
  export default {
    name: 'UserModal',
    components: {
      UserForm
    },
    data () {
      return {
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
        this.$emit('close')
        this.visible = false
      },
      handleOk () {
        this.$refs.modalForm.submitForm()
      },
      handleCancel () {
        this.close()
      },
      submitCallback () {
        this.$emit('ok')
        this.visible = false
      }
    }
  }
</script>

<style>

</style>
