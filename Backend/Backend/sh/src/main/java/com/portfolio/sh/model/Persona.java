

package com.portfolio.sh.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
@Table(name = "persona" )
public class Persona implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column( name ="id", nullable = false, updatable = false)
 private Long Id;
    @Column( name ="nombre", nullable = false, updatable = true)
    @NotEmpty
    @Size(min = 2,message = "debe contener al menos dos caracteres")
 private String nombre;
    @Column( name ="apellido", nullable = false, updatable = true )
     @NotEmpty
    @Size(min = 2,message = "El apellido debe contener al menos dos caracteres")
 private String apellido;
    @Column( name ="img", nullable = false, updatable = true)
     @NotEmpty
    @Size(min = 2,message = "La imagen debe cumplir con su formato")  
 private String img;
  @Column( name ="acerca_de", nullable = false, updatable = true)
 @NotEmpty
    @Size(min = 2,message = " Acerca de debe contener al menos dos caracteres")  
 private String acercaDe;
  @Column( name ="titulo", nullable = false,updatable = true)
   @NotEmpty
    @Size(min = 2,message = "debe contener al menos dos caracteres")
 private String titulo;
 

 
 @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEduKF")
 private List<Educacion> educacionList;
 

   
public Persona(){
}

    public Persona(Long Id, String nombre, String apellido, String img, String acercaDe, String titulo) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.acercaDe = acercaDe;
        this.titulo = titulo;
    }



   

 
    
 



}
 
    
 
 

