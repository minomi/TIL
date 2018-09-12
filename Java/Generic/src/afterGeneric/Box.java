package afterGeneric;

import obj.Apple;
import obj.Orange;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 12..
 */

// T 를 나중에 결정하겠다
// 언제?? 인스턴스 만들때
//
// T -> Type 매개변수
public class Box<T> {
    private T ob;

    public void set(T o) {
        ob = o;
    }

    public T get() {
        return ob;
    }

    public static void main(String[] args) {
        // Box<Apple> 에서 Apple -> 타입 인자
        // Box<Apple> 매개변수화 타입 (Parameterized Type)
        // 타입 매개변수에 Apple 이란 타입인자를 던져 생성한 새로운 타입!!
        Box<Apple> appleBox = new Box<>();
        appleBox.set(new Apple());
        Apple apple = appleBox.get(); // 형 변환이 필요 없다.

        Box<Orange> orangeBox = new Box<>();
        orangeBox.set("orange"); // 컴파일 오류! 컴파일러가 오류를 보여줘서 참 다행이다.
        Orange orange = orangeBox.get();
    }
}
