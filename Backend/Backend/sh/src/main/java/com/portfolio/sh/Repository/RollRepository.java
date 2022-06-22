
package com.portfolio.sh.Repository;

import com.portfolio.sh.model.Roll;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RollRepository extends JpaRepository<Roll,Long> {
    public Optional<Roll> findByNombre(String nombre);
}
