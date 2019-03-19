import domain.Member;
import javassist.compiler.MemberCodeGen;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
            logic(entityManager);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

    private static void logic(EntityManager entityManager) {
        Member minho = new Member();
        minho.setId("minho");
        minho.setUserName("민호");
        minho.setAge(2);

        Member minhoCopy = new Member();
        minho.setId("minhoCopy");
        minho.setUserName("민호");
        minho.setAge(2);

        // insert
        entityManager.persist(minho);
        entityManager.persist(minhoCopy);


        // select
        Member findMember = entityManager.find(Member.class, "minho");
        System.out.println("findMember = " + findMember.getUserName() + " , age = " + findMember.getAge());

        // select All
        List<Member> members = entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
        System.out.println("members.size= " + members.size());

        entityManager.remove(minho);
    }
}
