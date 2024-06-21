package jpabook.jpashop.service;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 나머지 것들은 다 읽기 전용
@RequiredArgsConstructor // final 있는 필드만 생성자 만들어 줌
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    @Transactional(readOnly = false) // 우선권 1, 데이터에 변경이 있을 떄 추가해줘야 함
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // Exception
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    // @Transactional(readOnly = true) // 조회 성능 최적화
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    // @Transactional(readOnly = true)
    public Member findByOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
