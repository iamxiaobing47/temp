<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <v-app-bar-title>用户管理系统</v-app-bar-title>
      <v-spacer></v-spacer>
      <v-btn text @click="logout">
        <v-icon>mdi-logout</v-icon>
        退出登录
      </v-btn>
    </v-app-bar>

    <v-main>
      <v-container fluid class="pa-4">
        <UserTable :userList="userList" :isAdmin="isAdmin" @user-selected="handleUserSelected" />

        <UserDetailDialog :user="selectedUser" :isAdmin="isAdmin" :dialogVisible="dialogVisible" />
      </v-container>
    </v-main>
  </v-app>
</template>

<script lang="ts" setup>
import { ref, computed, onMounted } from 'vue'
import { useAuthStore } from '@/stores/auth'
import UserTable from '@/components/UserTable.vue'
import UserDetailDialog from '@/components/UserDetailDialog.vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const authStore = useAuthStore()

const dialogVisible = ref(false)
const selectedUser = ref(null)

const userList = computed(() => authStore.userList)
const isAdmin = computed(() => authStore.isAdmin)

onMounted(() => {
  if (!authStore.isAuthenticated) {
    router.push('/login')
  }
})

const handleUserSelected = (user: any) => {
  selectedUser.value = user
  dialogVisible.value = true
}

const logout = () => {
  authStore.logout()
  router.push('/login')
}
</script>
