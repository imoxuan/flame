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
    <dict-item-form ref="modalForm" @ok="submitCallback"/>
  </a-modal>
</template>

<script>
  import DictItemForm from '@/views/system/dict/DictItemForm'
  export default {
    name: 'DictModal',
    components: {
      DictItemForm
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
      add (dictId, dictCode) {
        this.visible = true
        this.$nextTick(() => {
          this.$refs.modalForm.add(dictId, dictCode)
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
        this.$emit('ok')
        this.visible = false
      }
    }
  }
</script>

<style>

</style>
