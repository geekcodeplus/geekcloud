package com.github.geekcloud.gateway.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: GeekcloudGatewayAdminApplication
 * @author: jeffrey
 * @date: 2020年05月21日
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GeekcloudGatewayAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekcloudGatewayAdminApplication.class, args);
    }
}
