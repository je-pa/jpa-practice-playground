package study.movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        //persistence.xml 파일에서 지정한 설정 정보 이름
        // - persistence-unit name
        // - Factory 가 설정정보 읽도록
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("playground");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Movie movie= new Movie();
            movie.setMovieId(2L);
            movie.setMovieName("오징어게임");
            em.persist(movie); //영속성 컨텍스트에 반영
            tx.commit(); // 실제 DB 반영
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close(); // 자원해제
        }
        emf.close();
    }
}
