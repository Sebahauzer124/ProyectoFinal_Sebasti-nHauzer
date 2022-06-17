/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.Service;

import com.portfolio.sh.Excepciones.ResourceNotFoundException;
import com.portfolio.sh.model.Persona;
import com.portfolio.sh.Interface.IPersonaService;
import com.portfolio.sh.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {
@Autowired
private IPersonaRepository ipersonaRepository;
    
        
    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersona = ipersonaRepository.findAll();
        
        return  listaPersona;
    }

    @Override
    public void savePersona(Persona persona) {
     ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
     Persona persona = ipersonaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Persona","id",id));
      return persona;
    }

   
}
