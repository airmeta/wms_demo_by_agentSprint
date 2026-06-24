package com.ruoyi.common.security.utils;

import com.ruoyi.common.core.constant.Constants;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.security.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Security utility methods.
 */
public final class SecurityUtils {

    private SecurityUtils() {}

    public static LoginUser getLoginUser() {
        return SecurityContextHolder.get();
    }

    public static String getUsername() {
        LoginUser user = getLoginUser();
        return user == null ? null : user.getUsername();
    }

    public static Long getUserId() {
        LoginUser user = getLoginUser();
        return user == null ? null : user.getUserId();
    }

    public static boolean isLogin() {
        return getLoginUser() != null;
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

    public static String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean matchesPassword(String raw, String encoded) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(raw, encoded);
    }

    public static String getToken() {
        LoginUser user = getLoginUser();
        return user == null ? null : user.getToken();
    }

    public static String getTokenKey(String uuid) {
        return Constants.LOGIN_USER + ":" + uuid;
    }
}
