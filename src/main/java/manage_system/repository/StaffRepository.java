package manage_system.repository;

import manage_system.entities.Staff;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff, Long> {

	Iterable<Staff> findByTenNVToaNhaContaining(String keyword);

}