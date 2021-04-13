package manage_system.repository;

import java.util.List;
import manage_system.entities.Company;
import manage_system.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  public Iterable<Employee> findBycongty_Id(Long Id);

  public Iterable<Employee> findByTenNhanVienContaining(String keyword);

}
