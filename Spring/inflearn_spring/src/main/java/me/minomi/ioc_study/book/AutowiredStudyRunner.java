package me.minomi.ioc_study.book;

import me.minomi.ioc_study.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-02.
 */

@Component
public class AutowiredStudyRunner implements ApplicationRunner {

    private BookService bookService;

    public AutowiredStudyRunner(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        bookService.printBookRepository();
    }
}
