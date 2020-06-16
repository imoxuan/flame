<template>
  <a-card :bordered="false">
    <div class="table-operator">
      <a-button type="primary" icon="plus" @click="handleAdd">新建</a-button>
      <a-input v-focus/>
    </div>
    <org-modal ref="modalForm"/>
  </a-card>
</template>

<script>
  import OrgModal from '@/views/system/org/modules/OrgModal'
  export default {
    name: 'Index',
    components: {
      OrgModal
    },
    data () {
      return {
        visible: false
      }
    },
    methods: {
      handleAdd () {
        this.$refs.modalForm.add()
        this.$refs.modalForm.title = '新建'
      }
    }
  }
</script>

<style scoped>

</style>
