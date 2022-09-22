package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP discount 10%")
    void vip_ok(){
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        //then
        int discount = discountPolicy.discount(memberVIP, 10000);
        //when
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("None VIP not discount 10%")
    void vip_x(){
    //given
    Member memberBASIC = new Member(2L, "memberBASIC", Grade.BASIC);
    //then
    int discount = discountPolicy.discount(memberBASIC, 10000);
    //when
        assertThat(discount).isEqualTo(0);
}
}