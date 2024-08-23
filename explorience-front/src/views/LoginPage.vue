<!--
 * @Author: shemin
 * @Date: 2024-08-20 10:05:28
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-23 09:59:43
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\views\LoginPage.vue
-->
<!--
 * @Author: shemin
 * @Date: 2024-08-20 10:05:28
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-21 11:18:05
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\views\LoginPage.vue
-->
<template>
  <div class="login-container">
    <el-card class="login-card">
      <div class="login-card-header">
        <span>{{ $t("login") }}</span>
      </div>
      <el-form :model="user" ref="loginForm" :rules="rules">
        <el-form-item prop="username">
          <el-input
            v-model="user.username"
            :placeholder="$t('username')"
            :prefix-icon="User"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="user.password"
            type="password"
            :placeholder="$t('password')"
            :prefix-icon="Lock"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleLogin">{{ $t("login") }}</el-button>
          <el-button @click="handleReset">{{ $t("reset") }}</el-button>
          <el-button type="success" @click="gotoRegister">{{ $t("register") }}</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
  <AppFooter />
</template>
<script setup>
import { User, Lock } from "@element-plus/icons-vue";
import { reactive, ref } from "vue";
import { useRouter } from "vue-router";
import { login } from "@/api/user.js";
import AppFooter from "@/components/AppFooter.vue";
import { ElMessage } from "element-plus";
const loginForm = ref(null);
const router = useRouter();
const user = reactive({
  username: "",
  password: "",
});
const rules = ref({
  username: [{ required: true, message: "Please input your username", trigger: "blur" }],
  password: [{ required: true, message: "Please input your password", trigger: "blur" }],
});
const gotoRegister = () => {
  router.push({ name: "Register" });
};
const handleLogin = async () => {
  const valid = await loginForm.value?.validate();
  if (!valid) {
    return false;
  }
  const params = {
    username: user.username,
    password: user.password,
  };
  const response = await login(params);
  if (response.code === 200) {
    router.push({ name: "Home" });
  } else {
    ElMessage.error(response.msg);
  }
};
const handleReset = () => {
  loginForm.value.resetFields();
};
</script>
<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f5f5;
}

.login-card {
  width: 400px;
  padding: 20px;
}

.login-card-header {
  font-size: 24px;
  text-align: center;
  margin-bottom: 20px;
}
</style>
