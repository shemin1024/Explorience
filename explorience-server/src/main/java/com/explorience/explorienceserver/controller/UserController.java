package com.explorience.explorienceserver.controller;

import com.explorience.explorienceserver.entity.User;
import com.explorience.explorienceserver.enums.MsgCodeEnum;
import com.explorience.explorienceserver.pojo.*;
import com.explorience.explorienceserver.service.EmailService;
import com.explorience.explorienceserver.service.UserService;
import com.explorience.explorienceserver.utils.MD5Utils;
import com.explorience.explorienceserver.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private EmailService emailService;
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${send.mail.enabled:false}")
    private Boolean enabled;

    @ResponseBody
    @PostMapping("/register")
    public ResponseData<UserVo> register(@Valid @RequestBody RegisterReq user) {
        if (userService.findUserByName(user.getEmail()) != null) {
            return ResponseData.error(MsgCodeEnum.EXIST);
        }
        // 验证验证码
        String codeInRedis = (String) redisUtil.get(getRedisKey(user.getEmail()));
        if (user.getVerifyCode().equalsIgnoreCase(codeInRedis)) {
            redisUtil.delete(getRedisKey(user.getEmail()));
        } else {
            return ResponseData.error(MsgCodeEnum.VERIFY_CODE_ERROR);
        }
        // 保存用户
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setUsername(user.getUsername().isEmpty() ? user.getEmail().split("@")[0] : user.getUsername());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        User user2 = userService.createUser(user1);
        return ResponseData.ok(new UserVo(user2.getId(), user2.getUsername(), user2.getEmail()));
    }

    @ResponseBody
    @PostMapping("/update_password")
    public ResponseData<UserVo> updatePassword(@Valid @RequestBody RegisterReq user) {
        User user1 = userService.findUserByEmail(user.getEmail());
        if (user1 == null) {
            return ResponseData.error(MsgCodeEnum.NOT_FOUND);
        }
        // 验证验证码
        String codeInRedis = (String) redisUtil.get(getRedisKey(user.getEmail()));
        if (user.getVerifyCode().equalsIgnoreCase(codeInRedis)) {
            redisUtil.delete(getRedisKey(user.getEmail()));
        } else {
            return ResponseData.error(MsgCodeEnum.VERIFY_CODE_ERROR);
        }
        // 保存用户
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.updateById(user1);
        return ResponseData.ok(new UserVo(user1.getId(), user1.getUsername(), user1.getEmail()));
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseData<UserVo> login(@Valid @RequestBody LoginRequest user) {
        User user1 = userService.findUserByName(user.getUsername());
        if (user1 != null) {
            if (passwordEncoder.matches(user.getPassword(), user1.getPassword())) {
                return ResponseData.ok(new UserVo(user1.getId(), user1.getUsername(), user1.getEmail()));
            } else {
                return ResponseData.error(MsgCodeEnum.PASSWORD_ERROR);
            }
        } else {
            return ResponseData.error(MsgCodeEnum.NOT_FOUND);
        }
    }

    @ResponseBody
    @GetMapping("/verify_code")
    public ResponseData<VerifyCodeRsp> verifyCode(@RequestParam("email") String req) {
        String code = String.format("%06d", new Random().nextInt(999999));
        redisUtil.set(getRedisKey(req), code);
        // 发送验证码到指定邮箱
        if (enabled) {
            emailService.sendVerificationCode(req, code);
        }

        // 返回生成的验证码（可以存储到数据库或缓存中以便后续验证）
        return ResponseData.ok(new VerifyCodeRsp(code));
    }

    @ResponseBody
    @DeleteMapping("/delete")
    public ResponseData<String> delete(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return ResponseData.ok("删除成功");
    }

    private String getRedisKey(String email) {
        return "verifyCode:" + email;
    }


}

