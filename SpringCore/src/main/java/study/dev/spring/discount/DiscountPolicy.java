package study.dev.spring.discount;

import study.dev.spring.member.Member;

//할인정책
public interface DiscountPolicy {

    //할인 @return 할인 대상 금액
    int discount(Member member, int price);

}
