<template>
  <v-app>
    <v-main>
      <template v-if="authStore.isLoggedIn">
        <UserTable />
      </template>
      <template v-else>
        <LoginForm />
      </template>
    </v-main>
  </v-app>
</template>

<script lang="ts" setup>
import { useAuthStore } from '@/stores/auth'
import LoginForm from './components/LoginForm.vue'
import UserTable from './components/UserTable.vue'

const authStore = useAuthStore()
</script>
