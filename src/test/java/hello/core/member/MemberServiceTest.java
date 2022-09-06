package hello.core.member;

import hello.core.AppConfigs;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfigs appConfigs = new AppConfigs();
        memberService = appConfigs.memberService();
        orderService = appConfigs.orderService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "MemberA", Grade.VIP);


        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
