
package com.portfolio.sh.Controller;

import com.portfolio.sh.Service.ImpSkillService;
import com.portfolio.sh.model.Skill;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/skill")
public class SkillController {
    private final ImpSkillService impSkillService;
   
    public SkillController(ImpSkillService impSkillService){
    this.impSkillService=impSkillService;
}
    @GetMapping("/id/{idSkill}")
    public ResponseEntity<Skill> obtenerSkill(@PathVariable("idSkill")Long idSkill){
    Skill skill=impSkillService.buscarSkill(idSkill);
    return new ResponseEntity<>(skill,HttpStatus.OK);
    }
   
    @GetMapping("/all")
    public ResponseEntity<List<Skill>> obtenerSkill(){
    List <Skill> skill=impSkillService.buscarSkill();
    return new ResponseEntity<>(skill,HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Skill> editarSkill(@RequestBody Skill skill){
    Skill updateSkill=impSkillService.editarSkill(skill);
    return new ResponseEntity<> (updateSkill,HttpStatus.OK);
    }
      @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Skill> crearSkill(@RequestBody Skill skill){
    Skill nuevoSkill=impSkillService.addSkill(skill);
    return new ResponseEntity<> (nuevoSkill,HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{idSkill}")
    public ResponseEntity<?> borrarSkill(@PathVariable("idSkill") Long idSkill){
    impSkillService.borrarSkill(idSkill);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}

