package me.minho.proxy;

import me.minho.Book;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 07/09/2019.
 */
public class BookServiceImpl implements BookService {
    @Override
    public void rent(Book book) {
        System.out.println("BookInterface 구현체, " + book.getTitle() + " 을 빌렸다.");
    }
}
