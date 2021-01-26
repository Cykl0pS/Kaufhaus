package workloads.Employee;

import model.EmployeeDTO;
import model.UpdateSalary;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) { this.employeeRepository = employeeRepository; }

    public boolean addEmployee(EmployeeDTO newEmployee) {
        var existingPerson = employeeRepository.getEmployeesById(newEmployee.getId());
        if (existingPerson != null) {
            return false;
        }

        var employee = new Employee();
        employee.setDateOfBirth(newEmployee.getDateOfBirth());
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setSalary(newEmployee.getSalary());
        employeeRepository.addEmployee(employee);
        return true;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.getEmployeesById(id);
    }

    public boolean updateSalary(Long id, UpdateSalary salary) {
        if(salary.getSalary() < 0)
            return false;

        employeeRepository.updateSalary(id, salary.getSalary());
        return true;
    }

    public boolean removeEmployee(Long id){
        var employee = employeeRepository.getEmployeesById(id);
        if(employee == null)
            return false;

        employeeRepository.removeEmployee(employee);
        return true;
    }
}
