package me.minho.jpastudy.domain;

import lombok.Getter;
import org.springframework.scheduling.config.AnnotationDrivenBeanDefinitionParser;

import javax.persistence.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-06.
 */
@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    @Getter
    private DeliveryStatus status;


    public Delivery(Address address) {
        this.address = address;
    }
}
