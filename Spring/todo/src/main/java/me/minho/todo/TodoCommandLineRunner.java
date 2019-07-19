package me.minho.todo;

import lombok.AllArgsConstructor;
import me.minho.todo.domain.TodoItem;
import me.minho.todo.repository.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-20.
 */

@Component
@AllArgsConstructor
public class TodoCommandLineRunner implements CommandLineRunner {

    private TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        List<TodoItem> todoItems = IntStream.range(1, 101)
                .mapToObj((i) -> TodoItem.builder()
                        .title("title" + i)
                        .content("content" + i)
                        .done(i % 2 == 0)
                        .registerDate(LocalDateTime.now()).build())
                .collect(Collectors.toList());
        todoItemRepository.saveAll(todoItems);
    }
}
