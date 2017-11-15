package com.nsfc.bigdata.dataflow.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // 是 @ResponseBody 和 @Controller 的合并
@RequestMapping("/root") //根目录
public class HelloWorldController {

    @RequestMapping( value = "/helloWorld" , method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }

    // application.properies中的信息
    @Value("${server.port}")
    private int serverPort; // 设置任意类型都可以，如String,会自动转换
    @RequestMapping( value = "/serverPort" , method = RequestMethod.GET)
    public int serverPort(){
        return serverPort;
    }

    // ServerInfoProperties中的信息
    @Autowired
    private ServerInfoProperties serverInfoProperties;
    @RequestMapping( value = "/serverInfo" , method = RequestMethod.GET)
    public String serverInfo(){
        return serverInfoProperties.getRoot();
    }


}
