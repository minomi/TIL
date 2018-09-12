package beforeGeneric;

import obj.Apple;
import obj.Orange;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 12..
 */

public class Box {
    private Object object;

    public void set(Object o) {
        object = o;
    }

    public Object get() {
        return object;
    }

    public static void main(String[] args) {
        Box aBox = new Box();
        aBox.set(new Apple());
        Apple apple = (Apple) aBox.get(); // 단점
        // 어쩔 수 없이 형 변환의 과정이 수반.
        // 컴파일러의 오류 발견 가능성을 낮춘다.

        Box oBox = new Box();
        oBox.set("orange");
        Orange og = (Orange) oBox.get();
        // 오류, 컴파일러가 발견 못한다
        // 치명적
    }
}

