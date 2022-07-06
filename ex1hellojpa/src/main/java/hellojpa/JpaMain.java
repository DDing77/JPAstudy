package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

// 스프링 미 사용시
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        //code
        tx.begin();

        try{

            Member findMember = em.find(Member.class, 150L);
            findMember.setName("ZZZZZ");

            System.out.println("=================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 꼭 엔티티매니저 사용 후 닫아주기
        }
        
        emf.close();
    }
}
