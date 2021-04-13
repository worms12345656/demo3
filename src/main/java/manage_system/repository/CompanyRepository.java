package manage_system.repository;

import java.util.List;
import java.util.Optional;

import manage_system.entities.Company;
import manage_system.entities.Service;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {

	Iterable<Company> findByTenCongTyContaining(String name);
}