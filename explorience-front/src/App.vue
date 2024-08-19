<!--
 * @Author: shemin
 * @Date: 2024-08-16 14:30:20
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-19 10:31:38
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\App.vue
-->
<template>
  <div id="app">
    <el-container>
      <el-header><Header /></el-header>
      <ElCarousel />
      <AppFooter />
    </el-container>
  </div>
</template>

<script>
import Header from "./components/Header.vue";
import ElCarousel from "./components/ElCarousel.vue";
import AppFooter from "./components/AppFooter.vue";

export default {
  name: "App",
  components: {
    Header,
    ElCarousel,
    AppFooter,
  },
};
</script>

<style>
body {
  margin: 0;
  font-family: "HarmonyOS Sans", sans-serif;
}
</style>
