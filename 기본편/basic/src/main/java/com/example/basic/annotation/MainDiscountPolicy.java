package com.example.basic.annotation;


import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

// 아래 어노테이션은 Qualifier 에 있는 어노테이션을 그대로 가져온 것이다.
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
