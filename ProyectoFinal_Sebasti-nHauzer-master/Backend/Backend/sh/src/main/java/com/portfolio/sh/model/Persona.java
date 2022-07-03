

package com.portfolio.sh.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
 

@JsonBackReference
 @OneToMany(mappedBy="persona",cascade=CascadeType.ALL,orphanRemoval = true)
 private List<Educacion> educacionList;
@JsonBackReference
 @OneToMany(mappedBy="persona",cascade=CascadeType.ALL,orphanRemoval = true)
 private List<Experiencia> experienciaList;
@JsonBackReference
 @OneToMany(mappedBy="persona",cascade=CascadeType.ALL,orphanRemoval = true)
 private List<Skill> skillList;
    public Long getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<Educacion> educacionList) {
        this.educacionList = educacionList;
    }

    public List<Experiencia> getExperienciaList() {
        return experienciaList;
    }

    public void setExperienciaList(List<Experiencia> experienciaList) {
        this.experienciaList = experienciaList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }


public Persona(){};

    public Persona(Long Id, String nombre, String apellido, String img, String acercaDe, String titulo, List<Educacion> educacionList, List<Experiencia> experienciaList, List<Skill> skillList) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.acercaDe = acercaDe;
        this.titulo = titulo;
        this.educacionList = educacionList;
        this.experienciaList = experienciaList;
        this.skillList = skillList;
    }
 
 



   

 
    
 



}
 
    
 
 

