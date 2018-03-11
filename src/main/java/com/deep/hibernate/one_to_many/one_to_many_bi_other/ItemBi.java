package com.deep.hibernate.one_to_many.one_to_many_bi_other;

import javax.persistence.*;

/**
 * Created by deepanshu.saxena on 26/05/16.
 */

@Entity
@Table(name = "itemBi")
public class ItemBi {

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private CartBi cartBi;


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

    public CartBi getCartBi() {
        return cartBi;
    }

    public void setCartBi(CartBi cartBi) {
        this.cartBi = cartBi;
    }
}
