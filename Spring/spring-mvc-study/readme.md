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
