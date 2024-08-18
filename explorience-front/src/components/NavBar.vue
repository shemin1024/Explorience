<!--
 * @Author: shemin
 * @Date: 2024-08-16 14:54:28
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-18 12:57:08
 * @Description: file content
 * @FilePath: \explorience\explorience-frontend\src\components\NavBar.vue
-->
<template>
  <nav class="navbar">
    <ul class="nav-links">
      <li>
        <router-link to="/targetSite">{{ $t("popDest") }}</router-link>
      </li>
      <li>
        <router-link to="/targetSite">{{ $t("allDest") }}</router-link>
      </li>
      <li>
        <router-link to="/services">{{ $t("service") }}</router-link>
      </li>
      <li>
        <router-link to="/contact">{{ $t("contact") }}</router-link>
      </li>
      <li>
        <router-link to="/about">{{ $t("about") }}</router-link>
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
  font-family: "Microsoft Yahei", Helvetica, sans-serif !important;
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
