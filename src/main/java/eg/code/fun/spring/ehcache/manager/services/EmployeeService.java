package eg.code.fun.spring.ehcache.manager.services;

import eg.code.fun.spring.ehcache.manager.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    /**
     * Gets employee information by id
     * @param employeeId Employee id
     * @return Optional Employee Object
     */
    Optional<Employee> getEmployeeById(Long employeeId);

    /**
     * Provides the list of all employees
     * @return List of all employees
     */
    List<Employee> getAllEmployees();

    /**
     * Method to save employee
     * @param employee - Employee object
     * @return employeeId
     */
    Long saveEmployee(Employee employee);

}
