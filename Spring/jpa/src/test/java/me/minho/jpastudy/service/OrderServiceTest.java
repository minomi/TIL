package me.minho.jpastudy.service;

import me.minho.jpastudy.NotEnoughStockException;
import me.minho.jpastudy.domain.*;
import me.minho.jpastudy.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-09.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void 상품주문() {
        Member member = createMember();
        Item item = createBook("DB", 20000, 10);
        int orderCount = 5;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getOrderStatus());
        assertEquals(1, getOrder.getOrderItems().size());
        assertEquals(item.getPrice() * orderCount, getOrder.getTotalPrice());
        assertEquals(orderCount, item.getStockQuantity());

    }

    @Test(expected = NotEnoughStockException.class)
    public void 재고수량_초과_테스트() {
        Member member = createMember();
        Item item = createBook("DB", 20000, 10);
        int orderCount = 11;

        orderService.order(member.getId(), item.getId(), orderCount);

        fail("싈패");
    }

    @Test
    public void 주문취소() {
        Member member = createMember();
        Item item = createBook("DB", 20000, 10);
        int orderCount = 3;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
        orderService.cancel(orderId);
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("주문 취소 상태는 CANCEL", OrderStatus.CANCEL, getOrder.getOrderStatus());
        assertEquals("재고 수량 롤백", 10, item.getStockQuantity());
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원");
        member.setAddress(new Address("seoul", "mokdong-center", "123-234"));
        entityManager.persist(member);
        return member;
    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        entityManager.persist(book);
        return book;
    }
}