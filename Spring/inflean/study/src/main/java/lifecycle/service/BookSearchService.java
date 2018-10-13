package lifecycle.service;

import lifecycle.dao.BookDao;
import lifecycle.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class BookSearchService {

    @Autowired
    private BookDao bookDao;

    public Book search(String id) {
        return bookDao.select(id);
    }

    public void initMethod() {
        System.out.println("BookSearchService Init");
    }

    public void destroyMethod() {
        System.out.println("BookSearchService Destroy");
    }
}
