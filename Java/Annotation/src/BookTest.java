import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-02.
 */

public class BookTest {

    private Book book;
    private StringInjectionContainer stringInjectionContainer = new StringInjectionContainer();

    @Before
    public void setUp() throws InstantiationException, IllegalAccessException {
        book = stringInjectionContainer.get(Book.class);;
    }

    @Test
    public void 책의_제목은_자바입문_이어야한다() {
        assertEquals("자바 입문", book.getTitle());
    }

    @Test
    public void 책의_isbn은_123412341234_이어야한다() {
        assertEquals("1234-1234-1234", book.getIsbn());
    }

    @Test
    public void 책의_출판사는_용문사_이어야한다() {
        assertEquals("용문사", book.getPublisher());
    }
}