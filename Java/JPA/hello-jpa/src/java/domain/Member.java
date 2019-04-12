package domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-19.
 */

@Entity
@Table
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "member_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Order> orders = new ArrayList<>();

    private String userName;

    private Integer age;

    public Member() {}

    public Member(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
