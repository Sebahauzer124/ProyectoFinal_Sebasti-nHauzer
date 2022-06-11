 
package com.portfolio.sh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
 private Long Id;
    
 
 private String nombre;
 
 
 private String apellido;
 
 
 private String img;
}
