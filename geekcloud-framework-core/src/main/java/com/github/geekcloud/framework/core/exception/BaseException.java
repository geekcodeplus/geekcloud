package com.github.geekcloud.framework.core.exception;

import com.github.geekcloud.framework.core.base.enums.BaseEnum;
import com.github.geekcloud.framework.core.response.ResultCode;
import lombok.Getter;

/**
 * @ClassName: BaseException
 * @author: jeffrey
 * @date: 2020年06月02日
 * @Description: TODO
 */
@Getter
public class BaseException extends RuntimeException {
    /**
     * 异常对应的错误类型
     */
    private final BaseEnum exceptionType;

    /**
     * 默认是系统异常
     */
    public BaseException() {
        this.exceptionType = ResultCode.SYSTEM_EXCEPTION;
    }

    public BaseException(BaseEnum errorType) {
        this.exceptionType = errorType;
    }

    public BaseException(BaseEnum errorType, String message) {
        super(message);
        this.exceptionType = errorType;
    }

    public BaseException(BaseEnum errorType, String message, Throwable cause) {
        super(message, cause);
        this.exceptionType = errorType;
    }
}
