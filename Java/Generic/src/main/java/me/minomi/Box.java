package me.minomi;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 03/11/2018.
 */
public class Box<T> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }


    // 리턴 타입이 R 이고, 매개변수가 T 타입인 함수
    public <R> Box<R> boxing(T t) {
        Box<R> box = new Box<>();
        box.setObject((R)t);
        return box;
    }
}
