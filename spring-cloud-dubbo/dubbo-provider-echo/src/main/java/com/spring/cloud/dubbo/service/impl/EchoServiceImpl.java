package com.spring.cloud.dubbo.service.impl;

import com.spring.cloud.dubbo.api.EchoService;
import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Bob
 * @version 1.0
 * @name EchoServiceImpl
 * @desc TODO
 * @date 2020/5/14 16:24
 **/
@Service(timeout = 5000,version = "1.0.0")
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String text) {
        long start = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
        long end = System.currentTimeMillis();
        return "\r\n\t" + start + " Provider received." +
                "\r\n\t\tProvider processed after sleep 1 second! Echo String: \"" + text + "\"" +
                "\r\n\t" + end + " Provider Return";
    }


}
