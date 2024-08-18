/*
 * @Author: shemin
 * @Date: 2024-08-16 14:30:20
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-18 20:54:56
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\main.js
 */
import { createApp } from 'vue'
import App from './App.vue'
import { createI18n } from 'vue-i18n';
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

// 导入语言文件
import en from './locales/en.json';
import zh from './locales/zh.json';

const i18n = createI18n({
    locale: 'en', // 设置默认语言
    fallbackLocale: 'en', // 回退语言
    messages: {
        en,
        zh
    }
});
const app = createApp(App);

app.use(i18n);
app.use(ElementPlus);
app.mount('#app');
