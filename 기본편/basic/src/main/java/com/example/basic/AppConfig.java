package com.example.basic;

import com.example.basic.discount.FixDiscountPolicy;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;
import com.example.basic.member.MemoryMemberRepository;
import com.example.basic.order.OrderService;
import com.example.basic.order.OrderServiceImpl;

public class AppConfig {

    // DI (dependency Injection) : 의존 관계 주입
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
