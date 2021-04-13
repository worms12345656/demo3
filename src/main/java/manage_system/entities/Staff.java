package manage_system.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Staffs")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenNVToaNha", nullable = false)
    private String tenNVToaNha;
    @Column(name = "ngaySinhNvToaNha", nullable = false)
    private Date ngaySinhNvToaNha;
    @Column(name = "diaChi", nullable = false)
    private String diaChi;
    @Column(name = "sdtNvToaNha", nullable = false)
    private String sdtNvToaNha;
    @Column(name = "luong", nullable = false)
    private float luong;
    @Column(name = "capBac", nullable = false)
    private String capBac;
    @ManyToOne(targetEntity = Service.class)
    private Service service;


    public Staff() {
    }

    public Staff(Long id, String tenNVToaNha, Date ngaySinhNvToaNha, String diaChi, String sdtNvToaNha, float luong,
            String capBac) {
        this.id = id;
        this.tenNVToaNha = tenNVToaNha;
        this.ngaySinhNvToaNha = ngaySinhNvToaNha;
        this.diaChi = diaChi;
        this.sdtNvToaNha = sdtNvToaNha;
        this.luong = luong;
        this.capBac = capBac;
    }
}
