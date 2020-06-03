package com.github.geekcloud.system.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: GeekcloudSystemAdminApplication
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GeekcloudSystemAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeekcloudSystemAdminApplication.class, args);
    }
}
