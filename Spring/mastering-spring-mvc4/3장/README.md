@{} : Server Context Path 

ProfileForm : DTO 객체, 웹 폼의 필드의 맵핑과 검증규칙을 정함.

th:object : 폼을 정의, 제대로 동작하려면 @RequestMapping이 정의된 메서드에서 받는 인자로 정의한 폼 객체(profileForm) 을 추가해야 한다. <br>
th:field : 필드를 정의

DateFormatter 클래스 : 스프링 부트에 App 이 시돌될 때 사용할 DateFormatter 클래스를 알려주자


@Configuration 과 WebMvcConfigurerAdapter 를 상속받아 날짜를 입력받을 수 있었다.

왜 ProfileForm 에 getter setter 대신 Lombok의 @Data를 쓰명 SpringInputGeneralFieldAttrProcessor Exception 이 나는가?

@Valid : 컨트롤러에 제출된 폼의 모델이 유효한지 유효성 검증을 하라고 알려줘야 함 BindingResult 타입인 매개변수와 함께!!

스프링 부트에서는 메시지소스 빈(MessageSource Bean)을 만들어 관리하는데, 메시지 소스의 기본위치는 src/main/resource/messages.properties 이다.

스프링에서 응답 가능한 오류 메시지를 결정하는 클래스는 DefaultMessageCodesResolver 이다.

@PastLocalDate 어노테이션을 직접 정의해서 LocalDate 의 유효성을 검사하자.

국제화(i18n) 애플리케이션 내에서 다양한 언어로 번역 할 수 있도록 처리 LocaleResolver 를 이용하자. 여러가지 구현체 들이 있음.

Spring MVC 인터셉터는 서블릿 필터에 비유할 수 있다.

th:text 문법은 표현식을 통해 HTML 요소의 내용을 대체한다. #{} 문법은 messages.properties 와 유사한 프로퍼티 소스로부터 메시지를 표현하고 싶을 때 사용한다