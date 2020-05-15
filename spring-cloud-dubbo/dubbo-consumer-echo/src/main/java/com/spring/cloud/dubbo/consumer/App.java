package com.spring.cloud.dubbo.consumer;

import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Bob
 * @version 1.0
 * @name App
 * @desc TODO
 * @date 2020/5/14 16:35
 **/
@EnableDiscoveryClient
@EnableDubbo
@SpringBootApplication
@ComponentScan("com.spring.cloud.dubbo")
public class App {

    public static void main(String[] args) {
            SpringApplication.run(App.class, args);
        }

   @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20880);
        protocolConfig.setName("dubbo");
        return protocolConfig;
    }
}
