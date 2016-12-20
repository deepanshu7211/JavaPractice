package hibernate.one_to_one.using_mapped_by;

import javax.persistence.*;

/**
 * Created by deepanshu.saxena on 26/05/16.
 */

@Entity
@Table(name = "customerm")
public class CustomerM {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cust_name")
    private String name;

    @Column(name = "cust_email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "txn", referencedColumnName = "txn_id")
    private TxnM txn;

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

    public TxnM getTxn() {
        return txn;
    }

    public void setTxn(TxnM txn) {
        this.txn = txn;
    }
}
