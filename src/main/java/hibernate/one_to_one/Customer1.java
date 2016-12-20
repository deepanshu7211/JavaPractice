package hibernate.one_to_one;

import javax.persistence.*;

/**
 * Created by deepanshu.saxena on 17/02/16.
 */

@Entity
@Table(name = "customer")
public class Customer1 {
    @Id
    @Column(name = "cust_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cust_name")
    private String name;

    @Column(name = "cust_email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)   // It means to Join Customer with Txn Table
    @JoinColumn(name = "txn", referencedColumnName = "txn_id")
    // To give name to Join Column  and reference column should be with database table column name
    private Txn1 txn1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Txn1 getTxn1() {
        return txn1;
    }

    public void setTxn1(Txn1 txn1) {
        this.txn1 = txn1;
    }
}
