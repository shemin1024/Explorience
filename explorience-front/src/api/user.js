/*
 * @Author: shemin
 * @Date: 2024-08-21 11:30:49
 * @LastEditors: shemin
 * @LastEditTime: 2024-08-23 11:00:04
 * @Description: file content
 * @FilePath: \explorience\explorience-front\src\api\user.js
 */
import request from '@/utils/request'

export const login = (data) => {
    return request({
        method: 'post',
        url: '/api/v1/user/login',
        data
    })
}
export const register = (data) => {
    return request({
        method: 'post',
        url: '/api/v1/user/register',
        data
    })
}

export const updatePassword = (data) => {
    return request({
        method: 'post',
        url: '/api/v1/user/update_password',
        data
    })
}

export const getVerifyCode = (data) => {
    return request({
        method: 'get',
        url: '/api/v1/user/verify_code',
        params: { email: data }
    })
}