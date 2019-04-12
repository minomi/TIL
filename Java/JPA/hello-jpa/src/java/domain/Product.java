package domain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-04-11.
 */
@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Order order;

    private String name;

    private Integer price;

    private Integer stockAmount;

    public Product() {}

    public Product(String name, Integer price, Integer stockAmount) {
        this.name = name;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
