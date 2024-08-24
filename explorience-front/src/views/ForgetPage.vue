<template>
  <HeaderEl />
  <div class="forget-container">
    <el-card class="forget-card">
      <div class="forget-card-header">
        <span>{{ $t("forgetPassword") }}</span>
      </div>
      <el-form :model="user" ref="forgetForm" :rules="rules">
        <el-form-item prop="email">
          <el-input
            v-model="user.email"
            :placeholder="$t('email')"
            :prefix-icon="Message"
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
          ></el-input>
        </el-form-item>
        <el-form-item prop="verifyCode">
          <el-input
            v-model="user.verifyCode"
            :placeholder="$t('verifyCode')"
            :prefix-icon="CircleCheck"
          >
            <template #append>
              <el-button :disabled="countdown > 0" @click="getVerificationCode">
                <span v-if="countdown === 0">{{$t("getCode")}}</span>
                <span v-else>{{ countdown }}s</span>
              </el-button>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="handleUpdate">{{ $t("reset") }}</el-button>
          <el-button @click="gotoLogin">{{ $t("login") }}</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
  <AppFooter />
</template>
<script setup>
import HeaderEl from "../components/HeaderEl.vue";
import { Lock, Message, CircleCheck } from "@element-plus/icons-vue";
import { reactive, ref } from "vue";
import { useRouter } from "vue-router";
import AppFooter from "@/components/AppFooter.vue";
import { updatePassword, getVerifyCode } from "@/api/user";
import { ElMessage } from "element-plus";
const forgetForm = ref(null);
const router = useRouter();
const user = reactive({
  password: "",
  email: "",
  verifyCode: "",
});
const rules = ref({
  password: [
    { required: true, message: "请输入密码", trigger: "blur" },
    { min: 6, max: 20, message: "长度在 6 到 20 个字符", trigger: "blur" },
  ],
  email: [
    { required: true, message: "请输入邮箱地址", trigger: "blur" },
    { type: "email", message: "请输入正确的邮箱地址", trigger: "blur" },
  ],
  verifyCode: [{ required: true, message: "请输入验证码", trigger: "blur" }],
});

const handleUpdate = async () => {
  const valid = await forgetForm.value.validate();
  if (!valid) {
    return false;
  }
  const params = {
    password: user.password,
    email: user.email,
    verifyCode: user.verifyCode,
  };
  const response = await updatePassword(params);
  if (response.code === 200) {
    router.push({ name: "Login" });
  } else {
    ElMessage.error(response.msg);
  }
};
const countdown = ref(0);
let timer = null;

const getVerificationCode = async () => {
  if (countdown.value > 0) return;
  if (!user.email) {
    ElMessage.error("请输入邮箱地址");
    return;
  }
  const response = await getVerifyCode(user.email);
  if (response.code === 200) {
    ElMessage.success("验证码发送成功" + response.data.code);
  } else {
    ElMessage.error(response.msg);
  }
  // 发送获取验证码请求的逻辑
  console.log("Getting verification code...");

  // 设置倒计时
  countdown.value = 60; // 例如60秒
  timer = setInterval(() => {
    countdown.value--;
    if (countdown.value <= 0) {
      clearInterval(timer);
    }
  }, 1000);
};
const gotoLogin = () => {
  router.push({ name: "Login" });
};
</script>

<style scoped>
.forget-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f5f5;
}

.forget-card {
  width: 400px;
  padding: 20px;
}

.forget-card-header {
  font-size: 24px;
  text-align: center;
  margin-bottom: 20px;
}
</style>
