package eg.code.fun.spring.ehcache.manager.repository;

import eg.code.fun.spring.ehcache.manager.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@SuppressWarnings({"nonNullApi"})
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    Optional<Employee> findById(Long employeeId);
    List<Employee> findAll();
}
