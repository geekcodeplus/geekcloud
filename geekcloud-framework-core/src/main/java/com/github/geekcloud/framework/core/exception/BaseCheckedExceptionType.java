package com.github.geekcloud.framework.core.exception;

import com.github.geekcloud.framework.core.base.enums.BaseEnum;
import com.github.geekcloud.framework.core.response.ResultCode;

/**
 * @ClassName: BaseCheckedException
 * @author: jeffrey
 * @date: 2020年04月26日
 * @Description: 运行期异常基类
 */
public class BaseCheckedExceptionType extends Exception implements BaseEnum {

    private static final long serialVersionUID = 2706069899924648586L;

    /**
     * 异常信息
     */
    protected String message;

    /**
     * 具体异常码
     */
    protected Integer code;

    public BaseCheckedExceptionType(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseCheckedExceptionType(String message) {
        super(message);
    }

    public BaseCheckedExceptionType(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseCheckedExceptionType(Throwable cause) {
        super(cause);
    }

    public BaseCheckedExceptionType(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BaseCheckedExceptionType(Integer code, String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
        this.message = String.format(format, args);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}