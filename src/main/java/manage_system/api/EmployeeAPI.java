package manage_system.api;

import manage_system.entities.Employee;
import manage_system.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/employee", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeAPI {

  @Autowired
  private EmployeeRepository employeeRepo;
  @Autowired
  EntityLinks entityLinks;

  @GetMapping("/list")
  public Iterable<Employee> getListEmployee() {
    return employeeRepo.findAll();
  }

  @GetMapping("/edit/{id}")
  public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
    Optional<Employee> employeeSearch = employeeRepo.findById(id);
    return employeeSearch;
  }

  @PostMapping("/save")
  public String SaveEmployee(@RequestBody Employee employee) {
    employeeRepo.save(employee);
    return "saved";
  }

  @PostMapping("/delete/{id}")
  public String DeleteEmployee(@PathVariable("id") Long id) {
    employeeRepo.deleteById(id);
    return "deleted";
  }

  @GetMapping("/search/{keyword}")
  public Iterable<Employee> getCompanyByName(@PathVariable("keyword") String keyword) {
    Iterable<Employee> employeeSearch = employeeRepo.findByTenNhanVienContaining(keyword);
    return employeeSearch;
  }

}
