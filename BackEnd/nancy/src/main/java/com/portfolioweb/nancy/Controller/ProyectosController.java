package com.portfolioweb.nancy.Controller;

import com.portfolioweb.nancy.Entity.Proyectos;
import com.portfolioweb.nancy.Interface.IProyectosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/proyectos")
public class ProyectosController {
    @Autowired
    IProyectosService iproyectosService;

    @GetMapping("/all")
    public ResponseEntity<List<Proyectos>> findAllProyectos() {
        List<Proyectos> proyectos = iproyectosService.findAllProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Proyectos> findProyecto(@PathVariable("id") Long id) {
        Proyectos proyecto = iproyectosService.findProyecto(id);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    /* @PreAuthorize("hasRole('ADMIN')")*/
    @PostMapping("/add")
    public ResponseEntity<Proyectos> addProyecto (@RequestBody Proyectos proyecto) {
        Proyectos newProyecto = iproyectosService.addProyecto(proyecto);
        return new ResponseEntity<>(newProyecto, HttpStatus.CREATED);
    }

    /* @PreAuthorize("hasRole('ADMIN')")*/
    @PutMapping("/update")
    public ResponseEntity<Proyectos> updateProyectos (@RequestBody Proyectos skill) {
        Proyectos updateProyectos = iproyectosService.updateProyectos(skill);
        return new ResponseEntity<>(updateProyectos, HttpStatus.OK);
    }

    /* @PreAuthorize("hasRole('ADMIN')")*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProyecto (@PathVariable("id") Long id) {
        iproyectosService.deleteProyecto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
