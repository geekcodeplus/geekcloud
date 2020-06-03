package com.github.geekcloud.system.admin.entity.param;

import com.github.geekcloud.framework.boot.base.param.BaseParam;
import com.github.geekcloud.system.admin.entity.po.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleQueryParam extends BaseParam<Role> {
    private String code;
    private String name;
}
