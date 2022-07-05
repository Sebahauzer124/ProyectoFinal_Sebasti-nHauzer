
package com.portfolio.sh.Security.Service;

import com.portfolio.sh.Security.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import com.portfolio.sh.Security.Repository.iUsuarioRepository;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
    return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
   public boolean existsByNombreUsuario(String nombreUsuario){
   return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
   }
   
     public boolean existsByEmail(String email){
   return iUsuarioRepository.existsByEmail(email);
   }
     
     public void save (Usuario usuario){
     iUsuarioRepository.save(usuario);
     }
   
}
