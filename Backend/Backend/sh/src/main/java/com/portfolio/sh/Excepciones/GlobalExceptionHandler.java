 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.sh.Excepciones;

import com.portfolio.sh.model.ErrorDetalles;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static org.hibernate.criterion.Restrictions.ne;
import static org.hibernate.criterion.Subqueries.ne;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity <ErrorDetalles> manejarResourceNotFoundException(ResourceNotFoundException exception , WebRequest webRequest){
        ErrorDetalles errorDetalles = new ErrorDetalles(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles,HttpStatus.NOT_FOUND);
    }

    
    @ExceptionHandler(Exception.class)
    public ResponseEntity <ErrorDetalles> manejarGlobalException(ResourceNotFoundException exception , WebRequest webRequest){
        ErrorDetalles errorDetalles = new ErrorDetalles(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> errores=new HashMap<>();{
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String nombreCampo=((FieldError)error).getField();
            String mensaje=error.getDefaultMessage();
            
            errores.put(nombreCampo,mensaje);
        });
        return new ResponseEntity<>(errores,HttpStatus.BAD_REQUEST);
        }
    }
    }


