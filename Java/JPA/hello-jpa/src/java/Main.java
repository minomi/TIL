import domain.Member;
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
//            logic(entityManager);
            testMemberAndTeam(entityManager);
//            queryLoginJoin(entityManager);
//            biDirection(entityManager);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

    private static void biDirection(EntityManager entityManager) {
        Team myTeam = entityManager.find(Team.class, "myTeam");
        List<Member> members = myTeam.getMembers();
        members.forEach(member -> System.out.println(member.getId()));
    }

    private static void testMemberAndTeam(EntityManager entityManager) {
        Team myTeam = new Team("myTeam", "myTeam");
        entityManager.persist(myTeam);

        Member minho = new Member();
        minho.setId("minho");
        minho.setUserName("minho");
        minho.setTeam(myTeam);
        entityManager.persist(minho);


        Member hyejung = new Member();
        hyejung.setId("hyejung");
        hyejung.setUserName("hyejung");
        hyejung.setTeam(myTeam);
        entityManager.persist(hyejung);

        Team minhoTeam = minho.getTeam();
        Team hyejungTeam = hyejung.getTeam();

        System.out.println("minho 의 팀은 ? : " + minhoTeam.getId());
        System.out.println("hyejung 의 팀은 ? : " + hyejungTeam.getId());
    }

    private static void queryLoginJoin(EntityManager entityManager) {
        String jpql1 = "select m from Member m join m.team t where t.name=:teamName";
        List<Member> resultList = entityManager.createQuery(jpql1, Member.class)
                .setParameter("teamName", "myTeam")
                .getResultList();

        resultList.forEach(member -> System.out.println(member.getId()));
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
