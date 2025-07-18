<template>
  <v-card max-width="500" mx-auto mt-10>
    <v-card-title class="text-center text-h4">用户登录</v-card-title>
    <v-card-text>
      <v-form @submit.prevent="handleSubmit">
        <v-text-field
          v-model="username"
          label="用户名"
          required
          prepend-icon="mdi-account"
          :rules="usernameRules"
        ></v-text-field>
        <v-text-field
          v-model="password"
          label="密码"
          type="password"
          required
          prepend-icon="mdi-lock"
          :rules="passwordRules"
        ></v-text-field>
        <v-btn type="submit" color="primary" block class="mt-4"> 登录 </v-btn>
      </v-form>
    </v-card-text>
  </v-card>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { useAuthStore } from '@/stores/auth'
import { DefaultApi } from '@/api' // 导入自动生成的API

// 初始化API实例
const api = new DefaultApi()

const authStore = useAuthStore()
const username = ref('')
const password = ref('')

// 表单验证规则
const usernameRules = [(v: string) => !!v || '用户名不能为空']
const passwordRules = [(v: string) => !!v || '密码不能为空']

// 使用自动生成的login接口
const handleSubmit = async () => {
  try {
    // 调用API：参数为{username, password}，符合自动生成的requestBody类型
    const response = await api.login({ username: username.value, password: password.value })
    authStore.handleLogin(response.data) // 存储登录状态
  } catch (error) {
    console.error('登录失败:', error)
    alert('登录失败，请检查用户名和密码')
  }
}
</script>
