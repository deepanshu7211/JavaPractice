package hibernate.one_to_one;

import javax.persistence.*;

/**
 * Created by deepanshu.saxena on 17/02/16.
 */

@Entity
@Table(name = "Transaction")
public class Txn1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_id")
    private long id;


    @Column(name = "txn_total")
    private double total;


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
