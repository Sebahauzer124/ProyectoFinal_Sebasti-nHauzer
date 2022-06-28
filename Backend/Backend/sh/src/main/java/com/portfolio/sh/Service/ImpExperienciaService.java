/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.Service;

/**
 *
 * @author Usuario
 */
import com.portfolio.sh.Interface.IExperienciaService;
import com.portfolio.sh.Repository.IExperienciaRepository;
import com.portfolio.sh.model.Experiencia;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService implements IExperienciaService {
    @Autowired
    private IExperienciaRepository expeRepository;

    @Override
    public List<Experiencia> getExperiencia() {
    List<Experiencia> listExperiencia=expeRepository.findAll();
    return listExperiencia;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        expeRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long idExp) {
         expeRepository.deleteById(idExp);
    }

    @Override
    public Experiencia findExperiencia(Long idExp) {
     Experiencia experiencia= expeRepository.findById(idExp).orElse(null);
     return experiencia;  
    }


 

}
