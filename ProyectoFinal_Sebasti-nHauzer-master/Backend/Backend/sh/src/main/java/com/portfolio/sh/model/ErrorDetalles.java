
package com.portfolio.sh.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class ErrorDetalles {
    private Date marcaDeTiempo;
    private String mensaje;
    private String detalles;

    public ErrorDetalles(Date marcaDeTiempo, String mensaje, String detalles) {
        this.marcaDeTiempo = marcaDeTiempo;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }
    
    
}
