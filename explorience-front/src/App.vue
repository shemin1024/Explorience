<!--
 * @Author: shemin
 * @Date: 2024-08-16 14:30:20
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-19 17:25:49
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\App.vue
-->
<template>
  <div id="app">
    <HeaderEl />
    <ElCarousel />
    <AppFooter />
  </div>
</template>

<script>
import HeaderEl from "./components/HeaderEl.vue";
import ElCarousel from "./components/ElCarousel.vue";
import AppFooter from "./components/AppFooter.vue";

export default {
  name: "App",
  components: {
    HeaderEl,
    ElCarousel,
    AppFooter,
  },
};
</script>

<style>
body {
  font-family: "HarmonyOS Sans", sans-serif;
}
</style>
