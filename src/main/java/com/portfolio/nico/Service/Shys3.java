package com.portfolio.nico.Service;

import com.portfolio.nico.Entity.hys3;
import com.portfolio.nico.Repository.Rhys3;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class Shys3 {
    @Autowired
    Rhys3 rhys3;
    
    public List<hys3> list(){
        return rhys3.findAll();
    }
    
    public Optional<hys3> getOne(int id){
        return rhys3.findById(id);
    }
    
    public Optional<hys3> getByNombre(String nombre){
        return rhys3.findByNombre(nombre);
    }
    
    public void save(hys3 skill3){
        rhys3.save(skill3);
    }
    
    public void delete(int id){
        rhys3.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhys3.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhys3.existsByNombre(nombre);
    }
}
