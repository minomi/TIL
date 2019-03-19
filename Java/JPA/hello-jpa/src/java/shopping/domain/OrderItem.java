package shopping.domain;

import javax.persistence.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-20.
 */

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "ITEM_ID")
    private Long itemId;

    private int orderPrice;

    private int count;


}
