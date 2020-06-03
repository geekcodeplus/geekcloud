package com.github.geekcloud.gateway.web.service;

import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.Collection;

/**
 * @ClassName: IRouteService
 * @author: jeffrey
 * @date: 2020年05月26日
 * @Description: TODO
 */
public interface IRouteService {
    Collection<RouteDefinition> getRouteDefinitions();

    boolean save(RouteDefinition routeDefinition);

    boolean delete(String routeId);
}
