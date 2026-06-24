package com.ruoyi.common.core.constant;

/**
 * General constants.
 */
public final class Constants {

    private Constants() {}

    /** UTF-8 encoding. */
    public static final String UTF_ENCODING = "UTF-8";

    /** Success status code for R<T>. */
    public static final int SUCCESS = 200;

    /** Failure status code for R<T>. */
    public static final int FAIL = 500;

    /** Login user key stored in the security context. */
    public static final String LOGIN_USER = "login_user";

    /** JWT token header. */
    public static final String TOKEN_HEADER = "Authorization";

    /** JWT token prefix. */
    public static final String TOKEN_PREFIX = "Bearer ";

    /** Captcha redis prefix. */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /** Login retry redis prefix. */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";

    /** Common yes/no. */
    public static final String YES = "Y";
    public static final String NO = "N";

    /** Common status. */
    public static final String NORMAL = "0";
    public static final String DISABLE = "1";

    /** Common yes/no numeric. */
    public static final String UNIQUE = "0";
    public static final String NOT_UNIQUE = "1";
}
