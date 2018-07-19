## 왜 UI 관련 작업은 Main Thread 에서 실행되어야 하는가


Cocoa Touch에서 App이 시작 할 때 UIApplication은 Main Thread에서 만들어진다.
화면상 모든 뷰들 (label, button 등등)은 UIApplication 인스턴스의 자손들이다. (<- 이 문장에 대한 이해가 더 필요함) button을 탭 하거나 button을 이용해 어떤 작업을 할 때, 화면 업데이트는 Main Thread 위에서 실행되어야 한다, button, label 이런 UIApplication의 자손 객체가 Main Thread의 일부이기 때문이다.
마찬가지로 pinch 같이 button, label 등에서 비롯된 event들은 Main Thread의 일부이기 때문에 Main Thread 위에서 처리되어야 한다.

또 다른 이유는 Graphic rendering 때문인데 iPhone의 그래픽 파이프라인이 동기식이기 때문이다.

UILabel에 네트워크에서 가져온 유저의 이름을 그려야한다고 가정해보자, 아마 유저의 이름을 Dispatch.main.async 메서드를 통해 비동기로 기다릴 것이다. 네트워크에서 유저의 이름을 가져오면 UILabel에 가져온 콘텐츠를 그린다.

UIKit이 UILabel에 text를 그릴때, font를 레스터화 하고 text를 pixel로 바꾼다. text에 투명도를 적용하거나 클리핑 할 때 처럼 text가 blended layer의 일부가 될 때, UIKit은 화면에 그려야 할 label의 pixel을 계산한다. 이 pixel들은 나머지 화면들과 함께 최대 초당 60번 화면에 그려진다.

iPhone 화면에 이미지, 텍스트를 그린다는 것은 LED display위에 pixel을 밝히는 것인데 이 작업은 한번에 처리되야할 필요가 있다. 화면에 모든 픽셀들이 동시에 그려지는 작업이기 때문이다.

동기식이 아닌 병렬로 정의된 비동기식에서는 어떤 연산이 끝날때를 확신할 수 없다. 만약 하나의 thread 가 아닌 여러 thread에서 비동기 UI 작업을 허락하게 된다면, 전체 화면이 렌더링 될 때 해당 부분에 대한 처리가 준비되지 않을 수도 있다, 그러면 전체적으로 많은 깜박임과 누락된 부분이 생길 수 있다.

이러한 이유들 때문에 UI update는 Main Thread 에서 처리하는게 가장 간단하다

https://www.quora.com/Why-must-the-UI-always-be-updated-on-Main-Thread
