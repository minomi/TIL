### 구성 클래스에서 @Configuration 과 @Bean 을 붙여 자바 POJO 생성

스프링이 @Configuration 어노테이션 이 달린 클래스를 보면 @Bean 을 붙인 자바 메서드를 찾는다.

### IoC 컨테이너는 어떻게 만드냐???
스프링은 기본 구현체인 Bean Factory 와 ApplicationContext 두 가지 IoC 컨테이너를 제공한다.
ApplicationContext 는 Bean Factory 의 하위 인터페이스이다.

### @Component
스프링이 발견할 수 있게 POJO 에 붙이는 범용 애너테이션 

### @Autowired
자바 구성 클래스에 정의된 POJO/빈 인스턴스들 사이의 참조관계는 표준 자바코드로 맺어 줄 수 있다.
필드, 세터, 생성자, 또는 아무 메서드에 @Autowired 를 붙이면 POJO 레퍼런스를 자동 연결해 쓸 수 있다.

### @Primary
타입을 기준으로 자동연결시 IoC 컨테이너에 호환타입이 여러개 존재하거나 프로퍼티가 그룹형(List, Map, Array) 이 아닐 경우 제대로 연결이 안된다.
타입이 같은 빈이 여러개라면 @Primary, @Qualifier 로 연결할 수 있다.

### @Qualifier
Autowired 시에 @Qualifier("빈 이름") <- 이런식으로 빈을 명시할 수 있다.

### @Resource, @Inject
자바 표준 애노테이션인 @Resource, @Inject 로 POJO 를 자동 연결할 수 있다.
* @Resource : 이름으로 POJO 레퍼런스를 찾는다.
* @Inject : 타입으로 POJO 레퍼런스를 찾는다.

### @Scope
Bean 스코프를 지정하는 애노테이션. 스프링은 IoC 컨테이너에 선언한 빈 마다 인스턴스를 하나를 생성하고 
이렇게 만들어진 인스턴스는 전체 컨테이너 스코프에 공유된다. 이것이 모든 빈의 기본 스코프인 singleton 이다.

### @PropertySource, @PropertySourcesPlaceholderConfigurer
빈 프로퍼티 구성 전용 프로퍼티 파일의 내용을 읽을 수 있다.

### @PostConstruct
IoC 컨테이너 구성 시점에 @PostConstruct 가 붙은 메서드가 실행됨

### MessageSource 인터페이스
MessageSource 인터페이스에는 리소스 번들 메시지를 처리하는 메서드가 정의되어 있다.

### 텍스트 메시지
Main 클래스 외에 텍스트 메시지가 필요한 빈에는 MessageSource 구현체를 넣어야 한다.  

### 빈 생성, 소멸에 해당하는 메서드 설정하기
* @Bean 어노테이션의 initMethod, destroyMethod 을 이용한다.
* @PostConstruct, @PreDestroy 를 이용한다.

### Lazy 로 POJO 초기화
빈 클래스에 @Lazy 를 붙인다.

### @DependsOn
빈의 초기화 순서를 조절할 수 있다.

### BeanPostProcessor
초기화 콜백 메서드 (@Bean 의 initMethod 로 지정하거나, @PostConstruct 를 붙인 메서드) 전후에 원하는 로직을 빈에 적용할 수 있다.

### @Required
특정 빈 프로퍼티가 설정되었는지 체크하고 싶다면 커스텀 BeanPostProcessor 를 작성하고 @Required 를 붙여라.
BeanPostProcessor 구현체가 @Required 가 붙은 프로퍼티가 설정됐는지 확인한다.
단 그 값이 null 인지, 아니면 다른 값인지는 신경 쓰지 않는다.