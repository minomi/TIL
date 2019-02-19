package me.minomi.jpaandbatchstudy.accounts;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-20.
 */

@Entity
@EqualsAndHashCode
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String password;
}
