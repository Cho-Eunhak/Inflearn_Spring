package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//저장
    Optional<Member> findById(Long id); //null을 처리하는방법임
    Optional<Member> findByName(String name);//찾는것
    List<Member> findAll();//모든 리스트 반환해주기
}
