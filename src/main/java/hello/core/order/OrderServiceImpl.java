package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final  DiscountPolicy discountPolicy; // 인터페이스에만 의존하도록 만듦 -> null
    private final MemberRepository memberRepository;
    //    private final DiscountPolicy discountPolicy  = new RateDiscountPolicy();
////OCP를 위반
    //DIP는 추상에만 의존해야 된다.
    // 관심사를 분리해야 한다. : appConfig

//생성자 추가 :구체적인 입장은 모르기 때문에
    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
         Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
