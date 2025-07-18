import { defineStore } from 'pinia'
import { ref, computed } from 'vue'
import type { User, LoginResponse } from '@/api/api.ts' // 导入自动生成的类型
// 导入自动生成的类型

export const useAuthStore = defineStore('auth', () => {
  // 状态
  const userType = ref<'admin' | 'normal' | null>(null)
  const userList = ref<User[]>([])
  const selectedUser = ref<User | null>(null)
  const isLoggedIn = ref(false)
  const detailDialog = ref(false) // 控制详情弹窗

  // 计算属性
  const isAdmin = computed(() => userType.value === 'admin')

  // 登录动作（接收自动生成的LoginResponse类型）
  const handleLogin = (response: LoginResponse) => {
    if (response.flag && ['admin', 'normal'].includes(response.flag)) {
      userType.value = response.flag as 'admin' | 'normal'
      userList.value = response.userInfoList || []
      isLoggedIn.value = true
    }
  }

  // 选择用户动作
  const setSelectedUser = (user: User) => {
    selectedUser.value = user
    detailDialog.value = true // 打开弹窗
  }

  // 登出动作
  const logout = () => {
    userType.value = null
    userList.value = []
    selectedUser.value = null
    isLoggedIn.value = false
  }

  return {
    userType,
    userList,
    selectedUser,
    isLoggedIn,
    detailDialog,
    isAdmin,
    handleLogin,
    setSelectedUser,
    logout,
  }
})
