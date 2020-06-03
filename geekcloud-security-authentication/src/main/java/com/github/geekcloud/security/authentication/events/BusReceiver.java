package com.github.geekcloud.security.authentication.events;

import com.github.geekcloud.security.authentication.entity.po.Resource;
import com.github.geekcloud.security.authentication.service.impl.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BusReceiver
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@Component
@Slf4j
public class BusReceiver {

    @Autowired
    private ResourceService resourceService;

    public void handleMessage(Resource resource) {
        log.info("Received Message:<{}>", resource);
        resourceService.saveResource(resource);
    }
}
