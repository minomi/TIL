package me.minomi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-03.
 */

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", bookService.getList());
        return "book";
    }

}
