package study.dev.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.dev.spring.member.Member;
import study.dev.spring.member.repository.MemberRepository;
import study.dev.spring.member.repository.MemoryMemberRepository;

//todo: 배우가 직접 담당 배우를 찾아서 섭외하는 것과 같다

//MemberServiceImpl이 구현체(MemoryMemberRepository)를 의존
// 추상화(MemberRepository)에도 의존, 구화에도 의존한다
@Component
public class MemberServiceImpl implements MemberService{

    /** 다형성: MemberRepository 인터페이스가 아닌 구현된 MemberMemberRepository가 오버라이딩된다
                                                        //실제 할당하는 부분이 구현체를 의존한 => DIP 위반
    private final MemberRepository memberRepository = new MemoryMemberRepository();
     */

    //추상화에만 의존하도록 한다 = 생성자를 통해서 객체가 늘어난다 = 객체주입
    private final MemberRepository memberRepository ; //1. 구현체부분을 삭제
    //2. 생성자 생성
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}