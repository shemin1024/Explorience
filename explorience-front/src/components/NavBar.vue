<!--
 * @Author: shemin
 * @Date: 2024-08-16 14:54:28
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-19 17:34:20
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\components\NavBar.vue
-->
<template>
  <div class="nav-menu">
    <el-menu :default-active="activeMenu" mode="horizontal" @select="handleMenuClick">
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
  </div>
</template>

<script>
export default {
  name: "NavBar",
};
</script>

<style scoped>
.nav-menu {
  display: flex;
  align-items: center;
  width: 100%;
  justify-content: space-between;
}

.el-menu-item {
  padding: 0 15px;
}

@media (max-width: 768px) {
  .nav-menu {
    flex-direction: column;
  }

  .el-menu-item {
    padding: 10px 0;
    text-align: center;
  }
}
.el-dropdown-link {
  color: #000;
  font-size: 16px;
  font-weight: 500; /* 设置字体粗细 */
  letter-spacing: 2px;
}
</style>
