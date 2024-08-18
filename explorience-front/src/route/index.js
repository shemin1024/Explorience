/*
 * @Author: shemin
 * @Date: 2024-08-16 16:01:34
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-16 16:05:59
 * @Description: file content
 * @FilePath: \explorience\explorience-frontend\src\route\index.js
 */
import Vue from "vue";
import VueRouter from "vue-router";
import Services from "../views/Services.vue";
import TargetSite from "../views/TargetSite.vue";
import Contact from "../views/Contact.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: "/targetSite",
        name: "targetSite",
        component: TargetSite,
    },
    {
        path: "/services",
        name: "Services",
        component: Services,
    },
    {
        path: "/contact",
        name: "Contact",
        component: Contact,
    },
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

export default router;
