/// <reference types="vite/client" />

declare module '*.vue' {
  import type { DefineComponent } from 'vue'
  const component: DefineComponent<{}, {}, any>
  export default component
}

// 为 Vuetify 组件添加类型支持
import 'vuetify'

declare module '@vue/runtime-core' {
  export interface GlobalComponents {
    VApp: (typeof import('vuetify/components'))['VApp']
    VBtn: (typeof import('vuetify/components'))['VBtn']
    // 添加更多组件类型声明...
  }
}
