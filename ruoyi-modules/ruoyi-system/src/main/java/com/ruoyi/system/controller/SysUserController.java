package com.ruoyi.system.controller;

import com.ruoyi.common.core.constant.SecurityConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.page.PageDomainHelper;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * User info controller.
 */
@Tag(name = "SysUserController", description = "User information APIs")
@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService userService;

    /**
     * Get user info by user name. Inner call from auth service.
     */
    @Operation(summary = "Get user info by name")
    @GetMapping("/info/{username}")
    public R<LoginUser> getUserInfo(@PathVariable("username") String username) {
        SysUser user = userService.selectUserByUserName(username);
        if (user == null) {
            return R.fail("user not found: " + username);
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(user.getUserId());
        loginUser.setUsername(user.getUsername());
        return R.ok(loginUser);
    }

    /**
     * Register a new user. Inner call from auth service.
     */
    @Operation(summary = "Register a new user")
    @Log(title = "user", businessType = "INSERT")
    @PostMapping("/register")
    public R<Boolean> register(@RequestBody SysUser sysUser) {
        // Only allowed from inner call
        return R.ok(userService.registerUser(sysUser));
    }

    /**
     * List users (page).
     */
    @Operation(summary = "List users")
    @GetMapping("/list")
    public R<Map<String, Object>> list() {
        Map<String, Object> rsp = new HashMap<>();
        rsp.put("page", PageDomainHelper.build());
        rsp.put("hint", "configure database connection in bootstrap.yml to enable this endpoint");
        return R.ok(rsp);
    }
}
