/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_system.entities;


import java.util.Date;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
@Entity
@Table(name = "accessInformation")
public class AccessInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="accessTime")
    private Date accessTime;
    @Column(name ="accessType")
    private int accessType;
    @ManyToOne(targetEntity = AccessCard.class)
    private AccessCard accessCard;
    @OneToOne(targetEntity = AccessPlace.class)
    private AccessPlace accessPlace;

    public AccessInformation() {
    }

    public AccessInformation(Long id, Date accessTime, AccessCard accessCard) {
        this.id = id;
        this.accessTime = accessTime;
        this.accessCard = accessCard;
    }
    
    
    
}
