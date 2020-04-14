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

import com.github.geekcloud.framework.core.response.ResultCode;

/**
 * @author： jeffrey
 * @date： 2020/3/31
 * @description： 验证码校验异常
 * @modified By：
 * @version: 1.0.0
 */
public class VerificationCodeException extends BaseException {

    private static final long serialVersionUID = 2225717164743365238L;

    public VerificationCodeException(String message) {
        super(message);
    }

    public VerificationCodeException(Integer errorCode, String message) {
        super(errorCode, message);
    }

    public VerificationCodeException(ResultCode resultCode) {
        super(resultCode);
    }
}
