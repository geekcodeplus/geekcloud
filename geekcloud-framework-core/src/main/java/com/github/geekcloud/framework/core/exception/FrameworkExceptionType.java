package com.github.geekcloud.framework.core.exception;

import com.github.geekcloud.framework.core.response.ResultCode;

/**
 * @ClassName: FrameworkException
 * @Description: 框架错误类
 * @author: jeffrey
 * @date: 2020年04月08日
 */
public class FrameworkExceptionType extends BaseCheckedExceptionType {

    private static final long serialVersionUID = -4469471606774881921L;

    public FrameworkExceptionType(Integer code, String message) {
        super(code, message);
    }

    public FrameworkExceptionType(Integer code, String format, Object... args) {
        super(code, String.format(format, args));
        this.code = code;
        this.message = String.format(format, args);
    }

    public FrameworkExceptionType wrap(int code, String format, Object... args) {
        return new FrameworkExceptionType(code, format, args);
    }

    @Override
    public String toString() {
        return "BizException [message=" + message + ", code=" + code + "]";
    }

    public FrameworkExceptionType(String message) {
        super(message);
    }

    public FrameworkExceptionType(ResultCode resultCode) {
        super(resultCode);
    }

    public FrameworkExceptionType(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameworkExceptionType(Throwable cause) {
        super(cause);
    }

}
