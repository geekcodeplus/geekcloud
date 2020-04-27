package com.github.geekcloud.framework.core.exception;

import com.github.geekcloud.framework.core.response.ResultCode;

/**
 * @ClassName: FrameworkException
 * @Description: 框架错误类
 * @author: jeffrey
 * @date: 2020年04月08日
 */
public class FrameworkException extends BaseCheckedException {

    private static final long serialVersionUID = -4469471606774881921L;

    public FrameworkException(Integer code, String message) {
        super(code, message);
    }

    public FrameworkException(Integer code, String format, Object... args) {
        super(code, String.format(format, args));
        this.code = code;
        this.message = String.format(format, args);
    }

    public FrameworkException wrap(int code, String format, Object... args) {
        return new FrameworkException(code, format, args);
    }

    @Override
    public String toString() {
        return "BizException [message=" + message + ", code=" + code + "]";
    }

    public FrameworkException(String message) {
        super(message);
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

}
