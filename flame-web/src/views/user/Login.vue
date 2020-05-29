<template>
  <div class="main">
    <a-form :form="form" class="login-form" @submit.prevent="handleSubmit">
      <a-form-item>
        <a-input
          v-decorator="[
            'userName',
            { rules: [{ required: true, message: '请输入帐户名!' }] },
          ]"
          placeholder="帐户名"
          size="large">
          <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input
          v-decorator="[
            'password',
            { rules: [{ required: true, message: '请输入密码!' }] },
          ]"
          type="password"
          placeholder="密码"
          size="large"
        >
          <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
        </a-input>
      </a-form-item>
      <!--<a-form-item>
        <a-checkbox
          v-decorator="[
            'remember',
            {
              valuePropName: 'checked',
              initialValue: true,
            },
          ]"
        >Remember me
        </a-checkbox>
      </a-form-item>-->
      <a-form-item>
        <a-button type="primary" html-type="submit" block size="large">登 录</a-button>
      </a-form-item>
    </a-form>

  </div>
</template>

<script>
  import storage from 'store'
  export default {
    name: 'Login',
    data () {
      return {
        form: this.$form.createForm(this)
      }
    },
    methods: {
      loginSuccess () {
        console.log('sssssssssss')
        storage.set('token', 'sissies', 7 * 24 * 60 * 60 * 1000)
        this.$router.push({ path: '/home' })
      },
      handleSubmit () {
        const { form: { validateFields } } = this
        validateFields({ first: true, force: true }, (error, values) => {
          if (!error) {
            this.loginSuccess()
          }
        })
      }
    }
  }
</script>

<style lang="less" scoped>
  .main {
    background-color: #f5f5f5;
    padding-top: 40px;
    width: 300px;
    margin: 0 auto;
  }
</style>
