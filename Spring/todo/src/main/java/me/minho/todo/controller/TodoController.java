package me.minho.todo.controller;

import lombok.RequiredArgsConstructor;
import me.minho.todo.domain.TodoItem;
import me.minho.todo.service.TodoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-20.
 */

@RequestMapping("/todo-items")
@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoItemService todoItemService;

    @GetMapping
    public ResponseEntity<TodoItems> getTodoItems() {
        return ResponseEntity.ok(new TodoItems(todoItemService.findAll()));
    }

}
