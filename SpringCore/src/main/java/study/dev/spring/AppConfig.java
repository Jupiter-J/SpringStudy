package study.dev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.dev.spring.discount.DiscountPolicy;
import study.dev.spring.discount.FixDiscountPolicy;
import study.dev.spring.member.repository.MemoryMemberRepository;
import study.dev.spring.member.service.MemberService;
import study.dev.spring.member.service.MemberServiceImpl;
import study.dev.spring.order.service.OrderService;
import study.dev.spring.order.service.OrderServiceImpl;

//todo: 어플리케이션에 대한 환경구성을 설정한다
@Configuration
public class AppConfig {

    // AppConfig를 통해서 MemberService를 호출시
    // MembeService의 구현체 생성, 이때 MemoryMemberRepository가 할당이 된다
    //여기서 MemoryMemeberRepository에는 구현체가 없다
   @Bean
    public MemberService memberService(){
       //1, 구현체 생성 (new MemoryMemberRepository)
       //2. 생성된 것의 주솟값과 MemberServiceImpl이 생성될때 주입된다
       return new MemberServiceImpl(memberRepository());
   }
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
       return new OrderServiceImpl(
               memberRepository(),
               discountPolicy());
   }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
