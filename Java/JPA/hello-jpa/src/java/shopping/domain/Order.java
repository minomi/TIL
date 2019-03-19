package shopping.domain;

import shopping.domain.enums.OrderStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-20.
 */

@Entity
@Table(schema = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
