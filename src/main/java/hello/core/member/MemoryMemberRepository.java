package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository  {
// 테스트용
    private static Map<Long, Member> store = new HashMap<>(); //ConcurrentHashMap() : DI

    @Override
    public void save(Member member) {
        store.put(member.getId(),  member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
