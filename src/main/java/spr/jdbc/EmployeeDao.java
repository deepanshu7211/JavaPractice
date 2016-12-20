package spr.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by deepanshu.saxena on 01/03/16.
 */
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveEmployee(Employee e) {
        String query = "insert into EmployeeSpr values(NULL,'" + e.getName() + "'," + e.getSalary() + ")";
        return jdbcTemplate.update(query);
    }

    public int updateEmployee(Employee e) {
        String query = "update EmployeeSpr set name='" + e.getName() + "',salary='" + e.getSalary() + "' where id='" + e.getId() + "' ";
        return jdbcTemplate.update(query);
    }

    public int deleteEmployee(Employee e) {
        String query = "delete from EmployeeSpr where id='" + e.getId() + "' ";
        return jdbcTemplate.update(query);
    }

    public List<Employee> getAllEmployeesRowMapper() {
        return jdbcTemplate.query("select * from EmployeeSpr", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setSalary(resultSet.getInt(3));
                return employee;
            }
        });
    }
}
