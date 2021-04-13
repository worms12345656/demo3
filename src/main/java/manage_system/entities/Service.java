package manage_system.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Services")
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenDichVu", nullable = false)
    private String tenDichVu;
    @Column(name = "loaiDichVu", nullable = false)
    private String loaiDichVu;
    @Column(name = "donGia", nullable = false)
    private float donGia;

    public Service() {
    }

    public Service(Long id, String tenDichVu, String loaiDichVu, float donGia) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.loaiDichVu = loaiDichVu;
        this.donGia = donGia;
    }
}
