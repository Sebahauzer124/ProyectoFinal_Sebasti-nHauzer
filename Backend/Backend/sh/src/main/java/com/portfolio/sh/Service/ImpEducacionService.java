
package com.portfolio.sh.Service;

import com.portfolio.sh.Excepciones.ResourceNotFoundException;
import com.portfolio.sh.Interface.IEducacionService;
import com.portfolio.sh.Repository.IEducacionRepository;
import com.portfolio.sh.Repository.IPersonaRepository;
import com.portfolio.sh.model.Educacion;
import com.portfolio.sh.model.Persona;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class ImpEducacionService implements IEducacionService {
    @Autowired
    private IEducacionRepository ieducacionrepository;
    
    @Autowired
    private IPersonaRepository ipersonarepository;

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> listaEducacion = ieducacionrepository.findAll();
        
        return  listaEducacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
     ieducacionrepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long idEdu) {
      ieducacionrepository.deleteById(idEdu);
    }

    @Override
    public Educacion findEducacion(Long idEdu) {
        Educacion educacion = ieducacionrepository.findById(idEdu).orElseThrow(()->new ResourceNotFoundException("Educacion","idEdu",idEdu));
      
        return educacion;  
       
    }
       
}
