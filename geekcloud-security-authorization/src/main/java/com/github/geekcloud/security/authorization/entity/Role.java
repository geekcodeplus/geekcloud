package com.github.geekcloud.security.authorization.entity;

import com.github.geekcloud.framework.boot.base.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Role
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: Role
 */
@Data
@EqualsAndHashCode(callSuper = false )
@NoArgsConstructor
public class Role extends BasePo {
    private String code;
    private String name;
    private String description;
}
