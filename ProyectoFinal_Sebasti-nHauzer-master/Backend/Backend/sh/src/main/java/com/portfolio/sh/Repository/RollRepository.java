
package com.portfolio.sh.Repository;

import com.portfolio.sh.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RollRepository extends JpaRepository<Rol,Long> {
    public Optional<Rol> findByNombre(String nombre);
}
