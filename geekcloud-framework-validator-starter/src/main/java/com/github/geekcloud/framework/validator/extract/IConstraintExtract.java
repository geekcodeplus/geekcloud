package com.github.geekcloud.framework.validator.extract;

import com.github.geekcloud.framework.validator.model.FieldValidatorDesc;
import com.github.geekcloud.framework.validator.model.ValidConstraint;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName: IConstraintExtract
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 提取指定表单验证规则
 */
public interface IConstraintExtract {

    /**
     * 提取指定表单验证规则
     *
     * @param constraints
     * @return
     * @throws Exception
     */
    Collection<FieldValidatorDesc> extract(List<ValidConstraint> constraints) throws Exception;
}
