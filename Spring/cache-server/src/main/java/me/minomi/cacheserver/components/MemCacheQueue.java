package me.minomi.cacheserver.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-12.
 */

@Component
@Scope("singleton")
public class MemCacheQueue <T> {
    private Set<T> items = new LinkedHashSet<>();
    private Lock lock = new ReentrantLock();

    public void add(T item) {
        try {
            lock.lock();
            items.add(item);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        try {
            lock.lock();
            return items.size();
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        try {
            lock.lock();
            return size() == 0;
        } finally {
            lock.unlock();
        }
    }

    public Set<T> getSubSet(int limit) {
        try {
            lock.lock();
            Set<T> subSet = items.stream().limit(limit).collect(Collectors.toSet());
            items.removeAll(subSet);
            return subSet;
        } finally {
            lock.unlock();
        }
    }

    public void remove(T item) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " : " + item + " 삭제");
            items.remove(item);
        } finally {
            lock.unlock();
        }
    }
}
