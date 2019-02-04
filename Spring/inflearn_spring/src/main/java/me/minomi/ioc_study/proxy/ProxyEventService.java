package me.minomi.ioc_study.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-04.
 */

//@Primary
@Service
public class ProxyEventService implements EventService {

    @Autowired
    EventServiceImpl eventService;

    @Override
    public void createEvent() {
        System.out.println("create event start");
        long start = System.currentTimeMillis();
        eventService.createEvent();
        System.out.println("create event end " + (System.currentTimeMillis() - start) + " 가 걸림");
    }

    @Override
    public void publishEvent() {
        System.out.println("publish event start");
        long start = System.currentTimeMillis();
        eventService.publishEvent();
        System.out.println("publish event end " + (System.currentTimeMillis() - start) + " 가 걸림");
    }

    @Override
    public void deleteEvent() {
        System.out.println("delete event start");
        long start = System.currentTimeMillis();
        eventService.deleteEvent();
        System.out.println("delete event end " + (System.currentTimeMillis() - start) + " 가 걸림");
    }
}
