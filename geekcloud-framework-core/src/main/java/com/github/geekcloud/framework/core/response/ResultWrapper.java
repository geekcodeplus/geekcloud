/*
 *  Copyright 2019-2029 geekboot
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.github.geekcloud.framework.core.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.geekcloud.framework.core.base.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： jeffrey
 * @date： 2018/7/18
 * @description： 返回前端统一模型
 * @modified By：
 * @version: 1.0.0
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class ResultWrapper<T> implements Serializable {

    private static final long serialVersionUID = -90018831L;

    /**
     * 响应码
     */
    private int code;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private long time = System.currentTimeMillis();;


    public ResultWrapper() {
    }

    public static ResultWrapper<Boolean> result(boolean flag) {
        if (flag) {
            return success();
        }
        return fail();
    }

    public static ResultWrapper<Boolean> result(BaseEnum resultCode) {
        return result(resultCode, null);
    }

    public static <T> ResultWrapper<T> result(BaseEnum resultCode, T data) {
        return result(resultCode, null, data);
    }

    public static <T> ResultWrapper<T> result(BaseEnum resultCode, String message, T data) {
        boolean success = false;
        if (resultCode.getCode().equals(ResultCode.SUCCESS.getCode())) {
            success = true;
        }
        String apiMessage = resultCode.getMessage();
        if (StringUtils.isNotBlank(apiMessage)) {
            message = apiMessage;
        }
        return (ResultWrapper<T>) ResultWrapper.builder()
                .code(resultCode.getCode())
                .message(message)
                .data(data)
                .success(success)
                .time(System.currentTimeMillis())
                .build();
    }

    public static ResultWrapper<Boolean> success() {
        return success(null);
    }

    public static <T> ResultWrapper<T> success(T data) {
        return result(ResultCode.SUCCESS, data);
    }

    public static <T> ResultWrapper<T> success(T data, String message) {
        return result(ResultCode.SUCCESS, message, data);
    }

    public static ResultWrapper<Map<String, Object>> okMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>(1);
        map.put(key, value);
        return success(map);
    }

    public static <T> ResultWrapper<T> fail(BaseEnum resultCode) {
        return result(resultCode, null);
    }

    public static <T> ResultWrapper<T> fail(String message) {
        return result(ResultCode.FAIL, message, null);

    }

    public static <T> ResultWrapper<T> fail(BaseEnum resultCode, T data) {
        if (ResultCode.SUCCESS == resultCode) {
            throw new RuntimeException("失败结果状态码不能为" + ResultCode.SUCCESS.getCode());
        }
        return result(resultCode, data);

    }

    public static ResultWrapper<String> fail(Integer errorCode, String message) {
        return new ResultWrapper<String>()
                .setSuccess(false)
                .setCode(errorCode)
                .setMessage(message);
    }

    public static ResultWrapper<Map<String, Object>> fail(String key, Object value) {
        Map<String, Object> map = new HashMap<>(1);
        map.put(key, value);
        return result(ResultCode.FAIL, map);
    }

    public static ResultWrapper<Boolean> fail() {
        return fail(ResultCode.FAIL);
    }

}
