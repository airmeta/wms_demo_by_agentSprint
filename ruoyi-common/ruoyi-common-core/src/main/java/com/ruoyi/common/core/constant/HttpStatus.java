package com.ruoyi.common.core.constant;

/**
 * HTTP status code constants.
 */
public interface HttpStatus {

    int SUCCESS = 200;

    int BAD_REQUEST = 400;
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;
    int BAD_METHOD = 405;
    int CONFLICT = 409;

    int ERROR = 500;
    int NOT_IMPLEMENTED = 501;
    int WARN = 601;
}
