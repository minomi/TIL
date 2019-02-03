package me.minomi.ioc_study.book;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-01.
 */

@Service
public class BookService implements InitializingBean  {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBookRepository() {
        System.out.println(bookRepository.getClass());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

}
