package com.github.geekcloud.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName: GeekcloudTestApplication
 * @author: jeffrey
 * @date: 2020年04月15日
 * @Description: TODO
 */
@SpringBootApplication
@Slf4j
public class GeekcloudTestApplication {
    public static void main(String[] args) throws UnknownHostException {
        //SpringApplication.run(GeekcloudTestApplication.class, args);

        ConfigurableApplicationContext application = SpringApplication.run(GeekcloudTestApplication.class, args);
        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "应用 '{}' 运行成功! 访问连接:\n\t" +
                        "Swagger文档: \t\thttp://{}:{}/doc.html\n\t" +
                        "数据库监控: \t\thttp://{}:{}/druid\n" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                "127.0.0.1",
                env.getProperty("server.port"));
    }
}
