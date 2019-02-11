package me.minomi.springmvcstudy.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
