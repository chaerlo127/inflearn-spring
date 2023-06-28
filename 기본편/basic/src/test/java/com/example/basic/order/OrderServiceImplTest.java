package com.example.basic.order;

import com.example.basic.discount.FixDiscountPolicy;
import com.example.basic.member.Grade;
import com.example.basic.member.Member;
import com.example.basic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @DisplayName("생성자 주입으로 해야하는 경우")
    @Test
    void createOrder(){
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itema", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }

}