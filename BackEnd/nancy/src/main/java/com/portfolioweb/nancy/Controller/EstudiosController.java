package com.portfolioweb.nancy.Controller;

import com.portfolioweb.nancy.Entity.Estudios;
import com.portfolioweb.nancy.Interface.IEstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping("/estudios")
public class EstudiosController {
    @Autowired
    IEstudiosService iestudiosService;

    @GetMapping("/all")
    public ResponseEntity<List<Estudios>> getAllEstudios() {
        List<Estudios> estudios = iestudiosService.findAllEstudios();
        return new ResponseEntity<>(estudios, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Estudios> getEstudiosById(@PathVariable("id") Long id) {
        Estudios estudio = iestudiosService.findEstudiosById(id);
        return new ResponseEntity<>(estudio, HttpStatus.OK);
    }

    /* @PreAuthorize("hasRole('ADMIN')")*/
    @PostMapping("/add")
    public ResponseEntity<Estudios> addEstudio (@RequestBody Estudios estudio) {
        Estudios newEstudio = iestudiosService.addEstudio(estudio);
        return new ResponseEntity<>(newEstudio, HttpStatus.CREATED);
    }

    /* @PreAuthorize("hasRole('ADMIN')") */
    @PutMapping("/update")
    public ResponseEntity<Estudios> updateEstudio (@RequestBody Estudios estudio) {
        Estudios updateEstudios = iestudiosService.updateEstudios(estudio);
        return new ResponseEntity<>(updateEstudios, HttpStatus.OK);
    }

    /* @PreAuthorize("hasRole('ADMIN')") */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEstudio (@PathVariable("id") Long id) {
        iestudiosService.deleteEstudios(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
