package manage_system.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "Company")
public class Company implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "tenCongTy", nullable = false)
  private String tenCongTy;
  @Column(name = "maSoThue", nullable = false)
  private String maSoThue;
  @Column(name = "vonDieuLe", nullable = false)
  private float vonDieuLe;
  @Column(name = "linhVucHoatDong", nullable = false)
  private String linhVucHoatDong;
  @Column(name = "diaChiTrongToaNha", nullable = false)
  private String diaChiTrongToaNha;
  @Column(name = "sdtCongTy", nullable = false)
  private String sdtCongTy;
  @Column(name = "dienTichMatBang", nullable = false)
  private float dienTichMatBang;
  @ManyToMany(targetEntity = Service.class)
  private List<Service> services;

  public Company() {
  }

  public Company(String tenCongTy, String maSoThue, float vonDieuLe, String linhVucHoatDong, String diaChiTrongToaNha,
      String sdtCongTy, float dienTichMatBang) {
    this.tenCongTy = tenCongTy;
    this.maSoThue = maSoThue;
    this.vonDieuLe = vonDieuLe;
    this.linhVucHoatDong = linhVucHoatDong;
    this.diaChiTrongToaNha = diaChiTrongToaNha;
    this.sdtCongTy = sdtCongTy;
    this.dienTichMatBang = dienTichMatBang;
  }

  public Company(Long id, String tenCongTy, String maSoThue, float vonDieuLe, String linhVucHoatDong,
      String diaChiTrongToaNha, String sdtCongTy, float dienTichMatBang) {
    this.id = id;
    this.tenCongTy = tenCongTy;
    this.maSoThue = maSoThue;
    this.vonDieuLe = vonDieuLe;
    this.linhVucHoatDong = linhVucHoatDong;
    this.diaChiTrongToaNha = diaChiTrongToaNha;
    this.sdtCongTy = sdtCongTy;
    this.dienTichMatBang = dienTichMatBang;
  }

}
