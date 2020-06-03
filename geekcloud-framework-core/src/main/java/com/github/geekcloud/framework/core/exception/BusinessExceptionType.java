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

package com.github.geekcloud.framework.core.exception;

import com.github.geekcloud.framework.core.base.enums.BaseEnum;
import com.github.geekcloud.framework.core.response.ResultCode;

/**
 * @author： jeffrey
 * @date： 2020/3/31
 * @description： 业务异常
 * @modified By：
 * @version: 1.0.0
 */
public class BusinessExceptionType extends BaseUncheckedExceptionType {
    private static final long serialVersionUID = 7102759392488802059L;

    public BusinessExceptionType(String message) {
        super(-1, message);
    }

    public BusinessExceptionType(int code, String message) {
        super(code, message);
    }

    public BusinessExceptionType(int code, String message, Object... args) {
        super(code, message, args);
    }

    /**
     * 实例化异常
     *
     * @param code    自定义异常编码
     * @param message 自定义异常消息
     * @param args    已定义异常参数
     * @return
     */
    public static BusinessExceptionType wrap(int code, String message, Object... args) {
        return new BusinessExceptionType(code, message, args);
    }

    public static BusinessExceptionType wrap(String message, Object... args) {
        return new BusinessExceptionType(-1, message, args);
    }

    public static BusinessExceptionType validFail(String message, Object... args) {
        return new BusinessExceptionType(-9, message, args);
    }

    public static BusinessExceptionType wrap(BaseEnum ex) {
        return new BusinessExceptionType(ex.getCode(), ex.getMessage());
    }

    @Override
    public String toString() {
        return "BusinessException [message=" + message + ", code=" + code + "]";
    }

    public BusinessExceptionType(ResultCode resultCode) {
        super(resultCode);
    }

}
