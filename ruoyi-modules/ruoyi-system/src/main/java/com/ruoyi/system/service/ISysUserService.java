package com.ruoyi.system.service;

import com.ruoyi.system.api.domain.SysUser;

public interface ISysUserService {
    SysUser selectUserByUserName(String username);
    boolean registerUser(SysUser user);
}
