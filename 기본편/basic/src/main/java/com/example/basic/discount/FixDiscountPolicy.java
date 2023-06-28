package com.example.basic.discount;

import com.example.basic.member.Grade;
import com.example.basic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//-> 조회 빈이 2개 이상 - 문제 에러 발생 같은 역할의 두개의 빈이 생성되기 때문
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
}
