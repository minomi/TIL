package me.minho.todo.repository;

import me.minho.todo.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-19.
 */
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
