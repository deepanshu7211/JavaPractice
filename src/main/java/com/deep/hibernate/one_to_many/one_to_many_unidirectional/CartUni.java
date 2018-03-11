package com.deep.hibernate.one_to_many.one_to_many_unidirectional;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 28/04/16.
 */

@Entity
@Table(name = "CartUni")
public class CartUni {

    @Id
    @Column(name = "cart_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "total")
    private double total;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @JoinTable(name = "cartUni_item",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<ItemUni> itemUnis;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ItemUni> getItemUnis() {
        return itemUnis;
    }

    public void setItemUnis(Set<ItemUni> itemUnis) {
        this.itemUnis = itemUnis;
    }
}
