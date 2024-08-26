<!--
 * @Author: shemin
 * @Date: 2024-08-19 09:04:06
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-26 15:07:19
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\components\ElCarousel.vue
-->
<template>
  <div class="block text-center">
    <el-carousel height="760px">
      <el-carousel-item v-for="(image, index) in images" :key="index">
        <img
          :src="require(`@/assets/${image}`)"
          alt="Carousel Image"
          class="carousel-image"
        />
        <div class="banner-text">{{ $t("slogan") }}</div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>
<script setup>
import { ref } from "vue";
const images = ref([
  "banner5.jpg",
  "banner1.jpg",
  "banner2.jpg",
  "banner4.jpg",
  "banner3.jpg",
]);
</script>
<style scoped>
.el-carousel__item img {
  color: #475669;
  margin: 0;
  width: 100%;
  height: 100%; /* 确保图片填满容器高度 */
  object-fit: cover; /* 确保图片覆盖容器而不失真 */
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.banner-text {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  font-size: 48px; /* 根据需要调整字体大小 */
  font-weight: bold;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6); /* 增加阴影以提高可读性 */
  text-align: center;
  padding: 0 20px; /* 根据需要调整内边距 */
  white-space: nowrap; /* 防止文本换行 */
}
</style>
