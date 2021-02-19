package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//서비스 클래스는 좀더 비즈니스에 가깝다,,용어를 좀더 비즈니스적으로써야함
//@Service//스프링에 인식시킴
@Transactional//jpa는 이게있어야함
public class MemberService {
    private final MemberRepository memberRepository;
    //@Autowired
    public MemberService(MemberRepository memberRepository) {//이렇게 new로 두번생성하는걸 막을수있음
        this.memberRepository = memberRepository;
    }


    //회원가입
    public Long join(Member member){

        //AOP는 공통관심사항과 핵심관심사항으로 나눌수있따
        //공통은 cross cutting,, 핵심은 core

        //원하는 곳에 공통관심사항을 적용한다-->AOP
        long start = System.currentTimeMillis();

        try {
            //같은 이름 중복회원 안됨
            validateDuplicateMember(member);//중복회원검증
            memberRepository.save(member);
            return member.getId();
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = "+ timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member) {

        //        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent((m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }));


        //그냥 꺼내고 싶으면 get쓰면 됨 orelseget많이 씀
        //Optional 바로 쓰는거보다는
        memberRepository.findByName(member.getName())
                .ifPresent((m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                }));
    }

//전체 회원 조회
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
