package manage_system.entities;

public class StaffSalary {
  private static final long serialVersionUID = 1L;
  private Staff staff;
  private float salary;

  

  public Staff getStaff() {
    return staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }

  public float getSalary() {
    return salary;
  }

  public void setSalary(float salary) {
    this.salary = salary;
  }

  public StaffSalary(Staff staff, float salary) {
    this.staff = staff;
    this.salary = salary;
  }

  public StaffSalary() {
  }

  
}
