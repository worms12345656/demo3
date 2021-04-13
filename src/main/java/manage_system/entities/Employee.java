package manage_system.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Employees")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenNhanVien", nullable = false)
    private String tenNhanVien;
    @Column(name = "ngaySinh", nullable = false)
    private Date ngaySinh;
    @Column(name = "sdtNhanVien", nullable = false)
    private String sdtNhanVien;
    @Column(name = "soCMND", nullable = false)
    private String soCMND;
    @ManyToOne(targetEntity = Company.class)
    private Company congty;

    public Employee() {
    }

    public Employee(Long id, String tenNhanVien, Date ngaySinh, String sdtNhanVien, String soCMND) {
        this.id = id;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.sdtNhanVien = sdtNhanVien;
        this.soCMND = soCMND;
    }
}
