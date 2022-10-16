package study.book;

import study.order.Item;
import study.order.PurchaseOrder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookTest {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("playground");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Manuscript manuscript = new Manuscript();
            Book book = new Book();
            book.setISBN("ABCDEFG12");
            book.setManuscript(manuscript);//참조를
            manuscript.setBook(book);//걸어준다

            em.persist(manuscript); //child 먼저
            em.persist(book); // Book이 FK 관리해서 부모임
//            em.flush();
//            em.clear();
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
