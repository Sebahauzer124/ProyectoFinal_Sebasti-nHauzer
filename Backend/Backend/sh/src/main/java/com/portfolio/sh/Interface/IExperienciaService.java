
package com.portfolio.sh.Interface;

import com.portfolio.sh.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    public List<Experiencia> getExperiencia();
   
    public void saveExperiencia(Experiencia experiencia);
   
    public void deleteExperiencia(Long idExp);
   
    public Experiencia findExperiencia(Long idExp);
}
