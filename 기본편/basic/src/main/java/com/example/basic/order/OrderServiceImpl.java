package com.example.basic.order;


import com.example.basic.discount.DiscountPolicy;
import com.example.basic.member.Member;
import com.example.basic.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    // final 이 있으면 기본적으로 생성자가 있어야 할당할 수 있음.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
