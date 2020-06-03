package com.github.geekcloud.system.admin.exception;

import com.github.geekcloud.framework.core.exception.BaseException;

/**
 * @ClassName: UserNotFoundException
 * @author: jeffrey
 * @date: 2020年05月29日
 * @Description: TODO
 */

public class UserNotFoundException extends BaseException {
    public UserNotFoundException() {
        super(OrganizationErrorType.USER_NOT_FOUND);
    }

    public UserNotFoundException(String message) {
        super(OrganizationErrorType.USER_NOT_FOUND, message);
    }
}
