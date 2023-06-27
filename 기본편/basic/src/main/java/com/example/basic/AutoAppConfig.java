package com.example.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan // @Component 찾아서 스프링 빈으로 다 등록을 해줌
        (
                basePackages = "com.example.basic",
                basePackageClasses = AutoAppConfig.class,
                excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 그 중에서 뺄 것을 지정해줌.
        )
public class AutoAppConfig {


}
