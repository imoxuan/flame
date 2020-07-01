<template>
  <a-card :bordered="false">
    <div class="table-operator">
      <a-button type="primary" icon="plus" @click="handleAdd">新增</a-button>
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
        this.$refs.modalForm.title = '新增'
      }
    }
  }
</script>

<style scoped>
#main {
  background-color: pink;
}
</style>
