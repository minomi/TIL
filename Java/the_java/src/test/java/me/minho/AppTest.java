package me.minho;

import static org.junit.Assert.assertTrue;

import me.minho.proxy.BookService;
import me.minho.proxy.BookServiceImpl;
import me.minho.proxy.BookServiceProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        BookService bookService = (BookService) Proxy.newProxyInstance(
                BookService.class.getClassLoader(),
                new Class[]{BookService.class},
                (proxy, method, args) -> {
                    BookService realSubject = new BookServiceImpl();
                    return method.invoke(realSubject, args);
                });

        bookService.rent(new Book("오민호의 음악앨범"));
    }
}
