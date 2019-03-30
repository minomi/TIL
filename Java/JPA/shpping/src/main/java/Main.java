import domain.Item;
import domain.Member;
import domain.Order;
import domain.OrderItem;
import domain.enums.OrderStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-21.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("jpa_shopping");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            orderLogic(entityManager);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    private static void orderLogic(EntityManager em) {
        Member minho = new Member();
        minho.setCity("seoul");
        minho.setZipCode("944");
        minho.setName("minho");
        minho.setStreet("my street");

        Item macbook = new Item();
        macbook.setName("Mac Book 2018 15 inch CTO");
        macbook.setPrice(6000000);
        macbook.setStockQuantity(1);

        Order order = new Order();
        order.setMember(minho);
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.ORDER);

        OrderItem orderItem = new OrderItem();
        orderItem.setItem(macbook);
        orderItem.setOrder(order);
        orderItem.setCount(2);
        orderItem.setOrderPrice(macbook.getPrice() * 2);

        em.persist(minho);
        em.persist(orderItem);
        em.persist(macbook);
        em.persist(order);
    }
}
