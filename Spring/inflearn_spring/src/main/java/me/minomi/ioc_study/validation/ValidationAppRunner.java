package me.minomi.ioc_study.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-04.
 */

@Component
public class ValidationAppRunner implements ApplicationRunner {

    @Autowired
    Validator bookValidator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Book book = Book.builder()
                .isbn("111")
                .price(-20)
                .title("")
                .build();

        Errors errors = new BeanPropertyBindingResult(book, "book");

//        BookValidator bookValidator = new BookValidator();
        bookValidator.validate(book, errors);

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
        }
    }
}
