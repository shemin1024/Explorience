<!--
 * @Author: shemin
 * @Date: 2024-08-20 10:05:28
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-24 10:50:45
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\views\LoginPage.vue
-->
<template>
  <HeaderEl />
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
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="user.password"
            type="password"
            :placeholder="$t('password')"
            :prefix-icon="Lock"
            clearable
          >
            <template #append>
              <el-button @click="gotoForget">
                {{ $t("forgetPassword") }}
              </el-button>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="handleLogin" width="100%">{{ $t("login") }}</el-button>
        </el-form-item>
        <el-form-item>
          <el-link type="primary" @click="gotoRegister">{{ $t("signup") }}</el-link>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
  <AppFooter />
</template>
<script setup>
import HeaderEl from "../components/HeaderEl.vue";
import { User, Lock } from "@element-plus/icons-vue";
import { reactive, ref } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import { login } from "@/api/user.js";
import AppFooter from "@/components/AppFooter.vue";
import { ElMessage } from "element-plus";
const loginForm = ref(null);
const router = useRouter();
const store = useStore();
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
const gotoForget = () => {
  router.push({ name: "Forget" });
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
    const token = response.data.token;
    const userInfo = response.data.username;
    store.dispatch("saveToken", token);
    store.dispatch('saveUserInfo', userInfo);
    router.push({ name: "Home" });
    console.log(store.getters.getToken);
  } else {
    ElMessage.error(response.msg);
  }
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
