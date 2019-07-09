package me.minho.jpastudy.domain;

import lombok.Getter;
import lombok.Setter;
import me.minho.jpastudy.NotEnoughStockException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-06.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {

    @Id @GeneratedValue
    @Getter
    @Column(name = "ITEM_ID")
    private Long id;

    @Setter
    private String name;

    @Setter
    @Getter
    private int price;

    @Getter
    @Setter
    private int stockQuantity;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<CategoryItem> categoryItems = new ArrayList<>();

    public void addStock(Integer quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(Integer quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException();
        }
        this.stockQuantity = restStock;
    }
}
