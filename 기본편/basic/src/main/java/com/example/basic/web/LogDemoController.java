package com.example.basic.web;

import com.example.basic.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;


    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest servletRequest){
        String url = servletRequest.getRequestURL().toString();
        myLogger.setRequestUrl(url);

        myLogger.log("controller test");
        logDemoService.logic("testID");
        return "OK";
    }


}
