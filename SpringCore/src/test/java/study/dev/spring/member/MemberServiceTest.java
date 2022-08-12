package study.dev.spring.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.dev.spring.AppConfig;
import study.dev.spring.member.service.MemberService;
import study.dev.spring.member.service.MemberServiceImpl;

public class MemberServiceTest {
    MemberService memberService;
  //  MemberService memberService = new MemberServiceImpl();

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
