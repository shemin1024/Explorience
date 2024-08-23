<!--
 * @Author: shemin
 * @Date: 2024-08-20 11:16:12
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-20 11:19:10
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\views\HomePage.vue
-->
<template>
  <HeaderEl />
  <ElCarousel />
  <AppFooter />
</template>
<script>
import HeaderEl from "../components/HeaderEl.vue";
import ElCarousel from "../components/ElCarousel.vue";
import AppFooter from "../components/AppFooter.vue";

export default {
  name: "HomePage",
  components: {
    HeaderEl,
    ElCarousel,
    AppFooter,
  },
};
</script>
