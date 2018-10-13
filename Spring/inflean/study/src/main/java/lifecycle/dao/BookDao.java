package lifecycle.dao;

import lifecycle.dto.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class BookDao {
    private Map<String, Book> db = new HashMap<>();

    public void insert(Book book) {
        db.put(book.getId(), book);
    }

    public Book select(String id) {
        return db.get(id);
    }
}
