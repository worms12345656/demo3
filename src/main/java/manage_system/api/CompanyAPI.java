package manage_system.api;

import manage_system.entities.Company;
import manage_system.entities.Service;
import manage_system.repository.CompanyRepository;
import manage_system.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/api/company", produces = "application/json")
@CrossOrigin(origins = "*")
public class CompanyAPI {

  @Autowired
  private CompanyRepository companyRepo;
  @Autowired
  private ServiceRepository serviceRepo;
  @Autowired
  EntityLinks entityLinks;

  @GetMapping("/list")
  public Iterable<Company> getListCompany() {
    return companyRepo.findAll();
  }

  @GetMapping("/edit/{id}")
  public Optional<Company> getCompanyById(@PathVariable("id") Long id) {
    Optional<Company> companySearch = companyRepo.findById(id);
    return companySearch;
  }

  @PostMapping("/save")
  public String SaveCompany(@RequestBody Company company) {
    List<Service> servicesBv = serviceRepo.findByLoaiDichVu("Bắt buộc");
    company.setServices(servicesBv);
    companyRepo.save(company);
    return "saved";
  }

  @PostMapping("/delete/{id}")
  public String DeleteCompany(@PathVariable("id") Long id) {
    companyRepo.deleteById(id);
    return "deleted";
  }

  @GetMapping("/search/{keyword}")
  public Iterable<Company> getCompanyByName(@PathVariable("keyword") String keyword) {
    Iterable<Company> companySearch = companyRepo.findByTenCongTyContaining(keyword);
    return companySearch;
  }

}