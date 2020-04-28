package com.github.geekcloud.framework.validator.constraintvalidators;

import com.github.geekcloud.framework.core.base.validation.IValidatable;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.internal.constraintvalidators.hv.LengthValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName: LengthConstraintValidator
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 自定义一个验证length的校验器。自定义类需要实现IValidatable接口
 */
public class LengthConstraintValidator implements ConstraintValidator<Length, IValidatable> {

    private LengthValidator lengthValidator = new LengthValidator();

    @Override
    public void initialize(Length parameters) {
        lengthValidator.initialize(parameters);
    }

    @Override
    public boolean isValid(IValidatable value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.value() == null) {
            return true;
        }
        return lengthValidator.isValid(String.valueOf(value.value()), constraintValidatorContext);
    }
}
