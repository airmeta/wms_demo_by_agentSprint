package com.ruoyi.common.core.constant;

/**
 * Security header / source constants used by gateway, auth and Feign.
 */
public final class SecurityConstants {

    private SecurityConstants() {}

    /** Internal service call source header. */
    public static final String FROM_SOURCE = "X-From-Source";
    public static final String FROM_SOURCE_INNER = "inner";

    public static final String TOKEN = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String USER_KEY = "user_key";
    public static final String USER_ID = "user_id";
    public static final String USERNAME = "username";
    public static final String LOGIN_USER = "login_user";
    public static final String DEPT_ID = "dept_id";
    public static final String DEPT_NAME = "dept_name";
    public static final String ROLE_KEY = "role_key";
    public static final String PERMISSIONS = "permissions";
}
