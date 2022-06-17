/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.Excepciones;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Getter @Setter
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException   {
    private static final long serialVersionUID=1L;
    private String nombreDelRecurso;
    private String nombreDelCampo;
    private Long valorDelCampo;

    public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, Long valorDelCampo) {
        super(String.format("%s No encontrado con : %s :'%s'",nombreDelRecurso,nombreDelCampo,valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }
    
    
}
