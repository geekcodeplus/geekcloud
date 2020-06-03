package com.github.geekcloud.gateway.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: GeekcloudGatewayWebApplication
 * @author: jeffrey
 * @date: 2020年05月26日
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GeekcloudGatewayWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeekcloudGatewayWebApplication.class, args);
    }
}
