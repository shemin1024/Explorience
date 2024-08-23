<!--
 * @Author: shemin
 * @Date: 2024-08-18 11:10:21
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-20 10:50:45
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\components\ActionBar.vue
-->
<template>
  <div class="action-bar">
    <el-button round type="warning" @click="goToLogin">
      {{ $t("login") }}
    </el-button>
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
<script>
export default {
  name: "ActionBar",
  data() {
    return {
      currentLanguage: this.$i18n.locale, // 获取当前语言
    };
  },
  methods: {
    changeLanguage(lang) {
      this.$i18n.locale = lang; // 切换语言
    },
    goToLogin() {
      this.$router.push({ name: "Login" });
    },
  },
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
</style>
