package me.minho;

import me.minho.annotation.AnotherAnnotation;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-09-01.
 */

@AnotherAnnotation
public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
