package com.ruoyi.common.security.context;

import com.ruoyi.common.core.domain.model.LoginUser;

/**
 * Holder for the LoginUser in the current thread / request.
 */
public final class SecurityContextHolder {

    private static final ThreadLocal<LoginUser> THREAD_LOCAL = new ThreadLocal<>();

    private SecurityContextHolder() {}

    public static void set(LoginUser loginUser) {
        THREAD_LOCAL.set(loginUser);
    }

    public static LoginUser get() {
        return THREAD_LOCAL.get();
    }

    public static void clear() {
        THREAD_LOCAL.remove();
    }
}
