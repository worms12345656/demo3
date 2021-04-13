/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_system.entities;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
@Entity
@Table(name = "accessCard")
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ngayCap")
    private Date ngayCap;
    @OneToOne(targetEntity = Employee.class)
    private Employee employee;

    public AccessCard() {
    }

    public AccessCard(Long id, Date ngayCap, Employee employee) {
        this.id = id;
        this.ngayCap = ngayCap;
        this.employee = employee;
    }
    
    
}
