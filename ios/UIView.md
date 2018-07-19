# UIView

UIView 클래스는 스크린위의 직사각형 범위를 정의하고 그 범위안의 내용을 관리하기 위한 인터페이스를 제공한다.

### Overview

뷰 객체는 런타임시 뷰의 범위 안에 있는 어떤 content의 렌더링을 다루고 그 content간의 상호작용들을 다룬다.
UIView 클래스는 직사각형 범위를 채우기 위해 backgroud color를 제공한다. 더 복잡한 content는 UIView를 서브클래싱해서 다루고, 이벤트 핸들링, view를 그리는데 필요한 코드들을 구해야한다. UIKit 프레임워크는 간단한 버튼부터 복잡한 테이블까지의 서브클래스들의 집합을 포함하고 있어서 그대로 우리가 사용할 수 도 있다. 예를들면, UILabel 객체는 문자열을 그리고, UIImageView 객체는 image를 그린다.

뷰 객체들은 사용자들과 어플리케이션간의 주요 상호작용 방식이기 때문에, 뷰 객체들은 몇 개의 책임이 있다.

* Drawing and animation
  * view들은 UIKit, Core Graphics, OpenGL ES 같은 기술들을 이용해서 뷰의 직사각형 범위안에 content를 그린다.
  *  특정 [Declared property](https://developer.apple.com/library/content/documentation/General/Conceptual/DevPedia-CocoaCore/DeclaredProperty.html)뷰는 새로운 값으로 애니메이션 될 수 있다.

* Layout and subview management
  * 하나의 뷰는 0개 이상의 서브뷰들을 가질 수 있다.
  * 각각 뷰는 부모 뷰에 따라서 뷰 자신이 고유한 크기로 리사이징을 하는 행동을 정의한다.
  * 뷰는 필요에 따라서 서브뷰들의 크기와 위치를 정의한다.

* Event handling
  * 하나의 뷰는 하나의 리스폰더라서 터치 이벤트와 다른 UIResponder 클래스에 의해 정의된 이벤트를 다룰 수 있다.
  * 뷰들은 일반적인 제스처들을 다루는 제스처 인식기를 추가하기 위해 addGestureRecognizer(_:) 메서드를 사용한다.

뷰들은 다른 뷰들안에 있을 수 있어서 복잡한 시각적인 계층을 만들 수 있다. 이 계층은 추가되는 뷰(subview)와 추가하는 뷰(superview) 사이의 부모-자식 관계를 만든다.
일반적으로, subview의 보이는 영역이 superview의 경계로 잘리지 않지만, iOS에서는 clipsToBounds 프로퍼티를 사용해서 잘리게 할 수 있다. 부모 뷰는 다수의 subview를 포함하지만, subview들의 superview는 하나 이고, superview는 subview 들을 적절히 포지셔닝 해야 한다.

뷰의 기하적인 특성은 frame, bounds, center 프로퍼티들에 의헤서 정해진다. frame은 superview의 좌표계 안에서 뷰의 원점과 크기를 정하고 일반적으로 layout 중에 뷰의 크기와 위치를 조절하는데 쓰인다. center 프로퍼티는 뷰의 크기를 변화하지 않고 뷰의 위치를 조정하는데 쓰인다. bounds는 뷰의 내부적인 위치와 크기를 정의 하며, 사용자가 뷰를 그리는 코드를 작성할때 거의 독점적으로 사용된다.


자세한건 [View Programming Guide]( https://developer.apple.com/library/content/documentation/WindowsViews/Conceptual/ViewPG_iPhoneOS/Introduction/Introduction.html)봐라.


##frame vs bounds
우선 UIView의 두 단계 렌더링 프로세스를 이해해야함
* Rasterization : 드로잉 연산들을 통해 이미지를 생성하는 것
* Composition : 각각 View의 래스터화된 이미지를 뷰 계층 구조를 따라가면서 합친다. 결국 그 이미지를 우리가 보는 것
결국 독립적인 이미지를 쌓아서 최종적인 이미지를 만들어 낸다 (마치 포토샵 같음)

Rasterization 단계에 view는 Composition 단계에서 어떤 작업이 일어날지 신경쓰지 않고 단지 자신의 content를 그리기만 한다. (어디에 그려질지, 어떤 순서로 그려질지 모름) 이 그리는 작업은 view의 draw(:rect) 메서드에서 일어남

draw 메서드가 호출되기 전에 view에 Rasterization의 결과물을 그리기 위해 빈 이미지가 생성되고 이 이미지는 view의 bounds rectangle 에 그려진다. bounds rectangle의 원점은 (0, 0) 이고 만약 이 rectangle 밖에 그리려고 한다면 그 이미지는 래스터화된 이미지의 일부분이 아니므로 무시된다.

Composition 단계에 각 View는 Super View 이미지 위에 래스터화 된 이미지를 합성한다. View의 frame rectangle은 Super View의 이미지에서 뷰의 이미지가 그려지는 위치를 결정한다. frame rectangle의 원점은 View의 좌상단 코너와 super view 의 이미지의 오프셋이다. 따라서 만약 frame rectangle의 원점이 (x: 20, y: 15) 라면 view의 이미지는 Super View의 이미지 위에 오른쪽으로 20, 아래로 15 만큼 이동된 위치에 그려질 것이다. frame rectangle과 bounds rectangle의 크기는 같아서 래스터화된 이미지가 축소되거나 늘어나지 않는다.

__Note__
```
iOS 2.x 에서 UIView의 최대 사이즈는 1024*1024 points 이다.
iOS 3.0 버젼 이후로 view들은 더 이상 최대 사이즈에 대한 제한은 없지만
그래도 view들이 사용하는 memory양에 의해서 제한되기는 한다.
가능한 뷰의 크기를 작게 하는게 좋다. 실행중인 iOS의 버젼에 관계없이,
화면의 크기보다 더 큰 content를 타일링 하는것을 고려해봐야 한다.
```

### Creating View

view를 프로그래밍으로 생성하기 위해, 다음 코드를 사용할 수 있다.
```swift
var myView = UIView(frame: CGRect(x:10, y:10, width: 100, height: 100))
```

이 코드는 view를 생성하고 view의 superview 좌표계상 (10, 10) 점에 위치시킨다(superview에 추가 된다면). subview를 또 다른 view에 subview를 추가하려면, addSubview(_:) 메서드를 사용하면 된다.
iOS에서 형제 뷰들은 아무 문제 없이 서로 겹쳐지므로 복잡한 view 배치가 가능하다. addSubview(_:) 메서드는 뷰를 형제 뷰들 중 가장 위에 위치 시킨다. insertSubview(_:aboveSubview:) 와 insertSubview(_:belowSubview:) 메서드를 이용해서 subview의 상대적인 z-order를 지정할 수 있다. 또 exchangeSubview(at:withSubviewAt:) 메서드를 이용해서 이미 더해진 subview들의 위치를 바꿀수 있다.

view가 생성될때, 올바르게 리사이징 되기 위해 autoresizingMask 프로퍼티에 적절한 값을 주는것이 중요하다. 주로 뷰 리사이징은 어플리케이션의 방향이 바뀔때 발생하기도 하고 또 다른 조건에 의해 발생하기도 하는데 예를 들어 setNeedsLayout() 메서드 호출은 너의 view들이 layout을 강제로 업데이트 하게 한다.

### The View Drawing Cycle

view drawing 은 필요에 따라 발생한다. view가 첫번째로 보여지거나 레이아웃 때문에 뷰의 전체 또는 일부가 표시될 때, 시스템은 view에게 content를 그려달라고 요청한다. UIKit이나 Core Graphics 를 사용하는 커스텀 content를 포함하는 view들의 경우, 시스템은 view의 draw(_:) 메서드를 호출한다. 이 메서드에 대한 구현은 view의 content를 현재 graphics context에 그려야 하고 graphics context는 이 메서드가 호출되게 전에 시스템에 의해 자동적으로 설정된다. draw(_:) 는 스크린에 표시되는 view의 content의 정적인 화면들을 생성한다.

view 실제 content가 변경이 되면 시스템에 view가 다시 그려져야 한다고 시스템에 알리는 것은 개발자의 몫이다. view의 setNeedsDisplay() 또는 setNeedsDisplay(_:) 메서드를 호출하여 시스템에 알릴수 있다. 이 메서드들은 시스템이 다음 drawing cycle 동안 view들을 업데이트 해야된다는걸 알게 한다. view 업데이트를 위한 다음 drawing cycle 까지 기다리기 때문에, 개발자는 동시에 여러개의 view들에 대해 이 메서드를 호출하여 업데이트 할 수 있다.

__Note__
```
당신이 만약 당신의 그림을 위해 OpenGL ES를 사용하고 있다면, UIView를 서브클래싱 하는 대신 GLKView를 사용해야 한다. 더 알고 싶으면 OpenGl ES Programming Guide를 참고해라
```
view drawing cycle과 cycle안에서 view들의 역할을 더 자세히 알고 싶으면 [View Programming Guide]( https://developer.apple.com/library/content/documentation/WindowsViews/Conceptual/ViewPG_iPhoneOS/Introduction/Introduction.html)참고해라.

### Animations

### Threading Considerations

### Subclassing Notes
