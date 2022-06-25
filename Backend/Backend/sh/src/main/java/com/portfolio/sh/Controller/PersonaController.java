
package com.portfolio.sh.Controller;

import com.portfolio.sh.model.Persona;
import com.portfolio.sh.Interface.IPersonaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
 @GetMapping("personas/traer")
 public List<Persona> getPersonas(){
 
 return ipersonaService.getPersonas();
 }
           
    @PreAuthorize("hasRole('ADMIN')")
   @PostMapping("personas/crear")
    public String createPersona(@Valid @RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente ";
    }
   @PreAuthorize("hasRole('ADMIN')") 
   @DeleteMapping("personas/borrar/{Id}")
   public String delatePersona(@PathVariable Long Id){
        
        ipersonaService.deletePersona(Id);
        
        return "La persona fue borrada correctamente";
    }
    
     @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("personas/editar/{Id}/")
     public Persona editPersona(@PathVariable ("Id") Long Id,
                             @Valid   @RequestParam ("Nombre") String nuevoNombre,
                              @Valid  @RequestParam("Apellido") String nuevoApellido,
                              @Valid  @RequestParam("Img") String nuevoImg,
                              @Valid  @RequestParam("AcercaDe") String nuevoacercaDe,
                              @Valid  @RequestParam("Titulo") String nuevoTitulo){
                     
                     
     
     Persona persona= ipersonaService.findPersona(Id);
     persona.setNombre(nuevoNombre);
     persona.setApellido(nuevoApellido);
     persona.setImg(nuevoImg);
     persona.setAcercaDe(nuevoacercaDe);
     persona.setTitulo(nuevoTitulo);
     
    
     ipersonaService.savePersona(persona);
     return persona;
     
     
  
  }
    /*@PathVariable(name ="id")long id 
     tengo que ver como agregarlo porque si lo
     pongo no corre el programa
     */
     @GetMapping("personas/traer/{id}")
     public Persona findPersona( ){
      return ipersonaService.findPersona((long)1);
     }
                                
    
          }

                                
     

     
     
                                        
    

