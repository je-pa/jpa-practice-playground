package study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PkTest {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("playground");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Movie movie1 = new Movie();
            movie1.setMovieName("타이타닉");
            em.persist(movie1);

            Movie movie2 = new Movie();
            movie2.setMovieName("오징어게임");
            em.persist(movie2);

            System.out.println("================");
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
