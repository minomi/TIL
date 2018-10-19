##### Spring boot
* 스프링가반의 제품 수준 프로젝트를 진행할 때 쉽게 만들게 해준다.
* 널리 쓰이는 설정들을 자동으로 설정해준다. 또한 커스텀도 쉽다. (ex 톰캣 설정)
* XML 설정, Code Generation 을 하지 않는다.
* 자바 8 부터 가능

##### Spring boot 를 생성하는 방법
* 인텔리제이 SpringInitilzer사용
* start.spring.io 이용
* Command Line 명령어 이용

##### mvn package
mvn package 명령어로  package 를 생성 후 (target 디렉터리에 생성) java -jar  명령어로 실행가능

#### 스프링 부트 프로젝트 구조
* 메이븐 기본 프로젝트 구조와 동일
* main/java/resource 디렉토리 <- Root 디렉토리
Main Application Class (SpringBookApplication 어노테이션의 달린 클래스) : 내가 쓰고 있는 최상위 패키지에 Main Application class 를 위치시키자! (Component Scan Main Application class 의 패키지 부터 하기 때문)

#### 자동설정이해
@SpringBootApplication = @SpringBookConfiguration + @ComponentScan + @EnableAutoConfiguration (ComponentScan 으로 빈을 다 등록한 후 다시 EnableAutoconfigutaion 을 통해서 나머지 빈을 등록함)

ComponentScan -> @ComponentScan 이 달린 클래스의 하위 패키지의 @Component
@Configuration @Repository @Service @Controller @RestController 애노테이션들을 가진 클래스를 찾아서 빈으로 등록 시킴

@EnableAutoConfiguration -> spring-boot-autoconfigure.jar 에 있는  spring.factories 에 org.springframework.boot.autoconfigure.EnableAutoConfiguration 를 key 로 가지고 있는 클래스들을 빈으로 등록한다 (조건이 있음)


