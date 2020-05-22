package com.github.geekcloud.framework.core.exception;

import com.github.geekcloud.framework.core.response.ResultCode;


/**
 * @ClassName: BaseUncheckedException
 * @author: jeffrey
 * @date: 2020年04月26日
 * @Description: 非运行期异常基类，所有自定义非运行时异常继承该类
 */
public class BaseUncheckedException extends RuntimeException implements BaseException {
    private static final long serialVersionUID = -91874138L;

    protected Integer code;
    protected String message;

//    public BaseException() {
//        super();
//    }

//    public BaseUncheckedException(String message) {
//        super(message);
//        this.message = message;
//    }

    public BaseUncheckedException(Integer errorCode, String message) {
        super(message);
        this.code = errorCode;
        this.message = message;
    }

    public BaseUncheckedException(int code, String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
        this.message = String.format(format, args);
    }

    public BaseUncheckedException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BaseUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseUncheckedException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

}
