package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-11.
 */

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "orders_id")
    private Long id;

    private Integer orderAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

    public Order() {}

    public Order(Integer orderAmount, Member member) {
        this.orderAmount = orderAmount;
        this.member = member;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
