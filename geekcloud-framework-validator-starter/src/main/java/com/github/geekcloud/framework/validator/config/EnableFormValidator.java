package com.github.geekcloud.framework.validator.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: EnableFormValidator
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 在启动类上添加该注解来启动表单验证功能
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ValidatorConfiguration.class)
public @interface EnableFormValidator {
}
