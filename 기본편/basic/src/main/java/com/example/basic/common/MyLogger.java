package com.example.basic.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // request 요청이 들어왔을 때 빈을 생성하는데, 프로젝트를 시작햇을 때 빈을 생성하다보니 에러가 뜨는 것임
public class MyLogger {
    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestUrl + "] " + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + this.uuid + "] request scope bean create: " + this);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
