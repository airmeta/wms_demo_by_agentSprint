package com.ruoyi.system.service.impl;

import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements ISysUserService {

    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Override
    public SysUser selectUserByUserName(String username) {
        log.info("select user by username={}, the database is not configured in the demo backend", username);
        return null;
    }

    @Override
    public boolean registerUser(SysUser user) {
        log.info("register user {}, the database is not configured in the demo backend", user);
        return false;
    }
}
