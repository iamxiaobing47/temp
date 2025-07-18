package com.example.demo.sample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户管理控制器")
@RestController
public class SampleController {

    @Operation(summary = "获取用户信息")
    @GetMapping("/sampleUser")
    public SampleUser getUser() {
        SampleUser user = new SampleUser();
        user.setName("John");
        return user;
    }
}
