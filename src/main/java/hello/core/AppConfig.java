package hello.core;

import hello.core.dicount.DiscountPolicy;
import hello.core.dicount.FixDiscountPolicy;
import hello.core.dicount.RateDiscountPolicy;
import hello.core.memberService.MemberService;
import hello.core.memberService.MemberServiceImpl;
import hello.core.orderService.OrderService;
import hello.core.orderService.OrderServiceImpl;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;

public class AppConfig {

    // 생성자를 통해 객체가 들어감 (생성자 주입, DI)
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
