package study.order2;

import javax.persistence.*;

@Entity
public class Item2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_NO_ID")
    private Long id;
    private String name;
    private int price;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "PURCHASE_ORDER_ID")
    //private PurchaseOrder order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public PurchaseOrder getOrder() {
//        return order;
//    }
//
//    public void setOrder(PurchaseOrder order) {
//        this.order = order;
//    }
}
