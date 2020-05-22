package com.github.geekcloud.gateway.admin.entity.po;

import com.github.geekcloud.framework.boot.base.po.BasePo;
import lombok.*;

/**
 * @ClassName: GatewayRoute
 * @author: jeffrey
 * @date: 2020年05月22日
 * @Description: TODO
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayRoute extends BasePo {
    private String uri;
    private String routeId;
    private String predicates;
    private String filters;
    private String description;
    private Integer orders = 0;
    private String status = "Y";
}
