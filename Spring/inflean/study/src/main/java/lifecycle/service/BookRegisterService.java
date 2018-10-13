package lifecycle.service;

import lifecycle.dao.BookDao;
import lifecycle.dto.Book;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class BookRegisterService implements InitializingBean, DisposableBean {

    @Autowired
    private BookDao bookDao;

    public void register(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BookRegisterService Destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BookRegisterService Init");
    }
}
