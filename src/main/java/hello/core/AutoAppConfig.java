package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component Annotation이 붙은 Spring Bean을 자동으로 가져와 Bean으로 등록시겨줌
@ComponentScan(
        // 제외할 것들 지정 (AppConfig.java 및 Test 내 설정 정보들 제외 -> @Configuration 내부에 @Component가 있기 때문에)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
