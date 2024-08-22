package com.explorience.explorienceserver.controller;

import com.explorience.explorienceserver.entity.User;
import com.explorience.explorienceserver.enums.MsgCodeEnum;
import com.explorience.explorienceserver.pojo.ResponseData;
import com.explorience.explorienceserver.service.EmailService;
import com.explorience.explorienceserver.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private EmailService emailService;

    @ResponseBody
    @PostMapping("/register")
    public ResponseData<User> register(@RequestBody User user) {
        return ResponseData.ok(userService.createUser(user));
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseData<User> login(@RequestBody User user) {
        User user1 = userService.findUserByName(user.getUsername());
        if (user1 != null) {
            if (user1.getPassword().equals(user.getPassword())) {
                return ResponseData.ok(userService.findUserByName(user.getUsername()));
            } else {
                return ResponseData.error(MsgCodeEnum.PASSWORD_ERROR);
            }
        } else {
            return ResponseData.error(MsgCodeEnum.NOT_FOUND);
        }
    }
    @ResponseBody
    @PostMapping("/verify_code")
    public ResponseData<String> verifyCode(@RequestBody String email) {
        String code = String.format("%06d", new Random().nextInt(999999));

        // 发送验证码到指定邮箱
        emailService.sendVerificationCode(email, code);

        // 返回生成的验证码（可以存储到数据库或缓存中以便后续验证）
        return ResponseData.ok(code);
    }



}

