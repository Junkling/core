package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestCongif.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //Thread A : A 사용자가 10000원 주문
        int userA = statefulService1.order("userA", 10000);
        //Thread B : B 사용자가 20000원 주문
        int userB = statefulService2.order("userB", 20000);

        //Thread A : A 사용자가 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userA);

//        assertThat(statefulService1.order()).isEqualTo(10000);
    }

    static class TestCongif {
    @Bean
        public StatefulService statefulService() {
        return new StatefulService();
    }

    }


}