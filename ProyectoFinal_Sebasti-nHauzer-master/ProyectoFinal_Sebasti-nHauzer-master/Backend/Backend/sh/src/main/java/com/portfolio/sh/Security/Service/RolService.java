
package com.portfolio.sh.Security.Service;

import com.portfolio.sh.Security.Entity.Rol;
import com.portfolio.sh.Security.Enums.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.sh.Security.Repository.iRolRepository;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
    return irolRepository.findByRolNombre(rolNombre);
   
    }
    
    public void save(Rol rol){
    irolRepository.save(rol);
    }
}
