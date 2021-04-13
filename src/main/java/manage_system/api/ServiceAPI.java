package manage_system.api;

import manage_system.entities.Service;
import manage_system.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/service", produces = "application/json")
@CrossOrigin(origins = "*")
public class ServiceAPI {

    @Autowired
    private ServiceRepository serviceRepo;
    @Autowired
    EntityLinks entityLinks;

    @GetMapping("/list")
    public Iterable<Service> getListService() {
        return serviceRepo.findAll();
    }

    @GetMapping("/edit/{id}")
    public Optional<Service> getServiceById(@PathVariable("id") Long id) {
        Optional<Service> serviceSearch = serviceRepo.findById(id);
        return serviceSearch;
    }

    @PostMapping("/save")
    public String SaveService(@RequestBody Service service) {
        serviceRepo.save(service);
        return "saved";
    }

    @PostMapping("/delete/{id}")
    public String DeleteService(@PathVariable("id") Long id) {
        serviceRepo.deleteById(id);
        return "deleted";
    }

    @GetMapping("/search/{keyword}")
    public Iterable<Service> getServiceByName(@PathVariable("keyword") String keyword) {
    Iterable<Service> serviceSearch = serviceRepo.findByLoaiDichVuContaining(keyword);
    return serviceSearch;
  }

}
