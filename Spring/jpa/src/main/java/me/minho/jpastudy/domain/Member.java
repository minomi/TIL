package me.minho.jpastudy.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-05.
 */

@Entity
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue
    @Getter @Column(name = "MEMBER_ID")
    private Long id;

    @Getter @Setter
    private String name;

    @Embedded
    @Getter @Setter
    private Address address;

    @Getter
    @OneToMany(mappedBy = "member")
    List<Order> orders = new ArrayList<>();

}
