package com.explorience.explorienceserver.controller;

import com.explorience.explorienceserver.entity.User;
import com.explorience.explorienceserver.service.EmailService;
import com.explorience.explorienceserver.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Random;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private EmailService emailService;

    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User user1 = userService.findUserByName(user.getName());
        if (user1 != null) {
            if (user1.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok(userService.findUserByName(user.getName()));
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @ResponseBody
    @PostMapping("/verify_code")
    public ResponseEntity<String> verifyCode(@RequestBody String email) {
        String code = String.format("%06d", new Random().nextInt(999999));

        // 发送验证码到指定邮箱
        emailService.sendVerificationCode(email, code);

        // 返回生成的验证码（可以存储到数据库或缓存中以便后续验证）
        return ResponseEntity.ok(code);
    }



}

