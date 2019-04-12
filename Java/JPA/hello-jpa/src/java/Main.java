import com.querydsl.jpa.impl.JPAQuery;
import domain.Member;
import domain.Order;
import domain.Product;
import domain.Team;

import javax.persistence.*;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-19.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("h2_persistence_unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();

        try {
            tx.begin();
            insertMembers(entityManager);
            jpqlExam1(entityManager);
            jpqlExam2(entityManager);
            jpqlExam3(entityManager);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

    private static void jpqlExam3(EntityManager entityManager) {
        String jpql = "select p.order from Product as p";
        TypedQuery<Order> orderTypedQuery = entityManager.createQuery(jpql, Order.class);
        orderTypedQuery.getResultList().forEach(order -> {
            System.out.println(order);
        });
    }

    private static void jpqlExam2(EntityManager entityManager) {
        String jpql = "select m.team from Member as m";
        TypedQuery<Team> teamTypedQuery = entityManager.createQuery(jpql, Team.class);
        Team team = teamTypedQuery.getSingleResult();
        System.out.println(team);
    }

    private static void jpqlExam1(EntityManager entityManager) {
        String jpql = "select m from Member as m where m.userName = :userName";
        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class)
                .setParameter("userName", "minho");
        List<Member> minhoList = query.getResultList();
        minhoList.forEach(member -> System.out.println(member));
    }

    private static void insertMembers(EntityManager entityManager) {
        Member minho1 = new Member("minho", 1);
        Member minho2 = new Member("minho", 2);
        Member minho3 = new Member("minho",3);

        Team team = new Team("minhoTeam");
        minho1.setTeam(team);
        minho2.setTeam(team);
        minho3.setTeam(team);
        team.addMember(minho1);
        team.addMember(minho2);
        team.addMember(minho3);

        Order order = new Order(3, minho1);
        minho1.addOrder(order);

        Product product = new Product("상품", 1000, 2);
        product.setOrder(order);
        order.addProduct(product);

        entityManager.persist(team);
        entityManager.persist(order);
    }
}
