package study.dev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.dev.spring.member.Grade;
import study.dev.spring.member.Member;
import study.dev.spring.member.service.MemberService;
import study.dev.spring.member.service.MemberServiceImpl;
import study.dev.spring.order.Order;
import study.dev.spring.order.service.OrderService;
import study.dev.spring.order.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        //    MemberService memberService = new MemberServiceImpl(null);
        //    OrderService orderService = new OrderServiceImpl(null,null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
