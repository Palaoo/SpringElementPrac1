package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    void 주문할인테스트() {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        //given
        Member memberB = new Member(1L, "memberB", Grade.VIP);
        memberService.join(memberB);

        //when
        Order order = orderService.createOrder(1L, "칠갑산 도롱뇽", 12354);


        //then
        Assertions.assertThat(1000).isEqualTo(order.getDiscountPrice());
    }
}
