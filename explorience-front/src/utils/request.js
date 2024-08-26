import axios from 'axios'
import store from '../store/store.js';
const request = axios.create({
    baseURL: process.env.VUE_APP_BASE_URL
})
// 请求拦截器
request.interceptors.request.use(
    config => {
        // 在请求发送前做些什么，比如在请求头中添加 token
        const token = store.getters.getToken;
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        return config;
    },
    error => {
        // 处理请求错误
        console.error('Request Error:', error);
        return Promise.reject(error);
    }
);

// 响应拦截器
request.interceptors.response.use(
    response => {
        // 处理响应数据
        return response.data;
    },
    error => {
        // 处理响应错误
        console.error('Response Error:', error);
        return Promise.reject(error);
    }
);

export default request