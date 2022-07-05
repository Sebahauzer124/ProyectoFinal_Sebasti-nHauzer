
package com.portfolio.sh.model;


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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="experiencia")
public class Experiencia{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_exp")
   private Long idExp;
    
    @Column(name="titulo_exp")
    @NotEmpty
    @Size(min = 2,message = "el titulo debe contener al menos dos caracteres")
   private String tituloExp;
    
    @Column(name="fecha_exp")
    @NotEmpty
    @Size(min = 2,message = "Debe contener formato fecha")
    private String fechaExp;
    
    @Column(name="desc_exp")
    @NotEmpty
    @Size(min = 2,message = "La descrpcion debe tener mas caracteres")
   private String descExp;
    
    @Column(name="imagen_exp")
    @NotEmpty
    @Size(min = 2,message = "Debe tener formato de imagen")
   private String imagenExp;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_persona", nullable=false) 
    private Persona persona;

        public Experiencia(){};

    public Experiencia(String tituloExp, String fechaExp, String descExp, String imagenExp, Persona persona) {
        this.tituloExp = tituloExp;
        this.fechaExp = fechaExp;
        this.descExp = descExp;
        this.imagenExp = imagenExp;
        this.persona = persona;
    }

  


    public String getTituloExp() {
        return tituloExp;
    }

    public void setTituloExp(String tituloExp) {
        this.tituloExp = tituloExp;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getDescExp() {
        return descExp;
    }

    public void setDescExp(String descExp) {
        this.descExp = descExp;
    }

    public String getImagenExp() {
        return imagenExp;
    }

    public void setImagenExp(String imagenExp) {
        this.imagenExp = imagenExp;
    }
        
}
 
    
    
   