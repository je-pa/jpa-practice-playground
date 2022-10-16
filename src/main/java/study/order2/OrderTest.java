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
            Item item1 = new Item();
            item1.setName("치킨");
            Item item2 = new Item();
            item2.setName("치즈볼");

            PurchaseOrder order = new PurchaseOrder();
            order.setUserName("kim");
            order.getItems().add(item1);
            order.getItems().add(item2);

            item1.setOrder(order);
            item2.setOrder(order);

            em.persist(order);
            em.persist(item1);
            em.persist(item2);

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
