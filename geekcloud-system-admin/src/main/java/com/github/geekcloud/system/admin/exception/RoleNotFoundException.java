package com.github.geekcloud.system.admin.exception;

import com.github.geekcloud.framework.core.exception.BaseException;

/**
 * @ClassName: RoleNotFoundException
 * @author: jeffrey
 * @date: 2020年05月29日
 * @Description: TODO
 */
public class RoleNotFoundException extends BaseException {
    public RoleNotFoundException() {
        super(OrganizationErrorType.ROLE_NOT_FOUND);
    }

    public RoleNotFoundException(String message) {
        super(OrganizationErrorType.ROLE_NOT_FOUND, message);
    }
}
