package com.example.basic.lifecycle;

public class NetworkClient{

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url  = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 메소드
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close = " + url);
    }

    // 의존성 주입 이후에 이 메소드를 실행해라.
    public void init() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    // 빈 소멸 전에 이 메소드를 실행해라
    public void close()  {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
