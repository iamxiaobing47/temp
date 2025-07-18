<template>
  <v-card>
    <v-card-title>
      <span class="text-h5">{{ isAdmin ? '管理员列表' : '普通用户列表' }}</span>
      <v-spacer></v-spacer>
      <v-btn color="error" @click="authStore.logout">退出登录</v-btn>
    </v-card-title>
    <v-data-table
      :items="authStore.userList"
      :headers="headers"
      item-key="id"
      @click:row="handleRowClick"
    >
      <template #item.actions="{ item }">
        <v-btn icon @click.stop="authStore.setSelectedUser(item)">
          <v-icon>mdi-eye</v-icon>
        </v-btn>
      </template>
      <!-- 权限列表格式化显示 -->
      <template #item.permissions="{ item }">
        <v-chip-group v-if="item.permissions && item.permissions.length">
          <v-chip v-for="perm in item.permissions" :key="perm" size="small" class="mr-1">
            {{ perm }}
          </v-chip>
        </v-chip-group>
      </template>
    </v-data-table>
    <UserDetailDialog />
  </v-card>
</template>

<script lang="ts" setup>
import { computed } from 'vue'
import { useAuthStore } from '@/stores/auth'
import UserDetailDialog from './UserDetailDialog.vue'
import { User } from '@/api' // 导入自动生成的User类型

const authStore = useAuthStore()
const isAdmin = computed(() => authStore.isAdmin)

// 动态表头（根据用户类型显示不同字段）
const headers = computed(() => {
  const baseHeaders = [
    { text: 'ID', value: 'id' },
    { text: '用户名', value: 'username' },
    { text: '姓名', value: 'name' },
    { text: '年龄', value: 'age' },
    { text: '邮箱', value: 'email' },
  ]

  // 管理员额外显示部门和权限
  if (isAdmin.value) {
    baseHeaders.push({ text: '部门', value: 'department' }, { text: '权限', value: 'permissions' })
  }

  baseHeaders.push({ text: '操作', value: 'actions', sortable: false })
  return baseHeaders
})

// 点击行选中用户
const handleRowClick = (item: User) => {
  authStore.setSelectedUser(item)
}
</script>
