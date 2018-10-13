package wordset;

import org.springframework.context.support.GenericXmlApplicationContext;
import wordset.dto.WordSet;
import wordset.service.RegisterService;
import wordset.service.SearchService;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:wordset_ctx.xml");
        SearchService searchService = ctx.getBean("searchService", SearchService.class);
        RegisterService registerService = ctx.getBean("registerService", RegisterService.class);

        String[] keys = {"key1", "key2", "key3"};
        String[] values = {"value1", "value2", "value3"};

        for (int i = 0 ; i < keys.length ; i++) {
            registerService.wordRegister(new WordSet(keys[i], values[i]));
        }

        System.out.println("-------------------------");

        for (String key : keys) {
            WordSet wordSet = searchService.search(key);
            System.out.println(wordSet.getKey() + " : " + wordSet.getValue());
        }

        System.out.println("-------------------------");
    }
}
