package com.github.geekcloud.system.admin.exception;

import com.github.geekcloud.framework.core.base.enums.BaseEnum;
import lombok.Getter;

/**
 * @ClassName: OrganizationErrorType
 * @author: jeffrey
 * @date: 2020年05月29日
 * @Description: TODO
 */
@Getter
public enum OrganizationErrorType implements BaseEnum {

    USER_NOT_FOUND(030100, "用户未找到！"),
    ROLE_NOT_FOUND(030200, "角色未找到！");

    /**
     * 错误类型码
     */
    private final Integer code;
    /**
     * 错误类型描述信息
     */
    private final String message;

    OrganizationErrorType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
