package hibernate.many_to_many;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 18/02/16.
 */

@Entity
@Table(name = "Cart2_M_M")
public class Cart2 {
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
    private Set<Item2> item2s;


    public Set<Item2> getItem2s() {
        return item2s;
    }

    public void setItem2s(Set<Item2> item2s) {
        this.item2s = item2s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
