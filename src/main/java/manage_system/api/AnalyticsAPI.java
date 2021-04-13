/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_system.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import manage_system.entities.AccessCard;
import manage_system.entities.AccessInformation;
import manage_system.entities.AccessPlace;
import manage_system.entities.CheckInOut;
import manage_system.entities.Company;
import manage_system.entities.Employee;
import manage_system.entities.Service;
import manage_system.entities.Staff;
import manage_system.entities.StaffSalary;
import manage_system.entities.ListComp;
import manage_system.repository.AccessCardRepository;
import manage_system.repository.AccessInformationRepository;
import manage_system.repository.AccessPlaceRepository;
import manage_system.repository.CompanyRepository;
import manage_system.repository.EmployeeRepository;
import manage_system.repository.ServiceRepository;
import manage_system.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping(path = "/api/analytics", produces = "application/json")
@CrossOrigin(origins = "*")
public class AnalyticsAPI {

  private AccessCardRepository accessCardRepo;
  private CompanyRepository companyRepo;
  private ServiceRepository serviceRepo;
  private EmployeeRepository employeeRepo;
  private StaffRepository staffRepo;
  private AccessInformationRepository accessInforRepo;
  private AccessPlaceRepository accessPlaceRepo;
  @Autowired
  EntityLinks entityLinks;

  public AnalyticsAPI(AccessCardRepository accessCardRepo, CompanyRepository companyRepo, ServiceRepository serviceRepo,
      EmployeeRepository employeeRepo, AccessInformationRepository accessInforRepo,
      AccessPlaceRepository accessPlaceRepo, StaffRepository staffRepo) {
    this.accessCardRepo = accessCardRepo;
    this.companyRepo = companyRepo;
    this.serviceRepo = serviceRepo;
    this.employeeRepo = employeeRepo;
    this.accessInforRepo = accessInforRepo;
    this.accessPlaceRepo = accessPlaceRepo;
    this.staffRepo = staffRepo;
  }

  @GetMapping("/company-service-cost")
  public List<ListComp> CompanyServiceCost() {
    List<ListComp> a = new ArrayList<>();
    List<Company> list = (List<Company>) companyRepo.findAll();
    for (Company company : list) {
      ListComp listComp = new ListComp();
      List<Employee> listEmp = (List<Employee>) employeeRepo.findBycongty_Id(company.getId());
      int soNguoi = listEmp.size();
      listComp.setSoNhanVien(soNguoi);
      float dienTich = company.getDienTichMatBang();
      float tongThem = 0;
      if (soNguoi > 10) {
        tongThem += (soNguoi - 10) / 5;
      }
      if (dienTich > 100) {
        tongThem += (dienTich - 100) / 10;
      }
      tongThem = 1 + (tongThem * 5 / 100);
      List<Service> listService = company.getServices();
      Date date = new Date();
      float ngaySuDung = date.getDate();
      float ngayTrongThang = getSoNgayTrongThang(date.getMonth(), date.getYear());
      float tongGia = 0;

      for (Service service : listService) {
        float donGia = service.getDonGia();
        float giaDichVu = (float) (donGia * tongThem) * (ngaySuDung / ngayTrongThang);
        tongGia = giaDichVu + tongGia;
      }
      listComp.setCompany(company);
      listComp.setTienDichVu(tongGia);
      a.add(listComp);
    }
    return a;
  }

  @GetMapping("/check-in-out")
  public List<CheckInOut> checkInOut() {
    List<CheckInOut> a = new ArrayList<>();
    List<Employee> listEmp = (List<Employee>) employeeRepo.findAll();
    for (Employee employee : listEmp) {
      AccessCard accessCard = accessCardRepo.findByEmployeeId(employee.getId());
      if (accessCard != null) {
        List<AccessInformation> listAccess = accessInforRepo.findByAccessCardId(accessCard.getId());
        List<AccessPlace> listPlace = (List<AccessPlace>) accessPlaceRepo.findAll();
        for (AccessPlace accessPlace : listPlace) {
          int count = 0;
          for (AccessInformation listAcces : listAccess) {
            if (listAcces.getAccessPlace().equals(accessPlace)) {
              count++;
            }
          }
          if (count != 0) {
            CheckInOut c = new CheckInOut();
            c.setEmployee(employee);
            c.setAccessPlace(accessPlace);
            c.setSoLan(count);
            a.add(c);
          }
        }
      }
    }
    return a;
  }

  @GetMapping("/staff-salary")
  public List<StaffSalary> staffSalary() {
    List<StaffSalary> a = new ArrayList<>();
    List<Staff> listStaff = (List<Staff>) staffRepo.findAll();
    for (Staff staff : listStaff) {
      StaffSalary s = new StaffSalary();
      float luong = staff.getLuong() + (float) (staff.getService().getDonGia() * (0.2));
      s.setStaff(staff);
      s.setSalary(luong);
      a.add(s);
    }
    return a;
  }

  public int getSoNgayTrongThang(int a, int b) {
    int c = b + 1900;
    if (a == 3 || a == 5 || a == 8 || a == 10) {
      return 30;
    }
    if (a == 1) {
      if (c % 4 == 0) {
        return 29;
      } else {
        return 28;
      }
    }
    return 31;
  }

}
