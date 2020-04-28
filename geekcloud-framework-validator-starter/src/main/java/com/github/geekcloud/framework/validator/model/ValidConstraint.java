package com.github.geekcloud.framework.validator.model;

import javax.validation.groups.Default;

/**
 * @ClassName: ValidConstraint
 * @author: jeffrey
 * @date: 2020年04月28日
 * @Description: 验证约束
 */
public class ValidConstraint {

    private Class<?> target;
    private Class<?>[] groups;

    public ValidConstraint(Class<?> target) {
        this.target = target;
        groups = new Class<?>[]{Default.class};
    }

    public ValidConstraint(Class<?> target, Class<?>[] groups) {
        this.target = target;
        this.groups = groups;
    }

    public Class<?> getTarget() {
        return target;
    }

    public Class<?>[] getGroups() {
        if (groups == null) {
            groups = new Class[0];
        }
        if (groups.length == 0) {
            groups = new Class[]{
                    Default.class
            };
        }
        return groups;
    }
}