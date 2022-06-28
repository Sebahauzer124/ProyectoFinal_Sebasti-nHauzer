/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.Controller;

import com.portfolio.sh.Interface.IEducacionService;
import com.portfolio.sh.model.Educacion;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
      @Autowired IEducacionService ieducacionService;
    
 @GetMapping("educacion/traer")
 public List<Educacion> getEducacion(){
 
 return ieducacionService.getEducacion();
 }
           
    @GetMapping("educacion/{idEdu}")
    public ResponseEntity<Educacion> findEducacionById(@PathVariable(name="idEdu")long idEdu){
    return ResponseEntity.ok(ieducacionService.findEducacion(idEdu));
    }
/* @PreAuthorize("hasRole('USER')")*/
   @PostMapping("educacion/crear")
    public String createEducacion(@RequestBody Educacion educacion){
        ieducacionService.saveEducacion(educacion);
        return "La Educacion fue creada correctamente ";
    }
  /* @PreAuthorize("hasRole('ADMIN')")*/ 
   @DeleteMapping("educacion/borrar/{idEdu}")
   public String delateEducacion(@PathVariable("idEdu") Long idEdu){
        
        ieducacionService.deleteEducacion(idEdu);
        
        return "La educacion fue borrada correctamente";
    }
    /* 
   
    private Long idEdu;
   private String tituloEdu;
   private String fechaEdu;
   private String descEdu;
   private String imagenEdu;
   */
   /* @PreAuthorize("hasRole('ADMIN')")*/
     @PutMapping("educacion/editar/{idEdu}")
     public Educacion editEducacion(@PathVariable("idEdu") Long idEdu,
                                @RequestParam("tituloEdu") String nuevoTitulo,
                                @RequestParam("fechaEdu") String nuevaFecha,
                                 @RequestParam("descrpcionEdu") String nuevaDescripcion,
                                @RequestParam ("imagenEdu") String nuevaImagen
                               )   {
     
     Educacion educacion= ieducacionService.findEducacion(idEdu);
     educacion.setTituloEdu(nuevoTitulo);
     educacion.setFechaEdu(nuevaFecha);
     educacion.setDescEdu(nuevaDescripcion);
     educacion.setImagenEdu(nuevaImagen) ;
    
  
     
     ieducacionService.saveEducacion(educacion);
     return educacion;
     
     }
 
}
