package study.dev.spring.member.service;

import study.dev.spring.member.Member;
import study.dev.spring.member.repository.MemberRepository;
import study.dev.spring.member.repository.MemoryMemberRepository;

//MemberServiceImpl이 구현체(MemoryMemberRepository)를 의존
// 추상화(MemberRepository)에도 의존, 구화에도 의존한다
public class MemberServiceImpl implements MemberService{
    // 다형성: MemberRepository 인터페이스가 아닌 구현된 MemberMemberRepository가 오버라이딩된다
                                                        //실제 할당하는 부분이 구현체를 의존한 => DIP 위반
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}