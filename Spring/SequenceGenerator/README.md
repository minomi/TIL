### 구성 클래스에서 @Configuration 과 @Bean 을 붙여 자바 POJO 생성

스프링이 @Configuration 어노테이션 이 달린 클래스를 보면 @Bean 을 붙인 자바 메서드를 찾는다.

### IoC 컨테이너는 어떻게 만드냐???
스프링은 기본 구현체인 Bean Factory 와 ApplicationContext 두 가지 IoC 컨테이너를 제공한다.
ApplicationContext 는 Bean Factory 의 하위 인터페이스이다.

### @Component
스프링이 발견할 수 있게 POJO 에 붙이는 범용 애너테이션 
