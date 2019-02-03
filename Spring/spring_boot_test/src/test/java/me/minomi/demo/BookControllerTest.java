package me.minomi.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-03.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Test
    public void booksTest() throws Exception {
        Book book = Book.builder()
                .idx(1)
                .title("spring test")
                .build();

        given(bookService.getList())
                .willReturn(Collections.singletonList(book));

        mockMvc.perform(get("/books"))
                .andExpect(view().name("book")) // 반환되는 view 이름이 "book" 인가
                .andExpect(model().attributeExists("books")) // model 객체에 이름이 books 인 프로퍼티가 있는가
                .andExpect(model().attribute("books", contains(book))); // books 프로퍼티에는 book 객체를 포함하는가

    }

}