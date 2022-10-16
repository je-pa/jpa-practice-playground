package study.order2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderTest {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("playground");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Item2 item1 = new Item2();
            item1.setName("치킨");
            Item2 item2 = new Item2();
            item2.setName("치즈볼");

            PurchaseOrder2 order = new PurchaseOrder2();
            order.setUserName("kim");
            order.getItems().add(item1);
            order.getItems().add(item2);

            em.persist(item1); //JoinColumn 위해 먼저
            em.persist(item2);
            em.persist(order);

            System.out.println("================");

            em.flush();//중간에 반영
            em.clear();

            PurchaseOrder2 findOrder = em.find(PurchaseOrder2.class, 1L);
            findOrder.getItems().remove(0);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
