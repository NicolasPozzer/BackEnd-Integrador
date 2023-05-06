package com.portfolio.nico.Controller;

import com.portfolio.nico.Dto.dtoHys2;
import com.portfolio.nico.Entity.hys2;
import com.portfolio.nico.Security.Controller.Mensaje;
import com.portfolio.nico.Service.Shys2;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://backendd-gzdm.onrender.com"})
@RequestMapping("/skill2")
public class CHys2 {

    @Autowired
    Shys2 shys2;

    @GetMapping("/lista")
    public ResponseEntity<List<hys2>> list() {
        List<hys2> list = shys2.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<hys2> getById(@PathVariable("id") int id) {
        if (!shys2.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        hys2 hYs2 = shys2.getOne(id).get();
        return new ResponseEntity(hYs2, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shys2.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        shys2.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys2 dtohys2) {
        if (StringUtils.isBlank(dtohys2.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (shys2.existsByNombre(dtohys2.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        hys2 hYs2 = new hys2(dtohys2.getNombre(), dtohys2.getPorcentaje());
        shys2.save(hYs2);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys2 dtohys2) {
        //Validamos si existe el ID
        if (!shys2.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (shys2.existsByNombre(dtohys2.getNombre()) && shys2.getByNombre(dtohys2.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohys2.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        hys2 hYs2 = shys2.getOne(id).get();
        hYs2.setNombre(dtohys2.getNombre());
        hYs2.setPorcentaje(dtohys2.getPorcentaje());

        shys2.save(hYs2);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
