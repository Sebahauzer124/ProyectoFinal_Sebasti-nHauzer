/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.Service;



import com.portfolio.sh.Repository.ISkillRepository;
import com.portfolio.sh.model.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpSkillService  {
   
    private final ISkillRepository iSkillRepository;
   
    @Autowired
    public ImpSkillService(ISkillRepository iSkillRepository){
    this.iSkillRepository=iSkillRepository;
    }
   
    public Skill addSkill(Skill skill){
    return iSkillRepository.save(skill);
    }
   
    public List<Skill> buscarSkill(){
    return iSkillRepository.findAll();
    }
   
    public Skill editarSkill(Skill skill){
    return iSkillRepository.save(skill);
    }
   
    public void borrarSkill(long idSkill){
    iSkillRepository.deleteById(idSkill);
    }
   public Skill buscarSkill(long idSkill){
   return iSkillRepository.findById(idSkill).orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));
   }
}

