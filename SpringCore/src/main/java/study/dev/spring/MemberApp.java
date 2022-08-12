package study.dev.spring;

import study.dev.spring.member.Grade;
import study.dev.spring.member.Member;
import study.dev.spring.member.service.MemberService;
import study.dev.spring.member.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //가입한 멤버와 찾은 멤버가 같은지 확인
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member);
        System.out.println("findMember = " + findMember);

    }
}
