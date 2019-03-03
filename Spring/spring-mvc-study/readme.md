#### Servlet Filter 와 Spring MVC Interceptor

* https://supawer0728.github.io/2018/04/04/spring-filter-interceptor/
* http://forum.spring.io/forum/spring-projects/web/20146-what-is-the-difference-between-using-a-filter-and-interceptor

요약
* 실행되는 시점, 에러처리 방법들이 다름
* 인터셉터는 필터보다 좀 더 세밀한 제어 가능 (handler 에 접근할 수 있기 때문) 하다 
* 필터는 완전히 일반적인 용도로 써라 (ex 모든 요청에 log 남기기)
* 인터셉터는 handler 에 의존적인 작업이나 요청과 뷰 렌더링 사이의 작업 같은 작업을 할 때 써라

#### HttpMessageConverter
`@RequestBody`, `@ResponseBody` 를 이용할때 사용 

* `@RequestBody` : 요청 본문에 들어 있는 메시지를 HttpMessageConverter 를 이용해서 컨트롤러의 매개변수 타입으로 변경함
* `@ResponseBody` : 리턴값을 응답의 본문으로 넣어줌 (@RestController 를 사용하면 자동으로 추가)

`Request Http Header` 의 `Content-Type` 을 보고 어떤 `MessageConverter` 가 실행될지 결정됨.

그리고 현재 의존성의 상태에 따라 자동으로 추가 되는 MessageConverter 들이 따로 있음 ex (Json messageConverter 는 Jackson 라이브러리가 의존성에 추가 되어 있으면 자동으로 등록)

`WebMvcConfigurer` 에 Custom Formatter 을 추가 하여 Formatter 를 등록할 수 있고, Spring boot 를 사용한다면 @Component 로 빈으로 등록해주기만 하면 그 Formatter 가 사용됨

#### DispatcherServlet 이 사용하는 Interface

* MultipartResolver : 파일 업로드시 사용하는 인터페이스, 해당 타입의 빈이 있어야 파일 업로드 요청을 처리할 수 있다.
> Spring boot 를 사용한다면 `StandardServletMultipartResolver` 가 MultipartResolver 의 구현체로 등록이 되어 있음

* LocaleResolver : 클라이언트의 요청의 지역정보를 분석하는 역할, 기본 전략은 Accept-language 헤더를 보고 판단

* ThemeResolver : 애플리케이션에 설정된 테마를 파악하고, 변경할 수 있는 인터페이스

* HandlerMapping : 요청을 처리할 핸들러를 찾는 인터페이스
> RequestMappingHandlerMapping : 어노테이션 기반으로 요청을 처리할 핸들러를 찾는다. (기본)

* HandlerAdapter : HandlerMapping 이 찾아낸 Handler 를 처리(수행)하는 인터페이스

* HandlerExceptionResolvers : 에러를 처리하는 인터페이스

* RequestToViewNameTranslator : 핸들러에서 뷰 이름을 명시적으로 리턴하지 않은 경우, 요청을 기반으로 뷰 이름을 판단하는 인터페이스
> get /hello 로 들어오면 hello 인 View 를 찾는다.
 
* ViewResolver : 뷰 이름에 해당하는 실제 뷰를 찾아내는 인터페이스

* FlashMapManager : 중복 form 제출을 방지 하기 위해 get 리다이렉트를 할 때 데이터를 전달할 필요가 있을때, FlashMap 을 이용 

#### 리소스 핸들러
정적인 리소스를 처리하는 핸들러 이미 톰캣에 디폴트 핸들러가 등록이 되어 있다.

#### 