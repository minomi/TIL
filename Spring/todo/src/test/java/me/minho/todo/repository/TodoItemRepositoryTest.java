package me.minho.todo.repository;

import me.minho.todo.domain.TodoItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-19.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TodoItemRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Test
    public void 빈_주입_잘되는지_테스트() {
        assertNotNull(todoItemRepository);
        assertNotNull(testEntityManager);
    }

    @Test
    public void 저장_잘되는지_테스트() {
        TodoItem todoItem = TodoItem.builder()
                .content("content")
                .title("title")
                .build();

        testEntityManager.persist(todoItem);
        testEntityManager.flush();

        TodoItem saveTodoItem = todoItemRepository.findById(todoItem.getId()).orElseThrow();
        assertThat(saveTodoItem, is(todoItem));
    }
}