/*
 * @Author: shemin
 * @Date: 2024-08-16 16:01:34
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-23 09:12:41
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\route\index.js
 */
import HomePage from "@/views/HomePage.vue";
import LoginPage from "../views/LoginPage.vue";
import RegisterPage from "../views/RegisterPage.vue";
import ForgetPage from "../views/ForgetPage.vue";
import { createWebHistory, createRouter } from "vue-router";

const routes = [
    {
        path: "/",
        name: "Home",
        component: HomePage,
    },
    {
        path: "/login",
        name: "Login",
        component: LoginPage,
    },
    {
        path: "/register",
        name: "Register",
        component: RegisterPage,
    },
    {
        path: "/forget",
        name: "Forget",
        component: ForgetPage,
    },
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});

export default router;
