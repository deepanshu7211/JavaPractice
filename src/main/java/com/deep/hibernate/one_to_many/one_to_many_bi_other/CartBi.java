package com.deep.hibernate.one_to_many.one_to_many_bi_other;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 26/05/16.
 */

@Entity
@Table(name = "cartBi")
public class CartBi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "total")
    private double total;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Set<ItemBi> item1;

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

    public Set<ItemBi> getItem1() {
        return item1;
    }

    public void setItem1(Set<ItemBi> item1) {
        this.item1 = item1;
    }
}
