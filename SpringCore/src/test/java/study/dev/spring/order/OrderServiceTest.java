package study.dev.spring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.dev.spring.AppConfig;
import study.dev.spring.member.Grade;
import study.dev.spring.member.Member;
import study.dev.spring.member.service.MemberService;
import study.dev.spring.member.service.MemberServiceImpl;
import study.dev.spring.order.service.OrderService;
import study.dev.spring.order.service.OrderServiceImpl;

public class OrderServiceTest {

 //   MemberService memberService = new MemberServiceImpl();
 //   OrderService orderService = new OrderServiceImpl();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
