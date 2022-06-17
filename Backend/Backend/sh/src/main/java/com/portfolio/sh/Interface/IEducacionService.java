 
package com.portfolio.sh.Interface;

import com.portfolio.sh.model.Educacion;
import java.util.List;


public interface IEducacionService {
      public List<Educacion> getEducacion();
    
    public void saveEducacion(Educacion educacion);
    
    public void deleteEducacion(Long idEdu);
    
    public Educacion findEducacion(Long idEdu);
}
