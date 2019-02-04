package me.minomi.ioc_study.proxy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-04.
 */

@Primary
@Service
public class EventServiceImpl implements EventService {
    /**
     * 0.5 초가 걸리는 작업
     */

    @PerformanceLog
    @Override
    public void createEvent() {
        try {
            Thread.sleep(500);
            System.out.println("create event");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1 초가 걸리는 작업
     */

    @PerformanceLog
    @Override
    public void publishEvent() {
        try {
            Thread.sleep(1000);
            System.out.println("publish event");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent() {
        System.out.println("delete event");
    }
}
