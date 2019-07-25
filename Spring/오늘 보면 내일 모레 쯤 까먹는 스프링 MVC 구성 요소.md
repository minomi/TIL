## 오늘 보면 내일 모레 쯤 까먹는 스프링 MVC 구성 요소

### HandlerMapping
Request 를 처리할 Handler 를 찾아 주는 역할.
### HandlerIntercepter
HandlerMapping 에 설정할 수 있고, Handler 를 수행하기 전 후 뷰 렌더링 완료 시점에 사용 가능하다.<br/>
HandlerMapping 이 찾아주는 Handler 에 다가 HandlerInterceptor 를 적용하는 것 <br/>
> 호출 순서 <br>
preHandle1 <br>
preHandle2 <br>
Hanlder <br>
postHandle2 <br>
postHandle1 <br>
afterCompletion2 <br>
afterCompletion1 <br>

특정 URL 패턴에만 적용할 수도 있고, 특정 URL 패턴에 적용에만 적용안 할 수도 있고 순서도 지정 가능하다. 단, 비동기 요청시에는 postHandle, afterCompletion 실행 안됨.


### ResourceHandler

html, css, image 같이 정적인 리소스를 처리하는 핸들러