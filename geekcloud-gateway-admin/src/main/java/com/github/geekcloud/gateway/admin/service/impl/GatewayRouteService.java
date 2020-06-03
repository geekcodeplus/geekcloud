package com.github.geekcloud.gateway.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.geekcloud.framework.cache.repository.CacheRepository;
import com.github.geekcloud.gateway.admin.config.BusConfig;
import com.github.geekcloud.gateway.admin.dao.GatewayRouteMapper;
import com.github.geekcloud.gateway.admin.entity.param.GatewayRouteQueryParam;
import com.github.geekcloud.gateway.admin.entity.po.GatewayRoute;
import com.github.geekcloud.gateway.admin.entity.vo.GatewayRouteVo;
import com.github.geekcloud.gateway.admin.events.EventSender;
import com.github.geekcloud.gateway.admin.service.IGatewayRouteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: GatewayRouteService
 * @author: jeffrey
 * @date: 2020年05月25日
 * @Description: TODO
 */

@Service
@Slf4j
public class GatewayRouteService extends ServiceImpl<GatewayRouteMapper, GatewayRoute> implements IGatewayRouteService {

    private static final String GATEWAY_ROUTES = "gateway_routes::";

//    @CreateCache(name = GATEWAY_ROUTES, cacheType = CacheType.REMOTE)
//    private Cache<String, RouteDefinition> gatewayRouteCache;

    @Resource
    private CacheRepository cacheRepository;

    @Autowired
    private EventSender eventSender;

    /**
     * 新增网关路由
     *
     * @param gatewayRoute
     * @return
     */
    @Override
    public boolean add(GatewayRoute gatewayRoute) {
        boolean isSuccess = this.save(gatewayRoute);
        // 转化为gateway需要的类型，缓存到redis, 并事件通知各网关应用
        RouteDefinition routeDefinition = gatewayRouteToRouteDefinition(gatewayRoute);
        //gatewayRouteCache.put(gatewayRoute.getRouteId(), routeDefinition);
        cacheRepository.set(GATEWAY_ROUTES + gatewayRoute.getRouteId(), routeDefinition);
        eventSender.send(BusConfig.ROUTING_KEY, routeDefinition);
        return isSuccess;
    }

    /**
     * 根据id删除网关路由
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(String id) {
        GatewayRoute gatewayRoute = this.getById(id);
        // 删除redis缓存, 并事件通知各网关应用
        //gatewayRouteCache.remove(gatewayRoute.getRouteId());
        cacheRepository.del(GATEWAY_ROUTES + gatewayRoute.getRouteId());
        eventSender.send(BusConfig.ROUTING_KEY, gatewayRouteToRouteDefinition(gatewayRoute));
        return this.removeById(id);
    }

    /**
     * 更新网关路由信息
     *
     * @param gatewayRoute
     * @return
     */
    @Override
    public boolean update(GatewayRoute gatewayRoute) {
        boolean isSuccess = this.updateById(gatewayRoute);
        // 转化为gateway需要的类型，缓存到redis, 并事件通知各网关应用
        RouteDefinition routeDefinition = gatewayRouteToRouteDefinition(gatewayRoute);
        //gatewayRouteCache.put(gatewayRoute.getRouteId(), routeDefinition);
        cacheRepository.set(GATEWAY_ROUTES + gatewayRoute.getRouteId(), routeDefinition);
        eventSender.send(BusConfig.ROUTING_KEY, routeDefinition);
        return isSuccess;
    }

    /**
     * 将数据库中json对象转换为网关需要的RouteDefinition对象
     *
     * @param gatewayRoute
     * @return RouteDefinition
     */
    private RouteDefinition gatewayRouteToRouteDefinition(GatewayRoute gatewayRoute) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(gatewayRoute.getRouteId());
        routeDefinition.setOrder(gatewayRoute.getOrders());
        routeDefinition.setUri(URI.create(gatewayRoute.getUri()));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            routeDefinition.setFilters(objectMapper.readValue(gatewayRoute.getFilters(), new TypeReference<List<FilterDefinition>>() {
            }));
            routeDefinition.setPredicates(objectMapper.readValue(gatewayRoute.getPredicates(), new TypeReference<List<PredicateDefinition>>() {
            }));
        } catch (IOException e) {
            log.error("网关路由对象转换失败", e);
        }
        return routeDefinition;
    }

    @Override
    public GatewayRoute get(String id) {
        return this.getById(id);
    }

    @Override
    public List<GatewayRouteVo> query(GatewayRouteQueryParam gatewayRouteQueryParam) {
        QueryWrapper<GatewayRoute> queryWrapper = gatewayRouteQueryParam.build();
        queryWrapper.eq(StringUtils.isNotBlank(gatewayRouteQueryParam.getUri()), "uri", gatewayRouteQueryParam.getUri());
        return this.list(queryWrapper).stream().map(GatewayRouteVo::new).collect(Collectors.toList());
    }

    @Override
    @PostConstruct
    public boolean overload() {
        List<GatewayRoute> gatewayRoutes = this.list(new QueryWrapper<>());
        gatewayRoutes.forEach(gatewayRoute ->
                //更新缓存
                //gatewayRouteCache.put(gatewayRoute.getRouteId(), gatewayRouteToRouteDefinition(gatewayRoute))
                cacheRepository.set(GATEWAY_ROUTES + gatewayRoute.getRouteId(), gatewayRouteToRouteDefinition(gatewayRoute))
        );
        log.info("全局初使化网关路由成功!");
        return true;
    }
}

