package com.deep.hibernate.many_to_many.bidirectional;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 26/05/16.
 */
@Entity
@Table(name = "Cart2_M_M_B")
public class Cart2Bi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "total")
    private double total;

    @Column(name = "name")
    private String name;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Cart_item_2",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item2Bi> item2s;

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

    public Set<Item2Bi> getItem2s() {
        return item2s;
    }

    public void setItem2s(Set<Item2Bi> item2s) {
        this.item2s = item2s;
    }
}
