package com.github.geekcloud.framework.validator.mateconstraint.impl;

import com.github.geekcloud.framework.validator.mateconstraint.IConstraintConverter;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: OtherConstraintConverter
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 其他 转换器
 */
public class OtherConstraintConverter extends BaseConstraintConverter implements IConstraintConverter {


    @Override
    protected String getType(Class<? extends Annotation> type) {
        return type.getSimpleName();
    }

    @Override
    protected List<Class<? extends Annotation>> getSupport() {
        return new ArrayList<>();
    }


    @Override
    protected List<String> getMethods() {
        return Arrays.asList("message");
    }
}
