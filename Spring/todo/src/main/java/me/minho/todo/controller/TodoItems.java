package me.minho.todo.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.minho.todo.domain.TodoItem;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-20.
 */
@AllArgsConstructor
@Getter
public class TodoItems {
    private List<TodoItem> todoItems;
}