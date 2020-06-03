package com.github.geekcloud.security.authentication.entity.po;

import com.github.geekcloud.framework.boot.base.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Resource
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Data
@NoArgsConstructor
public class Resource extends BasePo {
    private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;
}
