package easy.concurreny;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-27.
 */
public class PrintInOrderTest {

    private PrintInOrder printInOrder;
    private Runnable first;
    private Runnable second;
    private Runnable third;
    @Before
    public void setup() {
        printInOrder = new PrintInOrder();
        first = () -> System.out.println("first");
        second = () -> System.out.println("second");
        third = () -> System.out.println("third");
    }

    @Test
    public void first_second_third_order_test() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Integer> arr = List.of(2,3,1);
        for (int i = 0 ; i < 3 ; i++) {
            int finalI = arr.get(i);
            executor.execute(() -> {
                try {
                    if (finalI == 1) {
                        printInOrder.first(first);
                    } else if (finalI ==2) {
                        printInOrder.second(second);
                    } else {
                        printInOrder.third(third);
                    }
                } catch (InterruptedException e) {
                    fail();
                }
            });
        }
        executor.awaitTermination(1000, TimeUnit.SECONDS);
    }

}