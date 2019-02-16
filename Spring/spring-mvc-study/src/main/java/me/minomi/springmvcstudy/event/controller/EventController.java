package me.minomi.springmvcstudy.event.controller;

import me.minomi.springmvcstudy.event.Event;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-10.
 */

@Controller
public class EventController {

    @GetMapping("/events")
    public String events(Model model) {
        return "events/list";
    }

    @GetMapping("/event/{name}")
    @ResponseBody
    public String event(@PathVariable("name") Event event) {
        return event.getName() + " event";
    }

    @GetMapping(value = "/eventJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Event eventJson(@RequestBody Event event) {
        return event;
    }
}
