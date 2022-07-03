/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.Service;



import com.portfolio.sh.Repository.IEducacionRepository;
import com.portfolio.sh.model.Educacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpEducacionService  {
   
    private final IEducacionRepository iEducacionRepository;
   
    @Autowired
    public ImpEducacionService(IEducacionRepository iEducacionRepository){
    this.iEducacionRepository=iEducacionRepository;
    }
   
    public Educacion addEducacion(Educacion educacion){
    return iEducacionRepository.save(educacion);
    }
   
    public List<Educacion> buscarEducacion(){
    return iEducacionRepository.findAll();
    }
   
    public Educacion editarEducacion(Educacion educacion){
    return iEducacionRepository.save(educacion);
    }
   
    public void borrarEducacion(long idEdu){
    iEducacionRepository.deleteById(idEdu);
    }
   public Educacion buscarEducacion(long idEdu){
   return iEducacionRepository.findById(idEdu).orElseThrow(()-> new UsernameNotFoundException("Educacion no encontrado"));
   }
}

