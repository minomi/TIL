배터리 일체형 장난감 :  배터리가 떨어지면 -> 새로 구임
배터리 분리형 장난감 :  배터리가 떨어지면 -> 교체
둘 다 고장에서 배터리를 주입받고 배터리에 의존하고 있음. 하지만 좀 더 효과적인 의존성 주입은 배터리 분리형임

싱글톤: 컨테이너에서 생성된 빈 객체의 경우 동일한 타입을 한개만 생성
프로토타입: getBean 을 호출할 때마다 객체를 생성

@Autowired : 주입하려고 하는 객체의 타입이 일치하는 객체를 컨테이너 내에서 찾아서 자동으로 주입한다.

동일한 타입의 객체가 두개 이상이면 Exception 발생 -> @Qualifier 사용 

빈이 생성될때, 해제될때 특별한 작업을 하고 싶다면
1. InitializingBean, DisposableBean 인터페이스 구현
2. 설정 파일에 init-method, destroy-method 이용  

인터셉터(interceptor) : 리다이렉트가 빈번하게 일어날때 사용 <br>
보통 HandlerInterceptorAdapter 를 상속 받아 구현한다.

1. Requeset 시작
2. DispatcherServlet 작동
3. preHandle 메서드 실행  (HandlerInterceptor Interface 에 정의)
4. Handler
5. Controller
6. postHandle 메서드 실행  (HandlerInterceptor Interface 에 정의)
7.  View 시작
8. View 반환
9. afterCompletion 메서드 실행  (HandlerInterceptor Interface 에 정의)
10. Response
