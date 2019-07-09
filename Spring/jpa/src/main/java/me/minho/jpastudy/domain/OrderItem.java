package me.minho.jpastudy.domain;

import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-05.
 */

@Entity
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    @Setter
    private Item item;

    @Setter
    private Integer orderPrice;

    @Setter
    private Integer count;

    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    public void cancel() {
        item.addStock(count);
    }

    public Integer getTotalPrice() {
        return count * orderPrice;
    }
}
