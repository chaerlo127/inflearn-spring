package com.example.basic.web;

import com.example.basic.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;


    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest servletRequest){
        String url = servletRequest.getRequestURL().toString();
        myLogger.setRequestUrl(url);

        System.out.println("myLogger = " + myLogger);

        myLogger.log("controller test");
        logDemoService.logic("testID");
        return "OK";
    }


}
