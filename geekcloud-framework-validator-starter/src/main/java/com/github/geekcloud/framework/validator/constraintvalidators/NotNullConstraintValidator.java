package com.github.geekcloud.framework.validator.constraintvalidators;

import com.github.geekcloud.framework.core.base.validation.IValidatable;
import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: NotNullConstraintValidator
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 自定义一个验证 NotNull 的校验器。自定义类需要实现IValidatable接口
 */
public class NotNullConstraintValidator implements ConstraintValidator<NotNull, IValidatable> {

    private NotNullValidator notNullValidator = new NotNullValidator();

    @Override
    public void initialize(NotNull parameters) {
        notNullValidator.initialize(parameters);
    }

    @Override
    public boolean isValid(IValidatable value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && value.value() != null;
    }
}
