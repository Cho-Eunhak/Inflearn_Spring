package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//서비스 클래스는 좀더 비즈니스에 가깝다,,용어를 좀더 비즈니스적으로써야함
public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    //회원가입
    public Long join(Member member){

        //같은 이름 중복회원 안됨
        validateDuplicateMember(member);//중복회원검증
        memberRepository.save(member);
        return member.getId();
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
