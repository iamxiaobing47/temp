package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class User {
    @Schema(description = "用户ID")
    private Long id;
    
    @Schema(description = "用户名")
    private String username;
    
    @Schema(description = "姓名")
    private String name;
    
    @Schema(description = "年龄")
    private Integer age;
    
    @Schema(description = "邮箱")
    private String email;
    
    @Schema(description = "部门(管理员用户特有)")
    private String department;
    
    @Schema(description = "权限列表(管理员用户特有)")
    private String[] permissions;
}    