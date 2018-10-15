package com.minomi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 15/10/2018.
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
