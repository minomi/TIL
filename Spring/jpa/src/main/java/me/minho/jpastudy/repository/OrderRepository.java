package me.minho.jpastudy.repository;

import me.minho.jpastudy.domain.Member;
import me.minho.jpastudy.domain.Order;
import me.minho.jpastudy.domain.OrderSearch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-09.
 */

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Order order) {
        entityManager.persist(order);
    }

    public Order findOne(Long id) {
        return entityManager.find(Order.class, id);
    }

    public List<Order> findAll(OrderSearch orderSearch) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> orderRoot = cq.from(Order.class);

        List<Predicate> predicates = new ArrayList<>();

        if (orderSearch.getOrderStatus() != null) {
            Predicate statusPredicate = cb.equal(orderRoot.get("status"), orderSearch.getOrderStatus());
            predicates.add(statusPredicate);
        }

        if (orderSearch.getName() != null) {
            Join<Order, Member> m = orderRoot.join("member", JoinType.INNER);
            Predicate namePredicate = cb.like(m.get("name"), "%" + orderSearch.getName() + "%");
            predicates.add(namePredicate);
        }

        cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        TypedQuery<Order> query = entityManager.createQuery(cq).setMaxResults(1000);
        return query.getResultList();
    }
}
