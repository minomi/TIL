#### Servlet Filter 와 Spring MVC Interceptor

* https://supawer0728.github.io/2018/04/04/spring-filter-interceptor/
* http://forum.spring.io/forum/spring-projects/web/20146-what-is-the-difference-between-using-a-filter-and-interceptor

요약
* 실행되는 시점, 에러처리 방법들이 다름
* 인터셉터는 필터보다 좀 더 세밀한 제어 가능 (handler 에 접근할 수 있기 때문) 하다 
* 필터는 완전히 일반적인 용도로 써라 (ex 모든 요청에 log 남기기)
* 인터셉터는 handler 에 의존적인 작업이나 요청과 뷰 렌더링 사이의 작업 같은 작업을 할 때 써라

