package com.github.geekcloud.framework.validator.mateconstraint;

import com.github.geekcloud.framework.validator.model.ConstraintInfo;

import java.lang.annotation.Annotation;

/**
 * @ClassName: IConstraintConverter
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 约束转换器
 */
public interface IConstraintConverter {

    /**
     * 支持的类型
     *
     * @param clazz
     * @return
     */
    boolean support(Class<? extends Annotation> clazz);

    /**
     * 转换
     *
     * @param ano
     * @return
     * @throws Exception
     */
    ConstraintInfo converter(Annotation ano) throws Exception;
}
