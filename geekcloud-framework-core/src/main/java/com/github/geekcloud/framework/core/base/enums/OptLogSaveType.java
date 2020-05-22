package com.github.geekcloud.framework.core.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author： jeffrey
 * @date： 2020/4/12
 * @description： 日志类型
 * @modified By：
 * @version: 1.0.0
 */
@Getter
@AllArgsConstructor
public enum OptLogSaveType implements BaseEnum {
    /**
     * 通过logger记录日志到本地
     */
    LOGGER(0, "本地"),

    /**
     * 记录到日志系统
     */
    ELK(1, "ELK"),

    /**
     * 记录日志到数据库
     */
    DB(2, "数据库"),
    ;

    private Integer code;
    private String desc;
}
