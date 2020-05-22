package com.github.geekcloud.framework.core.annotation;

import com.github.geekcloud.framework.core.base.enums.OptLogBizType;
import com.github.geekcloud.framework.core.base.enums.OptLogSaveType;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @ClassName: SysLog
 * @Description: 操作日志注解
 * @author: jeffrey
 * @date: 2020年04月08日
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {


    /**
     * 日志名称 & 模块名称
     *
     * @return
     */
    String name() default "";

    /**
     * 日志名称 & 模块名称
     *
     * @return
     */
    @AliasFor("name")
    String value() default "";

    /**
     * 是否启用 操作日志
     *
     * @return
     */
    boolean enabled() default true;

    /**
     * 记录执行参数
     *
     * @return
     */
    boolean request() default true;

    /**
     * 当 request = false时， 需要方法报错是否记录请求参数
     *
     * @return
     */
    boolean requestByError() default true;

    /**
     * 记录返回参数
     *
     * @return
     */
    boolean response() default true;

    /**
     * 日志类型
     * @return enum
     */
    OptLogSaveType savetype() default OptLogSaveType.LOGGER;

    /**
     * 日志类型
     *
     * @return
     */
    OptLogBizType biztype() default OptLogBizType.OTHER;

}
