package me.minho.jpastudy.domain;

import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-06.
 */

@Entity
@DiscriminatorValue("B")
public class Book extends Item {
    @Setter
    private String author;
    @Setter
    private String isbn;
}
