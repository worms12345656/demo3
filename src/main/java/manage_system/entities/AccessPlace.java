/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_system.entities;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

/**
 *
 * @author Admin
 */
@Data
@Entity
@Table(name = "accessPlace")
public class AccessPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "place")
    private String place;
}
