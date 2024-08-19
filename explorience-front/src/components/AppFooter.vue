<!--
 * @Author: shemin
 * @Date: 2024-08-19 10:28:01
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-19 10:28:34
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\components\AppFooter.vue
-->
<template>
  <el-footer class="footer">
    <div class="footer-content">
      <span>© 2024 Explorience. All rights reserved.</span>
      <el-divider direction="vertical"></el-divider>
      <span>Privacy Policy</span>
      <el-divider direction="vertical"></el-divider>
      <span>Terms of Service</span>
    </div>
  </el-footer>
</template>

<script>
export default {
  name: "AppFooter",
};
</script>

<style scoped>
.footer {
  background-color: #f2f2f2;
  padding: 20px;
  text-align: center;
}

.footer-content {
  display: flex;
  justify-content: center;
  align-items: center;
  color: #666;
}

.el-divider {
  margin: 0 15px;
}
</style>
