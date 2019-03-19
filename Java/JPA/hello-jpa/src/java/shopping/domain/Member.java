package shopping.domain;

import javax.persistence.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-20.
 */

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String street;

    private String zipCode;
}
