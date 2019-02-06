package me.minomi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-06.
 */

@Controller
public class HelloController {

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping(value = "/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("qeqeq");
        System.out.println("applicationContext : " + applicationContext);
    }

}
