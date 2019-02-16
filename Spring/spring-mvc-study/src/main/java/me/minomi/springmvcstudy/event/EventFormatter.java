package me.minomi.springmvcstudy.event;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-17.
 */

public class EventFormatter implements Formatter<Event> {

    @Override
    public Event parse(String s, Locale locale) throws ParseException {
        final Event event = new Event();
        event.setName(s);
        return event;
    }

    @Override
    public String print(Event event, Locale locale) {
        return event.getName();
    }
}
