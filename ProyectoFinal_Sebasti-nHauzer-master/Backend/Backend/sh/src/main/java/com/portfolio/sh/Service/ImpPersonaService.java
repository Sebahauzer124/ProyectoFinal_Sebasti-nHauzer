/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.Service;



import com.portfolio.sh.Repository.IPersonaRepository;
import com.portfolio.sh.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpPersonaService  {
   
    private final IPersonaRepository iPersonaRepository;
   
    @Autowired
    public ImpPersonaService(IPersonaRepository iPersonaRepository){
    this.iPersonaRepository=iPersonaRepository;
    }
   
    public Persona addPersona(Persona persona){
    return iPersonaRepository.save(persona);
    }
   
    public List<Persona> buscarPersona(){
    return iPersonaRepository.findAll();
    }
   
    public Persona editarPersona(Persona persona){
    return iPersonaRepository.save(persona);
    }
   
    public void borrarPersona(long id){
    iPersonaRepository.deleteById(id);
    }
   public Persona buscarPersona(long id){
   return iPersonaRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));
   }
}

