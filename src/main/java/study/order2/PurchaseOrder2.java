package study.order2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PurchaseOrder2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PURCHASE_ORDER_ID")
    private Long id;

    private String userName;

    @OneToMany()//mappedBy = "order" 제거 - 양방향 x
    @JoinColumn(name="PURCHASE_ORDER_ID")
    private List<Item2> items = new ArrayList<Item2>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Item2> getItems() {
        return items;
    }

    public void setItems(List<Item2> items) {
        this.items = items;
    }
}
