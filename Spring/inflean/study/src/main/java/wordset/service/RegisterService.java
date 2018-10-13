package wordset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import wordset.dao.WordDao;
import wordset.dto.WordSet;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class RegisterService {

    @Autowired
    @Qualifier(value = "usedDao")
    private WordDao wordDao;

    public RegisterService() {}

    public void wordRegister(WordSet wordSet) {
        String key = wordSet.getKey();
        if (verify(key)) {
            wordDao.insert(wordSet);
            return;
        }
        System.out.println("Verified Word Register");
    }


    private boolean verify(String key) {
        return wordDao.select(key) == null;
    }
}
