
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
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter @Setter
@Entity
@Table(name="educacion")
public class Educacion{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column(name="id_edu")
   private Long idEdu;
    @Column(name="titulo_edu")
   private String tituloEdu;
    @Column(name="fecha_edu")
   private String fechaEdu;
    @Column(name="desc_edu")
   private String descEdu;
    @Column(name="imagen_edu")
   private String imagenEdu;
    @Column(name="id_edukf")
    private Long idEduKF;
    
    
 
   //Constructor vacio
   public Educacion(){
 }

    public Educacion(Long idEdu, String tituloEdu, String fechaEdu, String descEdu, String imagenEdu, Long idEduKF) {
        this.idEdu = idEdu;
        this.tituloEdu = tituloEdu;
        this.fechaEdu = fechaEdu;
        this.descEdu = descEdu;
        this.imagenEdu = imagenEdu;
        this.idEduKF = idEduKF;
        
    }

   

  
}
