package me.minomi.springmvcstudy;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-24.
 */

@Controller
public class SimpleController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/hello/*")
    @ResponseBody
    public String helloAnybody() {
        return "hello";
    }

    @RequestMapping(value = "/hello/{name:[a-z]+}")
    @ResponseBody
    public String helloRegexName(@PathVariable String name) {
        return "hello regex " + name;
    }
}
