/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.Service;



import com.portfolio.sh.Repository.IExperienciaRepository;
import com.portfolio.sh.Repository.ISkillRepository;
import com.portfolio.sh.model.Experiencia;
import com.portfolio.sh.model.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpExperienciaService  {
   
    private final IExperienciaRepository iExperienciaRepository;
   
    @Autowired
    public ImpExperienciaService(IExperienciaRepository iExperienciaRepository){
    this.iExperienciaRepository=iExperienciaRepository;
    }
   
    public Experiencia addExperiencia(Experiencia experiencia){
    return iExperienciaRepository.save(experiencia);
    }
   
    public List<Experiencia> buscarExperiencia(){
    return iExperienciaRepository.findAll();
    }
   
    public Experiencia editarExperiencia(Experiencia experiencia){
    return iExperienciaRepository.save(experiencia);
    }
   
    public void borrarExperiencia(long idExp){
    iExperienciaRepository.deleteById(idExp);
    }
   public Experiencia buscarExperiencia(long idExp){
   return iExperienciaRepository.findById(idExp).orElseThrow(()-> new UsernameNotFoundException("Experiencia no encontrado"));
   }
}

