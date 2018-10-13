package wordset.dao;

import wordset.dto.WordSet;

import java.util.HashMap;
import java.util.Map;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */

public class WordDao {
    private Map<String, WordSet> db = new HashMap<>();

    public WordSet select(String keyword) {
        return db.get(keyword);
    }

    public void insert(WordSet wordSet) {
        db.put(wordSet.getKey(), wordSet);
    }

}
