package eg.code.fun.spring.ehcache.manager.services.impl;

import eg.code.fun.spring.ehcache.manager.models.Employee;
import eg.code.fun.spring.ehcache.manager.repository.EmployeeRepository;
import eg.code.fun.spring.ehcache.manager.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings({"neverUsed"})
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Gets employee record using employee id
     * @param employeeId Long type employee id allocated to the employee
     * @return Employee record.
     */
    @Override
    @Cacheable(value = "employeeCache", cacheManager = "ehCacheManager")
    public Optional<Employee> getEmployeeById(Long employeeId) {
        log.debug("===> Now hitting the database to pull the employee by id <===");
        return employeeRepository.findById(employeeId);
    }

    /**
     * Gets the list of all employees from the database
     * @return Array List of Employees
     */
    @Override
    @Cacheable(value = "employeeCache", cacheManager = "ehCacheManager")
    public List<Employee> getAllEmployees() {
        log.debug(" ===> Now hitting the database to pull all the employees <===");
        return employeeRepository.findAll();
    }

    @Override
    public Long saveEmployee(Employee employee) {
        return employeeRepository.save(employee).getId();
    }
}
