package com.github.geekcloud.system.admin.entity.param;

import com.github.geekcloud.framework.boot.base.param.BaseParam;
import com.github.geekcloud.system.admin.entity.po.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryParam extends BaseParam<User> {
    private String name;
    private String mobile;
    private String username;
}
