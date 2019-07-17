## 알쏭달쏭 Flutter


`StatefulWidget` 이 있다. 이거는 뭐냐면 `Widget` 이란거에 라이프타임 동안 상태를 변경시킬수 있덴다. 근데 아직 `Widget` 이란게 뭔지 잘 모르겠음. Flutter 의 대부분이 `Widget` 이라는데!!!

##### _(undersocre) 이게 private 프로퍼티를 쓰고 싶을때 쓰는거라더라! Dart 문법!
 
```Dart
class MyClass {
	final _privateProperty = 'sssss';
}
```

##### `Matirial App` 을 만들기 위해서는 `Scaffold` 라는걸로 감싸줘야한다! 

##### `setState()` 여기서 또 보네!!
State 객체에서 setState() 함수를 호출하면 build() 메서드를 트리거해서 UI 를 업데이트 해준다!

##### 화면 이동은 flutter 에서 route 라고 하고 역시나 stack 으로 관리!

