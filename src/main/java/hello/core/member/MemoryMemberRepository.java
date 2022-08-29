package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository  {
// 테스트용
    private static Map<Long, Member> store = new HashMap<>();
    //ConcurrentHashMap() : DI 동시성 이슈가 있을 수 있기 때문에

    @Override
    public void save(Member member) {
        store.put(member.getId(),  member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
