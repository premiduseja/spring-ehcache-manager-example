package eg.code.fun.spring.ehcache.manager.controllers;

import eg.code.fun.spring.ehcache.manager.models.Employee;
import eg.code.fun.spring.ehcache.manager.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employeeId/{id}")
    public HttpEntity<Employee> getEmployeeByFirstName(@PathVariable("id") Long employeeId){
        Optional <Employee> optionalEmployee = employeeService.getEmployeeById(employeeId);
        return optionalEmployee.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    @GetMapping("/all")
    List<Employee> allEmployees(){
        return employeeService.getAllEmployees();
    }


    @PostMapping("/add")
    HttpEntity<Long> saveEmployee(@RequestBody Employee employee){
        HttpEntity<Long> response = null;

        try{
            response = new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);

        }catch (Exception e){
            log.error(e.getMessage());
            log.error(e.fillInStackTrace().toString());
            response = new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }

        return response;
    }

}
