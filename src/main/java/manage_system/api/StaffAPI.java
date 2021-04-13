package manage_system.api;

import manage_system.entities.Staff;
import manage_system.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/staff", produces = "application/json")
@CrossOrigin(origins = "*")
public class StaffAPI {

    @Autowired
    private StaffRepository staffRepo;
    @Autowired
    EntityLinks entityLinks;

    public StaffAPI(StaffRepository staffRepo) {
        this.staffRepo = staffRepo;
    }

    @GetMapping("/list")
    public Iterable<Staff> getListStaff() {
        return staffRepo.findAll();
    }

    @GetMapping("/edit/{id}")
    public Optional<Staff> getStaffById(@PathVariable("id") Long id) {
        Optional<Staff> staffSearch = staffRepo.findById(id);
        return staffSearch;
    }

    @PostMapping("/save")
    public String SaveStaff(@RequestBody Staff staff) {
        staffRepo.save(staff);
        return "saved";
    }

    @PostMapping("/delete/{id}")
    public String DeleteStaff(@PathVariable("id") Long id) {
        staffRepo.deleteById(id);
        return "deleted";
    }

    @GetMapping("/search/{keyword}")
    public Iterable<Staff> getStaffByName(@PathVariable("keyword") String keyword) {
    Iterable<Staff> staffSearch = staffRepo.findByTenNVToaNhaContaining(keyword);
    return staffSearch;
  }

}