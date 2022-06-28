
package com.portfolio.sh.Controller;


import com.portfolio.sh.Interface.IExperienciaService;
import com.portfolio.sh.model.Experiencia;
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
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
        @Autowired
    private IExperienciaService interExperiencia;
   
    @GetMapping("experiencia/traer")
    public List <Experiencia> getExperiencia(){
    return interExperiencia.getExperiencia();
    }
   
    @PostMapping("experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia){
    interExperiencia.saveExperiencia(experiencia);
    return "La experiencia fue creada correctamente";
    }
   
    @DeleteMapping("experiencia/borrar/{idExp}")
    public String deleteExperiencia(@PathVariable("idExp") Long idExp){
    interExperiencia.deleteExperiencia(idExp);
    return "La experiencia fue eliminada correctamente";
    }
   
    @PutMapping("experiencia/editar/{idExp}")
    public Experiencia editExperiencia(@PathVariable("idExp") Long idExp,
                               @RequestParam ("tituloExp")String nuevoNombreExp,
                                @RequestParam ("descExp")String nuevaDescripcionExp,
                                @RequestParam ("imagenExp") String nuevaImgExp){
        Experiencia expe = interExperiencia.findExperiencia(idExp);
        expe.setTituloExp(nuevoNombreExp);
        expe.setDescExp(nuevaDescripcionExp);
        expe.setImagenExp(nuevaImgExp);
       
        interExperiencia.saveExperiencia(expe);
       
        return expe;
    }
}
