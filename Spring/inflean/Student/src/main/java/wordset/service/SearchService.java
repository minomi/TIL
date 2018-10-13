package wordset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import wordset.dao.WordDao;
import wordset.dto.WordSet;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class SearchService {
    @Autowired
    @Qualifier(value = "usedDao")
    private WordDao wordDao;

    public SearchService() {}

    public WordSet search(String keyword) {
        return wordDao.select(keyword);
    }
}
