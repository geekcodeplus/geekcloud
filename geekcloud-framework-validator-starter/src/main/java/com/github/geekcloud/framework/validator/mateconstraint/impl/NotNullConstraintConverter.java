package com.github.geekcloud.framework.validator.mateconstraint.impl;

import com.github.geekcloud.framework.validator.mateconstraint.IConstraintConverter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: NotNullConstraintConverter
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 非空 转换器
 */
public class NotNullConstraintConverter extends BaseConstraintConverter implements IConstraintConverter {


    @Override
    protected String getType(Class<? extends Annotation> type) {
        return "notNull";
    }

    @Override
    protected List<Class<? extends Annotation>> getSupport() {
        return Arrays.asList(NotNull.class, NotEmpty.class, NotBlank.class);
    }

    @Override
    protected List<String> getMethods() {
        return Arrays.asList("message");
    }
}
