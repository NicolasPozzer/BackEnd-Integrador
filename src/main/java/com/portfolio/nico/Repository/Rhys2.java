package com.portfolio.nico.Repository;

import com.portfolio.nico.Entity.hys2;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface Rhys2 extends JpaRepository<hys2, Integer>{
    Optional<hys2> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
