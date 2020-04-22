package com.github.geekcloud.framework.boot.controller;


import com.github.geekcloud.framework.core.context.BaseContextHandler;
import com.github.geekcloud.framework.core.exception.BusinessException;
import com.github.geekcloud.framework.core.response.ResultCode;
import com.github.geekcloud.framework.core.response.ResultWrapper;

/**
 * @ClassName: BaseController
 * @author: jeffrey
 * @date: 2020年04月21日
 * @Description: TODO
 */
public interface BaseController<Entity> {

    Class<Entity> getEntityClass();

    SuperService<Entity> getBaseService();


    /**
     * 成功返回
     *
     * @param data 返回内容
     * @param <T>  返回类型
     * @return R
     */
    default <T> ResultWrapper<T> success(T data) {
        return ResultWrapper.success(data);
    }

    /**
     * 成功返回
     *
     * @return ResultWrapper.true
     */
    default ResultWrapper<Boolean> success() {
        return ResultWrapper.success();
    }

    /**
     * 失败返回
     *
     * @param msg 失败消息
     * @param <T> 返回类型
     * @return
     */
    default <T> ResultWrapper<T> fail(String msg) {
        return ResultWrapper.fail(msg);
    }

    /**
     * 失败返回
     *
     * @param msg  失败消息
     * @param args 动态参数
     * @param <T>  返回类型
     * @return
     */
    default <T> ResultWrapper<T> fail(String msg, Object... args) {
        return ResultWrapper.fail(msg, args);
    }

    /**
     * 失败返回
     *
     * @param code 失败编码
     * @param msg  失败消息
     * @param <T>  返回类型
     * @return
     */
    default <T> ResultWrapper<T> fail(int code, String msg) {
        return R.fail(code, msg);
    }

    /**
     * 失败返回
     *
     * @param exceptionCode 失败异常码
     * @param <T>
     * @return
     */
    default <T> ResultWrapper<T> fail(ResultCode exceptionCode) {
        return ResultWrapper.fail(exceptionCode);
    }

    /**
     * 失败返回
     *
     * @param exception 异常
     * @param <T>
     * @return
     */
    default <T> ResultWrapper<T> fail(BusinessException exception) {
        return R.fail(exception);
    }

    /**
     * 失败返回
     *
     * @param throwable 异常
     * @param <T>
     * @return
     */
    default <T> ResultWrapper<T> fail(Throwable throwable) {
        return R.fail(throwable);
    }

    /**
     * 参数校验失败返回
     *
     * @param msg 错误消息
     * @param <T>
     * @return
     */
    default <T> ResultWrapper<T> validFail(String msg) {
        return R.validFail(msg);
    }

    /**
     * 参数校验失败返回
     *
     * @param msg  错误消息
     * @param args 错误参数
     * @param <T>
     * @return
     */
    default <T> ResultWrapper<T> validFail(String msg, Object... args) {
        return R.validFail(msg, args);
    }

    /**
     * 参数校验失败返回
     *
     * @param exceptionCode 错误编码
     * @param <T>
     * @return
     */
    default <T> ResultWrapper<T> validFail(BaseExceptionCode exceptionCode) {
        return R.validFail(exceptionCode);
    }

    /**
     * 获取当前id
     *
     * @return userId
     */
    default Long getUserId() {
        return BaseContextHandler.getUserId();
    }

    /**
     * 当前请求租户
     *
     * @return 租户编码
     */
    default String getTenant() {
        return BaseContextHandler.getTenant();
    }

    /**
     * 登录人账号
     *
     * @return 账号
     */
    default String getAccount() {
        return BaseContextHandler.getAccount();
    }

    /**
     * 登录人姓名
     *
     * @return 姓名
     */
    default String getName() {
        return BaseContextHandler.getName();
    }

}

