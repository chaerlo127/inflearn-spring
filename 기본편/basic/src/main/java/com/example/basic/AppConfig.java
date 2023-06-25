package com.example.basic;

import com.example.basic.discount.DiscountPolicy;
import com.example.basic.discount.RateDiscountPolicy;
import com.example.basic.member.MemberRepository;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;
import com.example.basic.member.MemoryMemberRepository;
import com.example.basic.order.OrderService;
import com.example.basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // 이러면 객체가 2개 생성 되는 것인가 ? => 싱글톤이 깨지게 되는 것인가?
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    // @Bean: 자동으로 스프링 컨테이너에 등록이 됨.
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
