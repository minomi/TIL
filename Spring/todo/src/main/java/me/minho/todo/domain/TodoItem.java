package me.minho.todo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-19.
 */

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
    @Id @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private boolean done;

    private LocalDateTime registerDate;
}
