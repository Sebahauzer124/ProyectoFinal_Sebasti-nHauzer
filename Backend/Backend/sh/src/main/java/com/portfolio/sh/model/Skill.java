
package com.portfolio.sh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_skill")
   private Long idSkill;
    @Column(name="titulo_skill")
    @NotEmpty
    @Size(min = 2,message = "el titulo debe contener al menos dos caracteres")
   private String tituloSkill;
    
    @Column(name="imagen_skill")
    @NotEmpty
    @Size(min = 2,message = "Debe contener formato fecha")
   private String imagenSkill;
    
      @Column(name="porcentaje")
    @NotEmpty
    private int porcentaje;
   
      @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_persona", nullable=false) 
    private Persona persona;   
      
   public Skill(){}

    public Skill(Long idSkill, String tituloSkill, String imagenSkill, int porcentaje) {
        this.idSkill = idSkill;
        this.tituloSkill = tituloSkill;
        this.imagenSkill = imagenSkill;
        this.porcentaje = porcentaje;
    }

    public Long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(Long idSkill) {
        this.idSkill = idSkill;
    }

    public String getTituloSkill() {
        return tituloSkill;
    }

    public void setTituloSkill(String tituloSkill) {
        this.tituloSkill = tituloSkill;
    }

    public String getImagenSkill() {
        return imagenSkill;
    }

    public void setImagenSkill(String imagenSkill) {
        this.imagenSkill = imagenSkill;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
   
   
}