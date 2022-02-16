package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

public class StatefulServiceTest2 {

    @Test
    @DisplayName("싱글톤 방식의 주의점 해결")
    void statefulServiceSingleton2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService2 statefulService1 = ac.getBean(StatefulService2.class);
        StatefulService2 statefulService2 = ac.getBean(StatefulService2.class);

        // ThreadA : 사용자 A 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        // ThreadB : 사용자 B 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA : 사용자 A 주문 금액 조회
        System.out.println("price = " + userAPrice);
    }

    static class TestConfig {
        @Bean
        public StatefulService2 statefulService2() {
            return new StatefulService2();
        }
    }
}
