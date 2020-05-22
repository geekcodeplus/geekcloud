package com.github.geekcloud.framework.boot.web.handler;

import cn.hutool.core.util.StrUtil;
import com.github.geekcloud.framework.core.exception.BaseException;
import com.github.geekcloud.framework.core.exception.BusinessException;
import com.github.geekcloud.framework.core.response.ResultCode;
import com.github.geekcloud.framework.core.response.ResultWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: DefaultGlobalExceptionHandler
 * @author: jeffrey
 * @date: 2020年04月26日
 * @Description: TODO
 */
@Slf4j
public abstract class DefaultGlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResultWrapper<String> businessException(BaseException ex, HttpServletRequest request) {
        log.error("businessException:", ex);
        return ResultWrapper.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultWrapper httpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        log.warn("HttpMessageNotReadableException:", ex);
        String message = ex.getMessage();
        if (StrUtil.containsAny(message, "Could not read document:")) {
            String msg = String.format("无法正确的解析json类型的参数：%s", StrUtil.subBetween(message, "Could not read document:", " at "));
            return ResultWrapper.fail(ResultCode.PARAMETER_PARSE_EXCEPTION.getCode(), msg);
        }
        return ResultWrapper.fail(ResultCode.PARAMETER_PARSE_EXCEPTION.getCode(), ResultCode.PARAMETER_PARSE_EXCEPTION.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public ResultWrapper bindException(BindException ex, HttpServletRequest request) {
        log.warn("BindException:", ex);
        try {
            String msgs = ex.getBindingResult().getFieldError().getDefaultMessage();
            if (StrUtil.isNotEmpty(msgs)) {
                return ResultWrapper.fail(ResultCode.PARAMETER_PARSE_EXCEPTION.getCode(), msgs);
            }
        } catch (Exception ee) {
        }
        StringBuilder msg = new StringBuilder();
        List<FieldError> fieldErrors = ex.getFieldErrors();
        fieldErrors.forEach((oe) ->
                msg.append("参数:[").append(oe.getObjectName())
                        .append(".").append(oe.getField())
                        .append("]的传入值:[").append(oe.getRejectedValue()).append("]与预期的字段类型不匹配.")
        );
        return ResultWrapper.fail(ResultCode.PARAMETER_PARSE_EXCEPTION.getCode(), msg.toString());
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultWrapper methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        log.warn("MethodArgumentTypeMismatchException:", ex);
        MethodArgumentTypeMismatchException eee = (MethodArgumentTypeMismatchException) ex;
        StringBuilder msg = new StringBuilder("参数：[").append(eee.getName())
                .append("]的传入值：[").append(eee.getValue())
                .append("]与预期的字段类型：[").append(eee.getRequiredType().getName()).append("]不匹配");
        return ResultWrapper.fail(ResultCode.PARAMETER_PARSE_EXCEPTION.getCode(), msg.toString());
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResultWrapper illegalStateException(IllegalStateException ex, HttpServletRequest request) {
        log.warn("IllegalStateException:", ex);
        return ResultWrapper.fail(ResultCode.PARAMETER_EXCEPTION.getCode(), ResultCode.PARAMETER_EXCEPTION.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultWrapper missingServletRequestParameterException(MissingServletRequestParameterException ex, HttpServletRequest request) {
        log.warn("MissingServletRequestParameterException:", ex);
        StringBuilder msg = new StringBuilder();
        msg.append("缺少必须的[").append(ex.getParameterType()).append("]类型的参数[").append(ex.getParameterName()).append("]");
        return ResultWrapper.fail(ResultCode.PARAMETER_EXCEPTION.getCode(), msg.toString());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResultWrapper nullPointerException(NullPointerException ex, HttpServletRequest request) {
        log.warn("NullPointerException:", ex);
        return ResultWrapper.fail(ResultCode.NULL_POINT_EX.getCode(), ResultCode.NULL_POINT_EX.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResultWrapper illegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        log.warn("IllegalArgumentException:", ex);
        return ResultWrapper.fail(ResultCode.PARAMETER_EXCEPTION.getCode(), ResultCode.PARAMETER_EXCEPTION.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResultWrapper httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex, HttpServletRequest request) {
        log.warn("HttpMediaTypeNotSupportedException:", ex);
        MediaType contentType = ex.getContentType();
        if (contentType != null) {
            StringBuilder msg = new StringBuilder();
            msg.append("请求类型(Content-Type)[").append(contentType.toString()).append("] 与实际接口的请求类型不匹配");
            return ResultWrapper.fail(ResultCode.MEDIA_TYPE_EX.getCode(), msg.toString());
        }
        return ResultWrapper.fail(ResultCode.MEDIA_TYPE_EX.getCode(), "无效的Content-Type类型");
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResultWrapper missingServletRequestPartException(MissingServletRequestPartException ex, HttpServletRequest request) {
        log.warn("MissingServletRequestPartException:", ex);
        return ResultWrapper.fail(ResultCode.PARAMETER_EXCEPTION.getCode(), ResultCode.PARAMETER_EXCEPTION.getMessage());
    }

    @ExceptionHandler(ServletException.class)
    public ResultWrapper servletException(ServletException ex, HttpServletRequest request) {
        log.warn("ServletException:", ex);
        String msg = "UT010016: Not a multi part request";
        if (msg.equalsIgnoreCase(ex.getMessage())) {
            return ResultWrapper.fail(ResultCode.PARAMETER_EXCEPTION.getCode(), ResultCode.PARAMETER_EXCEPTION.getMessage());
        }
        return ResultWrapper.fail(ResultCode.SYSTEM_BUSY.getCode(), ex.getMessage());
    }

    @ExceptionHandler(MultipartException.class)
    public ResultWrapper multipartException(MultipartException ex, HttpServletRequest request) {
        log.warn("MultipartException:", ex);
        return ResultWrapper.fail(ResultCode.PARAMETER_EXCEPTION.getCode(), ResultCode.PARAMETER_EXCEPTION.getMessage());
    }

    /**
     * spring 封装的参数验证异常， 在conttoller中没有写result参数时，会进入
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        log.warn("MethodArgumentNotValidException:", ex);
        return ResultWrapper.fail(ResultCode.PARAMETER_EXCEPTION.getCode(), ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 其他异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultWrapper<String> otherExceptionHandler(Exception ex, HttpServletRequest request) {
        log.warn("Exception:", ex);
        if (ex.getCause() instanceof BusinessException) {
            return this.businessException((BusinessException) ex.getCause(), request);
        }
        return ResultWrapper.fail(ResultCode.SYSTEM_BUSY.getCode(), ResultCode.SYSTEM_BUSY.getMessage());
    }



    /**
     * 返回状态码: 5111
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResultWrapper<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        log.warn("HttpRequestMethodNotSupportedException:", ex);
        return ResultWrapper.fail(ResultCode.MEDIA_TYPE_EX.getCode(), ResultCode.MEDIA_TYPE_EX.getMessage());
    }

    /**
     * jsr 规范中的验证异常
     *
     * @param ex
     * @return

     @ExceptionHandler(ConstraintViolationException.class)
     public ResultWrapper<String> constraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
     log.warn("ConstraintViolationException:", ex);
     Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
     String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
     return ResultWrapper.fail(ResultCode.PARAMETER_EXCEPTION.getCode(), message);
     } */

    /**
     *
    @ExceptionHandler(PersistenceException.class)
    public ResultWrapper<String> persistenceException(PersistenceException ex, HttpServletRequest request) {
        log.warn("PersistenceException:", ex);
        if (ex.getCause() instanceof BusinessException) {
            BusinessException cause = (BusinessException) ex.getCause();
            return ResultWrapper.fail(cause.getCode(), cause.getMessage());
        }
        return ResultWrapper.fail(ResultCode.SQL_EX.getCode(), ResultCode.SQL_EX.getMessage());
    }

    @ExceptionHandler(MyBatisSystemException.class)
    public ResultWrapper<String> myBatisSystemException(MyBatisSystemException ex, HttpServletRequest request) {
        log.warn("PersistenceException:", ex);
        if (ex.getCause() instanceof PersistenceException) {
            return this.persistenceException((PersistenceException) ex.getCause(), request);
        }
        return ResultWrapper.fail(ResultCode.SQL_EX.getCode(), ResultCode.SQL_EX.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    public ResultWrapper sqlException(SQLException ex, HttpServletRequest request) {
        log.warn("SQLException:", ex);
        return ResultWrapper.fail(ResultCode.SQL_EX.getCode(), ResultCode.SQL_EX.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResultWrapper dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {
        log.warn("DataIntegrityViolationException:", ex);
        return ResultWrapper.fail(ResultCode.SQL_EX.getCode(), ResultCode.SQL_EX.getMessage());
    }
     */
}
