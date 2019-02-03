package me.minomi.demo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-03.
 */

@Data
@NoArgsConstructor
public class Book {
    private Integer idx;
    private String title;

    @Builder
    public Book(Integer idx, String title) {
        this.idx = idx;
        this.title = title;
    }
}
