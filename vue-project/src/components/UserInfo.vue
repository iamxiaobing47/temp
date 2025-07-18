<template>
  <div class="user-info">
    <div v-if="loading" class="loading">加载中...</div>
    <div v-else-if="error" class="error">
      {{ error }}
    </div>
    <div v-else class="user-details">
      <h2>用户信息</h2>
      <div class="info-item">
        <span class="label">姓名:</span>
        <span class="value">{{ user.name }}</span>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { DefaultApi, Configuration } from '../api'
import type { SampleUser } from '../api'

const config = new Configuration({
  basePath: 'http://localhost:8080',
})

const api = new DefaultApi(config)

const user = ref<SampleUser | null>(null)
const loading = ref(true)
const error = ref<string | null>(null)

onMounted(async () => {
  try {
    const response = await api.getUser()
    user.value = response.data
  } catch (e) {
    error.value = '获取用户信息失败'
    console.error('Error fetching user:', e)
  } finally {
    loading.value = false
  }
})
</script>

<style scoped>
.user-info {
  max-width: 600px;
  margin: 20px auto;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  background-color: white;
}

.loading,
.error {
  text-align: center;
  padding: 20px;
  color: #666;
}

.error {
  color: #ff4444;
}

.user-details h2 {
  margin-bottom: 20px;
  color: #333;
}

.info-item {
  display: flex;
  margin-bottom: 15px;
  padding: 10px;
  background-color: #f8f9fa;
  border-radius: 4px;
}

.label {
  font-weight: bold;
  width: 100px;
  color: #555;
}

.value {
  flex: 1;
  color: #333;
}
</style>
