/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_system.repository;

import manage_system.entities.AccessCard;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface AccessCardRepository extends CrudRepository<AccessCard, Long>{

    public AccessCard findByEmployeeId(Long id);
    
}
