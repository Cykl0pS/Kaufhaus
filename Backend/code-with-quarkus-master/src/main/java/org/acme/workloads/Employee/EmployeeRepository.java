package workloads.Employee;

import workloads.Customer.Customer;
import workloads.Delivery.Delivery;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class EmployeeRepository {

    private final EntityManager entityManager;

    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Employee getEmployeesById(Long id) {
        var query = entityManager.createQuery("select e from Employee e where e.Id = :id", Employee.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> getAllEmployees() {
        var query = entityManager.createQuery("select e from Employee e", Employee.class);
        return query.getResultList();
    }
    public void updateSalary(Long id, Double salary) {
        Employee emp = getEmployeesById(id);
        emp.setSalary(salary);
        entityManager.merge(emp);
    }

    public void removeEmployee(Employee employee){entityManager.remove(employee);}
}
