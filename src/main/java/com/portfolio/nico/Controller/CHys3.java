package com.portfolio.nico.Controller;

import com.portfolio.nico.Dto.dtoHys3;
import com.portfolio.nico.Entity.hys3;
import com.portfolio.nico.Security.Controller.Mensaje;
import com.portfolio.nico.Service.Shys3;
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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-nicolaspozzer.web.app")
@RequestMapping("/skill3")
public class CHys3 {

    @Autowired
    Shys3 shys3;

    @GetMapping("/lista")
    public ResponseEntity<List<hys3>> list() {
        List<hys3> list = shys3.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<hys3> getById(@PathVariable("id") int id) {
        if (!shys3.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        hys3 hYs3 = shys3.getOne(id).get();
        return new ResponseEntity(hYs3, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shys3.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        shys3.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys3 dtohys3) {
        if (StringUtils.isBlank(dtohys3.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (shys3.existsByNombre(dtohys3.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        hys3 hYs3 = new hys3(dtohys3.getNombre(), dtohys3.getPorcentaje());
        shys3.save(hYs3);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys3 dtohys3) {
        //Validamos si existe el ID
        if (!shys3.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (shys3.existsByNombre(dtohys3.getNombre()) && shys3.getByNombre(dtohys3.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohys3.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        hys3 hYs3 = shys3.getOne(id).get();
        hYs3.setNombre(dtohys3.getNombre());
        hYs3.setPorcentaje(dtohys3.getPorcentaje());

        shys3.save(hYs3);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
