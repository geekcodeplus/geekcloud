package com.github.geekcloud.framework.log.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author： jeffrey
 * @date： 2020/4/12
 * @description： 操作日志配置类
 * @modified By：
 * @version: 1.0.0
 */
@ConfigurationProperties(prefix = OptLogProperties.PREFIX)
@Data
@NoArgsConstructor
//@Component
public class OptLogProperties {
    public static final String PREFIX = "geekcloud.log";

    /**
     * 是否启用
     */
    private Boolean enabled = true;

    /**
     * 日志存储类型
     */
    private OptLogType type = OptLogType.DB;
}
