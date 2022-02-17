package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component Annotation이 붙은 Spring Bean을 자동으로 가져와 Bean으로 등록시겨줌
@ComponentScan(
//        // @Component 탐색 시작위치 지정 - 해당 위치부터 하위 패키지 또는 파일을 탐색함
//        basePackages = "hello.core",
//        // 해당 클래스가 위치하는 패키지부터 탐색 - 지정하지 않으면 default로 @ComponentScan을 붙인 파일이 위치하는 패키지부터 시작
//        basePackageClasses =  AutoAppConfig.class,
        // 제외할 것들 지정 (AppConfig.java 및 Test 내 설정 정보들 제외 -> @Configuration 내부에 @Component가 있기 때문에)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
