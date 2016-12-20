package hibernate.hibernate_save_update;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by deepanshu.saxena on 30/05/16.
 */

@Entity
@Table(name = "employeeS")
public class EmployeEntity {

    @Id
    @Column(name = "emp_id")  // Do not put generated Value tag
    private long id;

    @Column(name = "emp_name")
    private String name;

    public EmployeEntity() {
    }

    public EmployeEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "EmployeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
