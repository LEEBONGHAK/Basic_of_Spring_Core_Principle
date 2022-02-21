package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;   // 자동 주입할 대상이 없으면 null
import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        // 호출 안됨
        @Autowired(required = false) // 자동으로 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
        public void setNeBean1(Member noBean1) {    // Member가 Bean에 등록 안되어 있음(null)
            System.out.println("setNoBean1 = " + noBean1);
        }

        // null
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("setNoBean2 = " + noBean2);
        }

        // Optional.empty 호출 - 자동 주입할 대상이 없으면 'Optional.empty'가 입력됨
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("setNoBean3 = " + noBean3);
        }
    }
}
