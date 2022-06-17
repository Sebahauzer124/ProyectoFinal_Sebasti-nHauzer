
package com.portfolio.sh.Controller;

import com.portfolio.sh.model.Persona;
import com.portfolio.sh.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
/*@CrossOrigin(origins = "http://localhost:4200")*/
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
 @GetMapping("personas/traer")
 public List<Persona> getPersonas(){
 
 return ipersonaService.getPersonas();
 }
           
    
   @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente ";
    }
   @DeleteMapping("personas/borrar/{Id}")
   public String delatePersona(@PathVariable Long Id){
        
        ipersonaService.deletePersona(Id);
        
        return "La persona fue borrada correctamente";
    }
    
    
     @PutMapping("/personas/editar/{Id}/")
     public Persona editPersona(@PathVariable ("Id") Long Id,
                                @RequestParam ("Nombre") String nuevoNombre,
                                @RequestParam("Apellido") String nuevoApellido,
                                @RequestParam("Img") String nuevoImg,
                                @RequestParam("AcercaDe") String nuevoacercaDe,
                                @RequestParam("Titulo") String nuevoTitulo){
                     
                     
     
     Persona persona= ipersonaService.findPersona(Id);
     persona.setNombre(nuevoNombre);
     persona.setApellido(nuevoApellido);
     persona.setImg(nuevoImg);
     persona.setAcercaDe(nuevoacercaDe);
     persona.setTitulo(nuevoTitulo);
     
    
     ipersonaService.savePersona(persona);
     return persona;
     
     
  
  }
     
     @GetMapping("personas/traer/{id}")
     public Persona findPersona(@PathVariable(name ="id")long id ){
      return ipersonaService.findPersona(id);
     }
                                
    
          }

                                
     

     
     
                                        
    

