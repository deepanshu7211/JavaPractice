package hibernate.one_to_many;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 17/02/16.
 */

@Entity
@Table(name = "Cart_O_M")
public class Cart1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    @Column(name = "total")
    private double total;

    @Column(name = "name")
    private String name;


//    @OneToMany    without mapped by created new table 3rd table

    @OneToMany(mappedBy = "cart1")
    @Cascade(CascadeType.ALL)
    private Set<Item1> item1;


    public Set<Item1> getItem1() {
        return item1;
    }

    public void setItem1(Set<Item1> item1) {
        this.item1 = item1;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
