
package com.portfolio.sh.Controller;

import com.portfolio.sh.Service.ImpExperienciaService;
import com.portfolio.sh.model.Experiencia;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/experiencia")
public class ExperienciaController {
    private final ImpExperienciaService impExperienciaService;
   
    public ExperienciaController(ImpExperienciaService impExperienciaService){
    this.impExperienciaService=impExperienciaService;
}
    @GetMapping("/id/{idExp}")
    public ResponseEntity<Experiencia> obtenerExperiencia(@PathVariable("idExp")Long idExp){
    Experiencia experiencia=impExperienciaService.buscarExperiencia(idExp);
    return new ResponseEntity<>(experiencia,HttpStatus.OK);
    }
   
    @GetMapping("/all")
    public ResponseEntity<List<Experiencia>> obtenerExperiencia(){
    List <Experiencia> experiencia=impExperienciaService.buscarExperiencia();
    return new ResponseEntity<>(experiencia,HttpStatus.OK);
    }
   
    @PutMapping("/update")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia experiencia){
    Experiencia updateExperiencia=impExperienciaService.editarExperiencia(experiencia);
    return new ResponseEntity<> (updateExperiencia,HttpStatus.OK);
    }
     
    @PostMapping("/add")
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody Experiencia experiencia){
    Experiencia nuevoExperiencia=impExperienciaService.addExperiencia(experiencia);
    return new ResponseEntity<> (nuevoExperiencia,HttpStatus.CREATED);
    }
   
    @DeleteMapping("/delete/{idExp}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable("idExp") Long idExp){
    impExperienciaService.borrarExperiencia(idExp);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}

