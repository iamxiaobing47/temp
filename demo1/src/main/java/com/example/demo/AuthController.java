package com.example.demo;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "认证接口")
public class AuthController {

    // 模拟用户数据库
    private static final Map<String, User> users = new HashMap<>();

    static {
        // 初始化测试用户
        User admin = new User();
        admin.setId(1L);
        admin.setUsername("admin");
        admin.setName("管理员");
        admin.setAge(35);
        admin.setEmail("admin@example.com");
        admin.setDepartment("技术部");
        admin.setPermissions(new String[]{"user:read", "user:write", "system:manage"});
        users.put("admin", admin);

        User normalUser = new User();
        normalUser.setId(2L);
        normalUser.setUsername("user");
        normalUser.setName("普通用户");
        normalUser.setAge(28);
        normalUser.setEmail("user@example.com");
        users.put("user", normalUser);
    }

    @Operation(summary = "用户登录")
    @PostMapping("/api/login")
    public LoginResponse login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // 简单验证：用户名存在且密码为123456
        if (users.containsKey(username) && "123456".equals(password)) {
            User user = users.get(username);
            List<User> userInfoList = new ArrayList<>();
            
            // 根据用户类型返回不同的用户列表
            if ("admin".equals(username)) {
                userInfoList.add(user);
                // 添加其他管理员用户
                User anotherAdmin = new User();
                anotherAdmin.setId(3L);
                anotherAdmin.setUsername("admin2");
                anotherAdmin.setName("另一个管理员");
                anotherAdmin.setAge(40);
                anotherAdmin.setEmail("admin2@example.com");
                anotherAdmin.setDepartment("人事部");
                anotherAdmin.setPermissions(new String[]{"user:read", "user:write"});
                userInfoList.add(anotherAdmin);
            } else {
                userInfoList.add(user);
                // 添加其他普通用户
                User anotherUser = new User();
                anotherUser.setId(4L);
                anotherUser.setUsername("user2");
                anotherUser.setName("另一个普通用户");
                anotherUser.setAge(30);
                anotherUser.setEmail("user2@example.com");
                userInfoList.add(anotherUser);
            }

            return new LoginResponse(
                "admin".equals(username) ? "admin" : "normal",
                userInfoList
            );
        }

        throw new IllegalArgumentException("用户名或密码错误");
    }

    @Operation(summary = "选择管理员用户")
    @PostMapping("/api/selectAdminUser")
    public Map<String, Object> selectAdminUser(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "管理员用户选择成功");
        result.put("data", user);
        return result;
    }

    @Operation(summary = "选择普通用户")
    @PostMapping("/api/selectNormalUser")
    public Map<String, Object> selectNormalUser(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "普通用户选择成功");
        result.put("data", user);
        return result;
    }
}    