<!--
 * @Author: shemin
 * @Date: 2024-08-18 11:10:21
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-24 13:38:34
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\components\ActionBar.vue
-->
<template>
  <div class="action-bar">
    <el-button round type="warning" @click="goToLogin" v-if="!isAuthenticated">
      {{ $t("login") }}
    </el-button>
    <el-dropdown v-if="isAuthenticated" @command="handleCommand">
      <span class="el-dropdown-link">
        {{ userInfo }}
        <el-icon><arrow-down /></el-icon>
      </span>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item command="profile">个人资料</el-dropdown-item>
          <el-dropdown-item command="settings">设置</el-dropdown-item>
          <el-dropdown-item command="logout">登出</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
    <div class="language-switcher">
      <el-select
        v-model="currentLanguage"
        @change="changeLanguage"
        placeholder="Select Language"
      >
        <el-option label="English" value="en"></el-option>
        <el-option label="中文" value="zh"></el-option>
      </el-select>
    </div>
  </div>
</template>

<script setup>
import { useI18n } from "vue-i18n";
import { computed } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
const router = useRouter();
const store = useStore();
const { locale } = useI18n();
const isAuthenticated = computed(() => store.getters.isAuthenticated);
const userInfo = computed(() => store.getters.getUserInfo);
console.log("userInfo----------" + userInfo.value);
const handleCommand = (command) => {
  if (command === "logout") {
    store.dispatch("removeToken");
    store.dispatch("saveUserInfo", null);
    router.push("/login"); // 重定向到登录页面
  } else if (command === "profile") {
    //router.push('/profile'); // 跳转到个人资料页
  } else if (command === "settings") {
    //router.push('/settings'); // 跳转到设置页
  }
};
const currentLanguage = computed({
  get() {
    return locale.value;
  },
  set(lang) {
    locale.value = lang;
  },
});
const changeLanguage = (lang) => {
  locale.value = lang;
};
const goToLogin = () => {
  router.push({ name: "Login" });
};
</script>
<style scoped>
.action-bar {
  display: flex;
  justify-content: space-around;
}
.language-switcher {
  position: relative;
  width: 100px;
  padding: 0px 10px;
}
.login-button {
  background-color: #ffcc00;
  color: #333;
  font-family: "Microsoft Yahei", Helvetica, sans-serif !important;
  font-size: 16px;
  font-weight: bold;
  padding: 4px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
.login-button:hover {
  background-color: #ffa500;
  color: white;
}
.el-dropdown-link {
  cursor: pointer;
  display: flex;
  align-items: center;
}
</style>
