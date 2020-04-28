package com.github.geekcloud.framework.validator.constraintvalidators;

import com.github.geekcloud.framework.core.base.validation.IValidatable;
import org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForCharSequence;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotEmpty;

/**
 * @ClassName: NotEmptyConstraintValidator
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 自定义一个验证 NotEmpty 的校验器。自定义类需要实现IValidatable接口
 */
public class NotEmptyConstraintValidator implements ConstraintValidator<NotEmpty, IValidatable> {

    private NotEmptyValidatorForCharSequence notEmptyValidator = new NotEmptyValidatorForCharSequence();

    @Override
    public void initialize(NotEmpty parameters) {
        notEmptyValidator.initialize(parameters);
    }

    @Override
    public boolean isValid(IValidatable value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && value.value() != null && !"".equals(value.value());
    }
}
