package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

//동시성문제있을수있지만 예제니까 hashmap 스겟다
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;
    
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;

    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//없으면 null이기때문에
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();//람다
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());

        //검증 어캐할까??테스트케이스작성!!
    }

    public void clearStore(){
        store.clear();
    }
}
