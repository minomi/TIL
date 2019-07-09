package me.minho.jpastudy.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-05.
 */

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String city;
    private String street;
    private String zipCode;

}
