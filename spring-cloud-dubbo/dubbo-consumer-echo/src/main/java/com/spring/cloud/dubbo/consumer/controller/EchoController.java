package com.spring.cloud.dubbo.consumer.controller;

import com.spring.cloud.dubbo.api.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bob
 * @version 1.0
 * @name EchoController
 * @desc TODO
 * @date 2020/5/14 17:13
 **/
@RestController
public class EchoController {

    @Reference(version = "1.0.0")
    EchoService echoService;


    @PostMapping("/echo")
    public Object echo(@RequestParam("text")String text){
        try {
            return echoService.echo(text);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
