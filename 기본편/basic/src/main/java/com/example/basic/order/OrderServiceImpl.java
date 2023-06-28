package com.example.basic.order;


import com.example.basic.annotation.MainDiscountPolicy;
import com.example.basic.discount.DiscountPolicy;
import com.example.basic.member.Member;
import com.example.basic.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


//    OrderServiceImplTest
    /**
     *   @Autowired
     *   public void setMemberRepository(MemberRepository memberRepository){
     *          this.memberRepository = memberRepository;
     *   }
     *   @Autowired
     *   private DiscountPolicy discountPolicy;
     *   public void setDiscountPolicyDiscountPolicy discountPolicy){
     *          this.discountPolicy = discountPolicy;
     *   }
     */


// = @RequiredArgsConstructor
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

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
