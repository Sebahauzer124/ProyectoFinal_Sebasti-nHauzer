
package com.portfolio.sh.Security.Repository;

import com.portfolio.sh.Security.Enums.RolNombre;
import com.portfolio.sh.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
