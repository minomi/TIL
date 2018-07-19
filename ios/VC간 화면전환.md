

모든 ViewController는 TransitioningDelegate를 가지고 있다.

* TransitioningDelegate은 UIViewControllerTransitioningDelegate protocol의 구현체이고 ViewController가 present/dismiss 할 때마다 animation controller 를 리턴한다

* Animation Controller는 UIViewControllerAnimatedTransitioning protocol 의 구현체이고 Transitioning Context 를 이용해 화면전환 애니메이션을 수행한다.

* Transitioning Context는 UIViewControllerContextTransitioning의 구현체 이고, 화면전환에 관련된 ViewController의 정보를 갖고 있고, 화면전환 처리의 중요 역활을 수행한다. 커스텀 화면전환을 구현할때 UIViewControllerContextTransitioning 을 구현할 필요는 없다, 화면전환이 발생할때 마다 UIKit이 현재 화면전환에 필요한 설정들을 가지고 있는 context를 animation controller에게 제공하기 때문이다.

![화면전화에 필요한 객체들](https://koenig-media.raywenderlich.com/uploads/2015/07/parts.001.jpg)


화면전환 절차

1. present, segue 등을 통해 화면전환을 시작한다.

2. UIKit은 보여질 ViewController(ToViewController)에게 TransitioningDelegate 을 요청한다. (만약 없다면 내장된 디폴트 transition 사용)

3. 그 다음 UIKit  animationControllerForPresentedController(_:presentingController:sourceController:)메서드를 통해 TransitioningDelegate 에게 animation controller를 요청한다. 만약 nil을 리턴하면 기본 애니메이션을 사용한다.

4. 유효한 animation controller를 리턴하면 UIKit은 Transitioning Context를 만든다.

5. UIKit은 animation controller의 transitionDuration(_:) 을 사용해서 애니메이션 시간을 알아낸다.

6. UIKit이 animation controller의 animateTransition(_:) 메서드를 호출해 화면전환 애니메이션을 수행한다.

7. 마지막으로 animation controller는 animation이 끝났음을 알리기 위해  transitioning context 상에서 completeTransition(_:) 메서드를 호출한다.
