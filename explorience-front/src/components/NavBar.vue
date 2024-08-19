<!--
 * @Author: shemin
 * @Date: 2024-08-16 14:54:28
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-19 10:19:36
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\components\NavBar.vue
-->
<template>
  <nav class="navbar">
    <ul class="nav-links">
      <li>
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
      </li>
      <li>
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
      </li>
      <li>
        <el-dropdown>
          <span class="el-dropdown-link">{{ $t("service") }}</span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>{{ $t("visaGuide") }}</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </li>
      <li>
        <el-dropdown>
          <span class="el-dropdown-link">{{ $t("contact") }}</span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>{{ $t("contact") }}</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </li>
      <li>
        <el-dropdown>
          <span class="el-dropdown-link">{{ $t("about") }}</span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>{{ $t("about") }}</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "NavBar",
};
</script>

<style scoped>
.el-dropdown-link {
  color: #000;
  font-size: 16px;
  font-weight: 500; /* 设置字体粗细 */
  letter-spacing: 2px;
}
.navbar {
  background: transparent;
  display: flex;
  align-items: center;
  width: 100%;
}

.nav-links {
  list-style: none;
  display: flex;
  justify-content: space-between;
  padding: 0;
  width: 100%;
}

.nav-links li {
  margin: 0 15px;
}

.nav-links a {
  color: white;
  text-decoration: none;
  font-size: 16px; /* 设置字体大小 */
  font-weight: 600; /* 设置字体粗细 */
  letter-spacing: 5px; /* 设置字母间距 */
  text-transform: uppercase; /* 将文本转换为大写 */
  padding: 0px 30px;
}

.nav-links a:hover {
  color: black;
  text-decoration: underline;
}
</style>
