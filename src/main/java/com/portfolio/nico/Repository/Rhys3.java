package com.portfolio.nico.Repository;

import com.portfolio.nico.Entity.hys3;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface Rhys3 extends JpaRepository<hys3, Integer>{
    Optional<hys3> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
