
package com.portfolio.sh.Controller;

import com.portfolio.sh.Service.ImpEducacionService;
import com.portfolio.sh.model.Educacion;
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
@RequestMapping("/educacion")
public class EducacionController {
    private final ImpEducacionService impEducacionService;
   
    public EducacionController(ImpEducacionService impEducacionService){
    this.impEducacionService=impEducacionService;
}
    @GetMapping("/id/{idEdu}")
    public ResponseEntity<Educacion> obtenerEducacion(@PathVariable("idEdu")Long idEdu){
    Educacion educacion=impEducacionService.buscarEducacion(idEdu);
    return new ResponseEntity<>(educacion,HttpStatus.OK);
    }
   
    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> obtenerEducacion(){
    List <Educacion> educacion=impEducacionService.buscarEducacion();
    return new ResponseEntity<>(educacion,HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){
    Educacion updateEducacion=impEducacionService.editarEducacion(educacion);
    return new ResponseEntity<> (updateEducacion,HttpStatus.OK);
    }
      @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Educacion> crearEducacion(@RequestBody Educacion educacion){
    Educacion nuevoEducacion=impEducacionService.addEducacion(educacion);
    return new ResponseEntity<> (nuevoEducacion,HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{idEdu}")
    public ResponseEntity<?> borrarEducacion(@PathVariable("idEdu") Long idEdu){
    impEducacionService.borrarEducacion(idEdu);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}

