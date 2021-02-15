package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

//테스트는 의존관계없이 설계가 되어야한다
public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //데이터 클리어링
    @AfterEach//콜백메소드
    public void afterEach(){
        repository.clearStore();//한번씩 저장소를 징줘서 순서와 상관없게됨 테스트가
    }

    
    @Test
    public void save(){
        //
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = " + (result ==member));
        //Assertions.assertEquals(member, result);//테스트방법
        Assertions.assertThat(member).isEqualTo(result);
    }


        @Test
        public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();//에러가나오는이유
        Assertions.assertThat(result).isEqualTo(member1);
        }

        @Test
        public void findAll(){
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);

            List<Member> result = repository.findAll();
            Assertions.assertThat(result.size()).isEqualTo(2);

        }


}
