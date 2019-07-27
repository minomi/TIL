package easy.concurreny;

import java.util.concurrent.Semaphore;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-27.
 */
public class PrintInOrder {

    Semaphore first = new Semaphore(0);
    Semaphore second = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.release(); // first 세마포어의 permits 1 증가 시켜 1 개 스레드가 사용 가능 하게
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        first.acquire(); // first 세마포어의 permits 이 0 이니 일단 대기
        printSecond.run();
        second.release(); // second 세마포어의 permits 1 증가 시켜 1 개 스레드가 사용 가능하게
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        second.acquire(); // second 세마포어의 permits 이 0 이니 일단 대기
        printThird.run();
    }

}