package com.bitc;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
한줄 삭제 ctrl + y == windows redo

@Target은 Java compiler가 어노테이션이 어디에 적용될지 결정하기 위해 사용된다.
아래의 타입을 선언함을 통해 해당 어노테이션이 어떻게 선언할 때 사용되는 것인가를 알려준다.

다음과 같은 종류의 타입이 있으며, 해당 타입을 통해 정책을 가질 수 있습니다.
ElementType.PACKAGE         : 패키지 선언
ElementType.TYPE            : 타입 선언
ElementType.ANNOTATION_TYPE : 어노테이션 타입 선언
ElementType.CONSTRUCTOR     : 생성자 선언
ElementType.FIELD           : 멤버 변수 선언
ElementType.LOCAL_VARIABLE  : 지역 변수 선언
ElementType.METHOD          : 메서드 선언
ElementType.PARAMETER       : 전달인자 선언
ElementType.TYPE_PARAMETER  : 전달인자 타입 선언
ElementType.TYPE_USE        : 타입 선언


@Retention은 해당 어노테이션이 실제로 적용되고 유지되는 범위를 의미합니다.
RetentionPolicy.RUNTIME : 컴파일 이후에도 JVM읠 통해 계속 참조가 가능. 대표적으로는 리플렉션이나 로깅에 사용
RetentionPolicy.CLASS   : 컴파일러가 클래스를 참조할 때까지만 유효
RetentionPolicy.SOURCE  : 컴파일 전까지만 유효. 컴파일 이후에는 사라지게 된다.

@Documented 선언시 선언한 어노테이션을 사용한 클래스가 문서화 될 경우 해당 어노테이션이 적용되었음을 명시하도록 한다.

@Inherited
@Inherited을 이용할 경우 해당 어노테이션을 적용한 클래스를 상속받을 경우, 해당 클래스에도 어노테이션이 적용된다. 다음의 예시를 보자

@SpringBootConfiguration은 어플리케이션의 구성을 제공하는 class-level의 어노테이션이다.
해당 어노테이션을 통해 Spring 컨테이너는 @Bean으로 정의된 클래스 메소드를 처리해 Bean을 생성한다.
생성된 Bean을 통해 @Autowired 또는 @Inject 어노테이션을 사용하여 앞서 공부했던 DI.
즉 Spring 컨테이너의 의존성 주입을 가능하게 만들어 준다.

@Indexed 적용시,
해당 어노테이션을 적용한 클래스(인터페이스)가 있을 경우 해당 클래스를 상속(extends)하거나
구현(implements)할 경우 해당 클래스(인터페이스)의 스테레오 타입에 자동으로 포함된다.

@Configuration 적용시 해당 클래스에 구현한 @Bean을 Spring 컨테이너에 포함시킬 수 있다.

@EnableAutoConfiguration을 사용할 경우 Spring Boot가 어플리케이션 컨텍스트를 자동 구성할 수 있도록 도움을 준다.
@EnableAutoConfiguration 주석을 선언한 클래스의 패키지가 기본값으로 간주되며 자동 구성하고 싶지 않는 클래스의 경우,
 exclude 또는 excludeName 옵션을 통해 제외할 수 있다.

 타입 선언시 적용되며, 런타임간 JVM에서 참조가 되며
 @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan 조합으로
 어플리케이션에 필요한 모든 Configuration 또는 Component들을 Bean으로 생성해 Spring Container에 담고,
 이를 이용하여 어플리케이션을 실행시킨다.

 */
@MapperScan(basePackages = {"com.bitc.sec.dao"})
@Slf4j
public class MVCApplication {

	public static void main(String[] args) {
		log.info("확인");	
		SpringApplication.run(MVCApplication.class, args);
	}
}
