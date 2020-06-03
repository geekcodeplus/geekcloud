package com.github.geekcloud.gateway.web.events;

import com.github.geekcloud.gateway.web.service.IRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BusReceiver
 * @author: jeffrey
 * @date: 2020年05月26日
 * @Description: TODO
 */
@Component
@Slf4j
public class BusReceiver {

    @Autowired
    private IRouteService routeService;

    public void handleMessage(RouteDefinition routeDefinition) {
        log.info("Received Message:<{}>", routeDefinition);
        // 待实现动态del路由
        routeService.save(routeDefinition);
    }
}

