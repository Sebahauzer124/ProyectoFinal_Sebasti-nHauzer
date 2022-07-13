package com.portfolio.sh.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nombre", nullable = false, updatable = true)
    private String nombre;

    @Column(name = "apellido", nullable = false, updatable = true)
    private String apellido;

    @Column(name = "img", nullable = false, updatable = true)
    private String img;
    
    @Column(name = "acerca_de", nullable = false, updatable = true)
    private String acercaDe;
    
    @Column(name = "titulo", nullable = false, updatable = true)
    private String titulo;
    
    @JsonBackReference
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Educacion> educacionList=new HashSet<>();
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Experiencia> experienciaList=new HashSet<>();
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Skill> skillList=new HashSet<>();

    public Persona() {
    }

    public Persona(Long Id, String nombre, String apellido, String img, String acercaDe, String titulo) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.acercaDe = acercaDe;
        this.titulo = titulo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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

    public Set<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(Set<Educacion> educacionList) {
        this.educacionList = educacionList;
    }

    public Set<Experiencia> getExperienciaList() {
        return experienciaList;
    }

    public void setExperienciaList(Set<Experiencia> experienciaList) {
        this.experienciaList = experienciaList;
    }

    public Set<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<Skill> skillList) {
        this.skillList = skillList;
    }

 
}

