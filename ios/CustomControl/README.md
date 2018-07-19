* public init(frame:), init(corder:) 작성, init(frame:) 에 tintcolor 로 backgroundColor 주기

  > viewController에서 init(frame:) 으로 control을 생성할시 superView의 bounds를 인자로 넘기자!

* 꼭 description 을 포함해서 프로퍼티들 작성 하기 (단축키 option + command + /)

* UIView를 사용 할때 CALayer를 이용할 수 있고, CALayer는 iOS가 GPU를 이용해서 렌더링을 최적화할 수 있게 한다.

* animation 시 Core Graphics를 이용해서 draw(rect:)를 오버라이드 한다면 animation 모든 단계에 control이 re-rendering 되어 매우 비효율적이다. Core Animation 을 이용하자.

* CustomControl의 appearance한 부분과 control적인 부분을 nested class를 사용해서 코딩하자.

* CAShapeLayer 는 CALayer 의 subclass 이고 anti-aliasing과 최적화된 rasterization 기법을 사용해서 임의의 모양을 효율적으로 그려줍니다.

* CAShapeLayer의 path를 그릴때는 UIBezierPath를 이용해서 경로를 그리고 cgPath 프로퍼티를 사용하자

* tintColorDidChange()를 구현해서 tintColor 변화에 따른 UI 변경을 해주자.

* Core Animation 은 CALayer의 임의의 프로퍼티가 바뀌면 (transform 포함) 암시적으로 animation 을 한다.

* keyframe animation 을 이용하면 시작, 끝 지점 뿐만 아니라 중간지점도 지정할 수 있다. 중간 지점들에 도달하는 속도를 CAMediaTimeingFunction 을 통해 지정할 수 있다.

* 화면을 터치할때 iOS에서 적절한 객체로 UITouch 이벤트들을 전달하는데, 하나 이상의 gesture recognizer가 등록돼 있다면, 터치 이벤트는 gesture recognizer로 전달되어 어떤 터치 이벤트인지 해석된다. 또 action message도 target에 전달할 수도 있다. 커스텀할 컨트롤에 적절한 커스텀 gesture recognizer를 만들어 두면 좋다. touchesBegan(touches:, with:), touchesMoved(touched:, with:), touchedEnd

* Target-Action 패턴을 이용해서 action을 보낼때 sendAction(for:controlEvent)라는 메서드를 활용하면 된다.
