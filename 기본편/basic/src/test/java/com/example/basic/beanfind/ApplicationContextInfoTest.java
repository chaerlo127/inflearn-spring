package com.example.basic.beanfind;

import com.example.basic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
        }
    }

    //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
    //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicatonBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                // 내가 애플리케이션 개발을 하기 위한 빈을 등록한 것이라면?
                // spring container 에 등록된 빈 정보를 불러올 수 있도록 하는 것
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }
        }
    }

    @Test
    @DisplayName("스프링 내부에서 사용하는 빈 출력하기")
    void findSpringBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE){
                // 스프링 내부에서 사용하는 빈이라면?
                // spring container 에 등록된 빈 정보를 불러올 수 있도록 하는 것
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
