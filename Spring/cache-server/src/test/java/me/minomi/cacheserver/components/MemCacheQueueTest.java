package me.minomi.cacheserver.components;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-12.
 */
public class MemCacheQueueTest {
    private MemCacheQueue<String> memCacheQueue;
    private ExecutorService threadPool;
    private static final int THREAD_COUNT = 10;

    @Before
    public void setUp() {
        memCacheQueue = new MemCacheQueue<>();
        threadPool = Executors.newFixedThreadPool(10);
    }

    @Test
    public void add() {
        IntStream.range(0, THREAD_COUNT).forEach((i) -> threadPool.submit(() -> memCacheQueue.add("hihi")));
        assertEquals(memCacheQueue.size(), 1);
    }

    @Test
    public void getSubSet() {
        Runnable task1 = () -> {
            memCacheQueue.add("1111");
            memCacheQueue.add("2222");
        };

        Runnable task2 = () -> {
            memCacheQueue.add("2222");
            memCacheQueue.add("3333");
        };

        Runnable task3 = () -> {
            memCacheQueue.add("3333");
            memCacheQueue.add("4444");
        };

        Runnable task4 = () -> {
            memCacheQueue.add("4444");
            memCacheQueue.add("5555");
        };

        threadPool.submit(task1);
        threadPool.submit(task2);
        threadPool.submit(task3);
        threadPool.submit(task4);

        Set<String> subSet = memCacheQueue.getSubSet(3);
        assertEquals(subSet.size(), 3);
        assertEquals(memCacheQueue.size(), 2);
    }

    @Test
    public void remove() {
        memCacheQueue.add("1111");
        memCacheQueue.add("2222");
        memCacheQueue.remove("1111");
        assertEquals(memCacheQueue.size(), 1);
    }
}