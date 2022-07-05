
package com.portfolio.sh.Controller;

import com.portfolio.sh.Service.ImpPersonaService;
import com.portfolio.sh.model.Persona;
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
@RequestMapping("/personas")
public class PersonaController {
    private final ImpPersonaService impPersonaService;
   
    public PersonaController(ImpPersonaService impPersonaService){
    this.impPersonaService=impPersonaService;
}
    @GetMapping("/id/{id}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable("id")Long id){
    Persona persona=impPersonaService.buscarPersona(id);
    return new ResponseEntity<>(persona,HttpStatus.OK);
    }
   
    @GetMapping("/all")
    public ResponseEntity<List<Persona>> obtenerPersona(){
    List <Persona> persona=impPersonaService.buscarPersona();
    return new ResponseEntity<>(persona,HttpStatus.OK);
    }
   
    @PutMapping("/update")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona persona){
    Persona updatePersona=impPersonaService.editarPersona(persona);
    return new ResponseEntity<> (updatePersona,HttpStatus.OK);
    }
     
    @PostMapping("/add")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
    Persona nuevoPersona=impPersonaService.addPersona(persona);
    return new ResponseEntity<> (nuevoPersona,HttpStatus.CREATED);
    }
   
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarPersona(@PathVariable("id") Long id){
    impPersonaService.borrarPersona(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
}



                                
     

     
     
                                        
    

