
package com.portfolio.sh.model;
import com.portfolio.sh.Repository.IPersonaRepository;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="educacion")
public class Educacion{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_edu")
   private Long idEdu;
    
    @Column(name="titulo_edu")
    @NotEmpty
    @Size(min = 2,message = "el titulo debe contener al menos dos caracteres")
   private String tituloEdu;
    
    @Column(name="fecha_edu")
    @NotEmpty
    @Size(min = 2,message = "Debe contener formato fecha")
    private String fechaEdu;
    
    @Column(name="desc_edu")
    @NotEmpty
    @Size(min = 2,message = "La descrpcion debe tener mas caracteres")
   private String descEdu;
    
    @Column(name="imagen_edu")
    @NotEmpty
    @Size(min = 2,message = "Debe tener formato de imagen")
   private String imagenEdu;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_persona", nullable=false) 
    private Persona persona;

    public Long getIdEdu() {
        return idEdu;
    }

    public void setIdEdu(Long idEdu) {
        this.idEdu = idEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }

    public String getDescEdu() {
        return descEdu;
    }

    public void setDescEdu(String descEdu) {
        this.descEdu = descEdu;
    }

    public String getImagenEdu() {
        return imagenEdu;
    }

    public void setImagenEdu(String imagenEdu) {
        this.imagenEdu = imagenEdu;
    }
    
 
   //Constructor vacio
   public Educacion(){
       super();
 }

    public Educacion(Long idEdu, String tituloEdu, String fechaEdu, String descEdu, String imagenEdu) {
        this.idEdu = idEdu;
        this.tituloEdu = tituloEdu;
        this.fechaEdu = fechaEdu;
        this.descEdu = descEdu;
        this.imagenEdu = imagenEdu;
    }




   

  
}
