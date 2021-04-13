package manage_system.entities;

public class ListComp {

  private static final long serialVersionUID = 1L;
  private Company company;
  private float tienDichVu;
  private int soNhanVien;

  public ListComp(Company company, float tienDichVu, int soNhanVien) {
    this.company = company;
    this.tienDichVu = tienDichVu;
    this.soNhanVien = soNhanVien;
  }

  public ListComp() {
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public float getTienDichVu() {
    return tienDichVu;
  }

  public void setTienDichVu(float tienDichVu) {
    this.tienDichVu = tienDichVu;
  }

  public int getSoNhanVien() {
    return soNhanVien;
  }

  public void setSoNhanVien(int soNhanVien) {
    this.soNhanVien = soNhanVien;
  }

}