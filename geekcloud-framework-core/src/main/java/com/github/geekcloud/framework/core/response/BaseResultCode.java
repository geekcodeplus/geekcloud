package com.github.geekcloud.framework.core.response;

/**
 * @ClassName: BaseResultCode
 * @author: jeffrey
 * @date: 2020年04月26日
 * @Description: BaseResultCode
 */
public interface BaseResultCode {

    /**
     * 异常编码
     *
     * @return
     */
    int getCode();

    /**
     * 异常消息
     *
     * @return
     */
    String getMessage();
}
