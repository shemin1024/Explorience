<!--
 * @Author: shemin
 * @Date: 2024-08-16 16:29:43
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-18 10:56:56
 * @Description: file content
 * @FilePath: \explorience\explorience-frontend\src\components\ImageCarousel.vue
-->
<template>
  <div class="carousel">
    <div
      class="carousel-wrapper"
      :style="{ transform: `translateX(-${currentIndex * 100}%)` }"
    >
      <div class="carousel-item" v-for="(image, index) in images" :key="index">
        <img
          :src="require(`@/assets/${image}`)"
          alt="Carousel Image"
          class="carousel-image"
        />
        <div class="banner-text">Explore the world, wounderful experiencies!</div>
        <!-- 添加标语 -->
      </div>
    </div>
    <button @click="prev" class="carousel-button prev">‹</button>
    <button @click="next" class="carousel-button next">›</button>
  </div>
</template>

<script>
export default {
  name: "ImageCarousel",
  data() {
    return {
      currentIndex: 0,
      intervalId: null, // 定义一个变量来存储定时器ID
      images: ["banner1.jpg", "banner2.jpg", "banner3.jpg"],
    };
  },
  methods: {
    next() {
      if (this.currentIndex < this.images.length - 1) {
        this.currentIndex += 1;
      } else {
        this.currentIndex = 0;
      }
    },
    startAutoSlide() {
      this.intervalId = setInterval(this.next(), 3000); // 每3秒调用一次next方法
    },
    mounted() {
      this.startAutoSlide(); // 调用startAutoSlide方法
    },
    beforeDestroy() {
      clearInterval(this.autoSlide); // 清理定时器
    },
    prev() {
      if (this.currentIndex > 0) {
        this.currentIndex -= 1;
      } else {
        this.currentIndex = this.images.length - 1;
      }
    },
  },
};
</script>

<style scoped>
.banner-text {
  position: absolute;
  top: 30%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  font-size: 24px; /* 根据需要调整字体大小 */
  font-weight: bold;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6); /* 增加阴影以提高可读性 */
  text-align: center;
  padding: 0 20px; /* 根据需要调整内边距 */
  white-space: nowrap; /* 防止文本换行 */
}
.carousel {
  position: relative;
  overflow: hidden;
  width: 100%;
  height: 600px; /* 根据需要设置 banner 高度 */
}

.carousel-wrapper {
  display: flex;
  transition: transform 0.5s ease-in-out;
}

.carousel-item {
  min-width: 100%;
  position: relative;
}

.carousel-image {
  width: 100%;
  height: 100%; /* 确保图片填满容器高度 */
  object-fit: cover; /* 确保图片覆盖容器而不失真 */
}

.carousel-button {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
  border: none;
  padding: 10px;
  cursor: pointer;
}

.prev {
  left: 10px;
}

.next {
  right: 10px;
}
</style>
