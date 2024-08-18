<!--
 * @Author: shemin
 * @Date: 2024-08-18 10:59:14
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-18 11:24:12
 * @Description: file content
 * @FilePath: \explorience\explorience-frontend\src\components\Header.vue
-->

<template>
  <div class="header-container">
    <header class="header">
      <div class="header-logo">
        <img src="@/assets/logo.png" alt="Logo" />
      </div>
      <div class="nav-bar">
        <NavBar />
      </div>
      <ActionBar />
    </header>
  </div>
</template>
<script>
import NavBar from "./NavBar.vue";
import ActionBar from "./ActionBar.vue";
export default {
  name: "HeaderComponent",
  components: {
    NavBar,
    ActionBar,
  },
};
</script>

<style scoped>
.header-container {
  position: relative;
}
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  background: transparent;
  z-index: 999;
}
.header-logo img {
  height: 40px; /* 根据需要调整 logo 的大小 */
}

.nav-bar {
  z-index: 999;
  background: transparent;
  display: flex;
  align-items: center;
  width: 60%;
}
</style>
