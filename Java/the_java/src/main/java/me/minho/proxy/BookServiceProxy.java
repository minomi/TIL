package me.minho.proxy;

import me.minho.Book;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 07/09/2019.
 */
public class BookServiceProxy implements BookService {

    private BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("BookServiceProxy, Rent 하기 전에 부가적인 기능을 함");
        bookService.rent(book);
        System.out.println("BookServiceProxy, Rent 한 후에 부가적인 기능을 함");
    }
}
