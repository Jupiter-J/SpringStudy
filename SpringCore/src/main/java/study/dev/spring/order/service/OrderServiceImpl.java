package study.dev.spring.order.service;

import study.dev.spring.discount.DiscountPolicy;
import study.dev.spring.discount.FixDiscountPolicy;
import study.dev.spring.member.Member;
import study.dev.spring.member.repository.MemberRepository;
import study.dev.spring.member.repository.MemoryMemberRepository;
import study.dev.spring.order.Order;

public class OrderServiceImpl implements OrderService{

    //final이 붙으면 무조건 생성자 할당이 필요하다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //대상 멤버를 찾는다
        Member member = memberRepository.findById(memberId);
        //멤버와 상품을 주문한다 {할인에 대한 부분은 그냥 넘김 = 단일책임정책}
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
