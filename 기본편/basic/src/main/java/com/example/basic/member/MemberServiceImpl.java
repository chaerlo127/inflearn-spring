package com.example.basic.member;

public class MemberServiceImpl implements MemberService{

    // 인터페이스가 이닌 구현체를 의존하기 때문에 DIP, OCP 에 위배 됨.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
