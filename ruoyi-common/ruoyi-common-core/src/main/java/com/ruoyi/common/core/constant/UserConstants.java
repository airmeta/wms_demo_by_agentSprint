package com.ruoyi.common.core.constant;

/**
 * User related constants.
 */
public final class UserConstants {

    private UserConstants() {}

    /** User status: normal. */
    public static final String NORMAL = "0";

    /** User status: disabled. */
    public static final String DISABLE = "1";

    /** Yes / No flags. */
    public static final String YES = "Y";
    public static final String NO = "N";

    /** Default password reset value. */
    public static final String DEFAULT_PASSWORD = "123456";

    /** User name length limits. */
    public static final int USERNAME_MIN_LENGTH = 2;
    public static final int USERNAME_MAX_LENGTH = 20;

    /** Password length limits. */
    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 20;

    /** Common identifier check. */
    public static final String COMMON_PATTERN = "^[A-Za-z0-9_\\-\\.\\u4e00-\\u9fa5]+$";
}
