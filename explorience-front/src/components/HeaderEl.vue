<!--
 * @Author: shemin
 * @Date: 2024-08-19 16:59:55
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-20 09:51:50
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\components\HeaderEl.vue
-->
<template>
  <el-header height="60px" class="header">
    <div class="logo">
      <!-- 使用Element Plus中的图标组件来展示Logo -->
      <el-icon>
        <img src="@/assets/logo.png" alt="Logo" />
      </el-icon>
    </div>

    <el-menu :default-active="activeMenu" mode="horizontal" class="menu">
      <el-menu-item index="1">
        <el-dropdown>
          <span class="el-dropdown-link">{{ $t("popDest") }}</span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>{{ $t("wuhan") }}</el-dropdown-item>
              <el-dropdown-item>{{ $t("shanghai") }}</el-dropdown-item>
              <el-dropdown-item>{{ $t("beijing") }}</el-dropdown-item>
              <el-dropdown-item>{{ $t("guangzhou") }}</el-dropdown-item>
              <el-dropdown-item>{{ $t("chengdu") }}</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </el-menu-item>
      <el-menu-item index="2">
        <el-dropdown>
          <span class="el-dropdown-link">{{ $t("allDest") }}</span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>{{ $t("wuhan") }}</el-dropdown-item>
              <el-dropdown-item>{{ $t("shanghai") }}</el-dropdown-item>
              <el-dropdown-item>{{ $t("beijing") }}</el-dropdown-item>
              <el-dropdown-item>{{ $t("guangzhou") }}</el-dropdown-item>
              <el-dropdown-item>{{ $t("chengdu") }}</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </el-menu-item>
      <el-menu-item index="3">
        <el-dropdown>
          <span class="el-dropdown-link">{{ $t("service") }}</span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>{{ $t("visaGuide") }}</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </el-menu-item>
      <el-menu-item index="4">
        <el-dropdown>
          <span class="el-dropdown-link">{{ $t("contact") }}</span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>{{ $t("contact") }}</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </el-menu-item>
      <el-menu-item index="5">
        <el-dropdown>
          <span class="el-dropdown-link">{{ $t("about") }}</span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>{{ $t("about") }}</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </el-menu-item>
    </el-menu>

    <ActionBar class="action-bar" />
  </el-header>
</template>

<script>
import ActionBar from "./ActionBar.vue";
export default {
  name: "HeaderComponent",
  components: {
    ActionBar,
  },
};
</script>

<style scoped>
.logo img {
  height: 60px; /* 根据需要调整 logo 的大小 */
}
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
  background: transparent;
}

.logo {
  display: flex;
  align-items: center;
}

.menu {
  display: flex;
  justify-content: center;
  width: 70%;
}
.action-bar {
  display: flex;
  align-items: center;
}
.el-dropdown-link {
  color: #000;
  font-size: 16px;
  font-weight: 500; /* 设置字体粗细 */
  letter-spacing: 1px;
}
</style>
