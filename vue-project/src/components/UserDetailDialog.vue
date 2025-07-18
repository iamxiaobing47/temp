<template>
  <v-dialog v-model="authStore.detailDialog" max-width="600">
    <v-card>
      <v-card-title class="text-h5">
        用户详情
        <v-spacer></v-spacer>
        <v-btn icon @click="authStore.detailDialog = false">
          <v-icon>mdi-close</v-icon>
        </v-btn>
      </v-card-title>

      <v-card-text v-if="authStore.selectedUser">
        <v-row>
          <v-col cols="12" sm="6">
            <p><strong>ID:</strong> {{ authStore.selectedUser.id }}</p>
            <p><strong>用户名:</strong> {{ authStore.selectedUser.username }}</p>
            <p><strong>姓名:</strong> {{ authStore.selectedUser.name }}</p>
            <p><strong>年龄:</strong> {{ authStore.selectedUser.age }}</p>
            <p><strong>邮箱:</strong> {{ authStore.selectedUser.email }}</p>
          </v-col>

          <!-- 管理员特有信息 -->
          <v-col cols="12" sm="6" v-if="authStore.isAdmin && authStore.selectedUser">
            <p><strong>部门:</strong> {{ authStore.selectedUser.department || '无' }}</p>
            <p><strong>权限:</strong></p>
            <v-chip-group v-if="authStore.selectedUser.permissions">
              <v-chip v-for="perm in authStore.selectedUser.permissions" :key="perm" class="mr-2">
                {{ perm }}
              </v-chip>
            </v-chip-group>
          </v-col>
        </v-row>
      </v-card-text>

      <v-card-actions>
        <v-btn color="primary" @click="confirmSelect"> 确认选择 </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script lang="ts" setup>
import { useAuthStore } from '@/stores/auth'
import { DefaultApi } from '@/api' // 导入自动生成的API

const authStore = useAuthStore()
const api = new DefaultApi()

// 确认选择用户（调用对应接口）
const confirmSelect = async () => {
  if (!authStore.selectedUser) return

  try {
    if (authStore.isAdmin) {
      // 调用管理员选择接口
      await api.selectAdminUser(authStore.selectedUser)
      alert('管理员用户已选中')
    } else {
      // 调用普通用户选择接口
      await api.selectNormalUser(authStore.selectedUser)
      alert('普通用户已选中')
    }
    authStore.detailDialog = false // 关闭弹窗
  } catch (error) {
    console.error('选择用户失败:', error)
    alert('选择用户失败，请重试')
  }
}
</script>
