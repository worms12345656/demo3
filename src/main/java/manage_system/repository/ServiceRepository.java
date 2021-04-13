package manage_system.repository;

import manage_system.entities.Service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Long> {

  public List<Service> findByLoaiDichVuContaining(String lvdString);

  public List<Service> findByLoaiDichVu(String lvdString);

  public Iterable<Service> findByTenDichVu(String keyword);
}