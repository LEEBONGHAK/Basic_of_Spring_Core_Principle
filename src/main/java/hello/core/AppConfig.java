package hello.core;

import hello.core.dicount.FixDiscountPolicy;
import hello.core.memberService.MemberService;
import hello.core.memberService.MemberServiceImpl;
import hello.core.orderService.OrderService;
import hello.core.orderService.OrderServiceImpl;
import hello.core.repository.MemoryMemberRepository;

public class AppConfig {

    // 생성자를 통해 객체가 들어감 (생성자 주입, DI)
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
