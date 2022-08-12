package study.dev.spring.member.service;

import study.dev.spring.member.Member;

public interface MemberService {
    // 회원가입
    void join(Member member);
    // 회원조회
    Member findMember(Long memberId);
}
