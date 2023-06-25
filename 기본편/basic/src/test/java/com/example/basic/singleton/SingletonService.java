package com.example.basic.singleton;

public class SingletonService {

    // singleton object: class 레벨에 올라기기 때문에 딱 한 개만 존재한다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }


    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
