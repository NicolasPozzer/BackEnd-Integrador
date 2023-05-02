package com.portfolio.nico.Service;

import com.portfolio.nico.Entity.hys2;
import com.portfolio.nico.Repository.Rhys2;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class Shys2 {
    @Autowired
    Rhys2 rhys2;
    
    public List<hys2> list(){
        return rhys2.findAll();
    }
    
    public Optional<hys2> getOne(int id){
        return rhys2.findById(id);
    }
    
    public Optional<hys2> getByNombre(String nombre){
        return rhys2.findByNombre(nombre);
    }
    
    public void save(hys2 skill2){
        rhys2.save(skill2);
    }
    
    public void delete(int id){
        rhys2.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhys2.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhys2.existsByNombre(nombre);
    }
}
