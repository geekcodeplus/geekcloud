package com.github.geekcloud.framework.core.exception;

import com.github.geekcloud.framework.core.response.ResultCode;

/**
 * @ClassName: FrameworkException
 * @Description: 框架错误类
 * @author: jeffrey
 * @date: 2020年04月08日
 */
public class FrameworkException extends BaseException {

    private static final long serialVersionUID = -4469471606774881921L;

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(Integer errorCode, String message) {
        super(errorCode, message);
    }

    public FrameworkException(ResultCode resultCode) {
        super(resultCode);
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameworkException(Throwable cause) {
        super(cause);
    }

    public FrameworkException() {
        super();
    }
}
