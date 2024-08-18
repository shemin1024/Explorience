<!--
 * @Author: shemin
 * @Date: 2024-08-16 14:30:20
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-18 11:21:44
 * @Description: file content
 * @FilePath: \explorience\explorience-frontend\src\App.vue
-->
<template>
  <div id="app">
    <Header />
    <ImageCarousel class="banner" />
  </div>
</template>

<script>
import Header from "./components/Header.vue";
import ImageCarousel from "./components/ImageCarousel.vue";

export default {
  name: "App",
  components: {
    Header,
    ImageCarousel,
  },
};
</script>

<style>
body {
  margin: 0;
}
.banner {
  position: relative;
  width: 100%;
  height: 300px; /* 根据需要设置高度 */
  z-index: 1; /* 确保 banner 在 header-navbar 下层 */
}
</style>
