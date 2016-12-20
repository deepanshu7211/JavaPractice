package hibernate.many_to_many.bidirectional;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 26/05/16.
 */

@Entity
@Table(name = "Item2_M_M_B")
public class Item2Bi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "item_total")
    private double itemTotal;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(mappedBy = "item2s")
    private Set<Cart2Bi> cart2Bis;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Cart2Bi> getCart2Bis() {
        return cart2Bis;
    }

    public void setCart2Bis(Set<Cart2Bi> cart2Bis) {
        this.cart2Bis = cart2Bis;
    }
}
