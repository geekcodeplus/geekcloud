package com.github.geekcloud.system.admin.entity.param;

import com.github.geekcloud.framework.boot.base.param.BaseParam;
import com.github.geekcloud.system.admin.entity.po.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceQueryParam extends BaseParam<Resource> {
    private String name;
    private String code;
    private String type;
    private String url;
    private String method;
}
