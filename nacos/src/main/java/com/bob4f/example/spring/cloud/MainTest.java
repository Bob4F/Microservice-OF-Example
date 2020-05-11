package com.bob4f.example.spring.cloud;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author Bob
 * @version 1.0
 * @name MainTest
 * @desc TODO
 * @date 2020/5/11 11:30
 **/
public class MainTest {

    public static void main(String[] args) throws NacosException, IOException {

        String serverAddr="47.92.86.79:8848";
        String dataId="example";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId,group,5000);
        System.out.println("first receive:"+ content);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                System.out.println("from:"+ serverAddr);
                System.out.println("currentTime:"+ new Date() +",receive:"+ s);
            }
        });
        int n = System.in.read();

    }

}
