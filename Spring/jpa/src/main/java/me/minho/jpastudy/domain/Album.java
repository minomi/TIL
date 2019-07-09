package me.minho.jpastudy.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-06.
 */

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
    private String etc;
}
