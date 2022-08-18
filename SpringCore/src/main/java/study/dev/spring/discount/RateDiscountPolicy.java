package study.dev.spring.discount;

import org.springframework.stereotype.Component;
import study.dev.spring.member.Grade;
import study.dev.spring.member.Member;

@Component
public class RateDiscountPolicy implements  DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
