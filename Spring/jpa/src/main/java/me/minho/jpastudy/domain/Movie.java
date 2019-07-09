package me.minho.jpastudy.domain;

import me.minho.jpastudy.domain.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-06.
 */

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
    private String director;
    private String actor;
}
