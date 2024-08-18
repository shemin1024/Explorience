<!--
 * @Author: shemin
 * @Date: 2024-08-18 11:10:21
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-18 12:50:23
 * @Description: file content
 * @FilePath: \explorience\explorience-frontend\src\components\ActionBar.vue
-->
<template>
  <div class="action-bar">
    <el-button round type="warning" @click="$router.push('/login')">
      {{ $t("login") }}
    </el-button>
    <el-button round type="warning" @click="$router.push('/register')">
      {{ $t("register") }}
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
