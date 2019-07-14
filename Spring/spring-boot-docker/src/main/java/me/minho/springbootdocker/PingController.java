package me.minho.springbootdocker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-14.
 */

@RestController
public class PingController {

    @GetMapping("/ping")
    public String pong() {
        return "pong";
    }
}
