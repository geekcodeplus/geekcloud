package com.github.geekcloud.gateway.admin.service;

import com.github.geekcloud.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.github.geekcloud.gateway.admin.entity.po.GatewayRoute;
import com.github.geekcloud.gateway.admin.entity.vo.GatewayRouteVo;

import java.util.List;

/**
 * @ClassName: IGatewayRouteService
 * @author: jeffrey
 * @date: 2020年05月25日
 * @Description: TODO
 */
public interface IGatewayRouteService {
    /**
     * 获取网关路由
     *
     * @param id
     * @return
     */
    GatewayRoute get(String id);

    /**
     * 新增网关路由
     *
     * @param gatewayRoute
     * @return
     */
    boolean add(GatewayRoute gatewayRoute);

    /**
     * 查询网关路由
     *
     * @return
     */
    List<GatewayRouteVo> query(GatewayRouteQueryParam gatewayRouteQueryParam);

    /**
     * 更新网关路由信息
     *
     * @param gatewayRoute
     */
    boolean update(GatewayRoute gatewayRoute);

    /**
     * 根据id删除网关路由
     *
     * @param id
     */
    boolean delete(String id);

    /**
     * 重新加载网关路由配置到redis
     *
     * @return 成功返回true
     */
    boolean overload();
}
