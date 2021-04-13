/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_system.repository;

import java.util.List;
import manage_system.entities.AccessInformation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface AccessInformationRepository extends CrudRepository<AccessInformation, Long>{

    public List<AccessInformation> findByAccessCardId(Long id);
    
}
