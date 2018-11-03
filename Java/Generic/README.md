#### Why Generic
* 컴파일 시 강한 타입 체크를 할 수 있다.
자바 컴파일러가 코드에서 잘못 사용된 타입 때문에 발생하는 문제점을 제거하기 위해 제네릭 코드에 대해 강한 타입 체크를 한다. <br>
이로 인해서 에러를 사전에 방지할 수 있다.

* Type Casting 을 제거하여 성능에 도움을 준다.
비제너릭 코드는 불필요한 타입 변환을 해야하기 때문에 프로그램 성능에 악영향을 줄 수 있다. <br>
아래의 코드는 String Type 을 리스트에 저장했지만 꺼내어 쓸때는 반드시 String Type 으로 형변환을 해주어여 한다.

```java
List list = new ArrayList();
list.add("hello");
String str = (String)list.get(0); // 타입 변환을 꼭 해야함
``` 

다음과 같이 제네릭으로 수정하면 List 에 저장되는 요소를 String 타입으로 국한하기 때문에 
요소를 꺼내어 쓸때 타입 변환을 할 필요가 없어 프로그램 성능이 향상된다.

```java
List<String> list = new ArrayList<String>();
list.add("hello");
String str = list.get(0); // 타입 변환을 하지 않는다.
```

#### Generic Class

```java
public class Box<T> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
```
위와 같은 제너릭을 사용해서 정의된 클래스는
 
```java
Box<String> box = new Box<>();
box.set("hello");
```

위와 같은 코드로 Box 클래스의 인스턴스를 생성시 컴파일러는

```java
public class Box<String> {
    private String object;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
```

로 재구성하여 Box 인스턴스를 만들게 된다.

<> 에 들어가는 문자 T 라는 것은 타입 파라미터라고 하며 여러개를 쓸 수도 있다.

#### 와일드카드
* <?> : 타입 파라미터를 대치하는 구체적인 타입으로 모든 클래스나 인터페이스 타입이 올 수 있다. 
* <? extends Type> : Type을 상속 또는 구현하는 하위타입이나 Type 만 올 수 있다.
* <? super Type> : Type의 상위타입이나 Type만 올 수 있다.

#### 제네릭 클래스 상속
제네릭 클래스도 상속을 할 수 있으며 상속을 받는 자식클래스는 타입 파라미터의 개수를 더 늘릴 수 있다. <br>
Product<K, M> 클래스를 상속받는 ChildProduct 는 자연스럽게 ChildProduce<K, M> 이 되고 필요하다면, <br>
ChildProduce<K, M, C> 이렇게 타입 파라미터를 추가 할 수 있다.  
 






