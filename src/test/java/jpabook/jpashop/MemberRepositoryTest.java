//package jpabook.jpashop;
//
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MemberRepositoryTest {
//
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    // 1. EntityManager 를 통한 모든 데이터 변경은 @Transactional 안에서 일어나야 한다.
//    // 2. @Transactional 이 테스트 케이스에 있으면 테스트가 끝난 후 바로 롤백을 한다.
//    // 3. @Rollback(false) 로 설정해 놓으면 롤백을 하지 않고 커밋한다.
//    public void testMember() throws Exception {
//        // given
//        MemberTest memberTest = new MemberTest();
//        memberTest.setUsername("memberA");
//
//        // when
//        Long savedId = memberRepository.save(memberTest);
//        MemberTest findMemberTest = memberRepository.find(savedId);
//
//        // then
//        Assertions.assertThat(findMemberTest.getId()).isEqualTo(memberTest.getId());
//        Assertions.assertThat(findMemberTest.getUsername()).isEqualTo(memberTest.getUsername());
//        Assertions.assertThat(findMemberTest).isEqualTo(memberTest); //JPA 엔티티 동일성 보장
//    }
//}