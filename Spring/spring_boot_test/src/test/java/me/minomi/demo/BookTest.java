package me.minomi.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-03.
 */
@RunWith(SpringRunner.class)
@JsonTest
public class BookTest {

    @Autowired
    JacksonTester<Book> bookJacksonTester;

    @Test
    public void book_json_test() throws Exception {
        Book book = Book.builder()
                .title("spring test")
                .build();

        String jsonContent = "{\"title\":\"spring test\"}";

        assertThat(bookJacksonTester.parseObject(jsonContent)
                .getTitle())
                .isEqualTo(book.getTitle());

        assertThat(bookJacksonTester.parseObject(jsonContent)
                .getIdx())
                .isNull();

        assertThat(bookJacksonTester.write(book))
                .hasJsonPathStringValue("title");

        assertThat(bookJacksonTester.write(book))
                .extractingJsonPathStringValue("title")
                .isEqualTo("spring test");
    }

}