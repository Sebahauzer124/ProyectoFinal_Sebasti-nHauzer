
package com.portfolio.sh.model;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="experiencias")
public class Experiencia{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExp;
    
    
   private String tituloExp;
    
    
    private String fechaExp;
    
    
   private String descExp;
    
    
   private String imagenExp;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_persona", nullable=false) 
    private Persona persona;

        public Experiencia(){};

    public Experiencia(Long idExp, String tituloExp, String fechaExp, String descExp, String imagenExp) {
        this.idExp = idExp;
        this.tituloExp = tituloExp;
        this.fechaExp = fechaExp;
        this.descExp = descExp;
        this.imagenExp = imagenExp;
    }

    public Long getIdExp() {
        return idExp;
    }

    public void setIdExp(Long idExp) {
        this.idExp = idExp;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    

 

    
        
}
 
    
    
   