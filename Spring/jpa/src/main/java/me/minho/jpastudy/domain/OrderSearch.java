package me.minho.jpastudy.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-09.
 */

@Getter
@Setter
public class OrderSearch {
    private OrderStatus orderStatus;
    private String name;
}
