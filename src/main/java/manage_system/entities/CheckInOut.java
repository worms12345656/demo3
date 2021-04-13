package manage_system.entities;

public class CheckInOut {

  private static final long serialVersionUID = 1L;
  private Employee employee;
  private AccessPlace accessPlace;
  private int soLan;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public AccessPlace getAccessPlace() {
    return accessPlace;
  }

  public void setAccessPlace(AccessPlace accessPlace) {
    this.accessPlace = accessPlace;
  }

  public int getSoLan() {
    return soLan;
  }

  public void setSoLan(int soLan) {
    this.soLan = soLan;
  }

  public CheckInOut() {
  }

  public CheckInOut(Employee employee, AccessPlace accessPlace, int soLan) {
    this.employee = employee;
    this.accessPlace = accessPlace;
    this.soLan = soLan;
  }

  
}
