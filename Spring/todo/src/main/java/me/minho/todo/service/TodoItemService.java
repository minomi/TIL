package me.minho.todo.service;

import lombok.RequiredArgsConstructor;
import me.minho.todo.domain.TodoItem;
import me.minho.todo.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-20.
 */
@Service
@RequiredArgsConstructor
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;

    public List<TodoItem> findAll() {
        return todoItemRepository.findAll();
    }
}
