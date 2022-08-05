package com.portfolioweb.nancy.Controller;

import com.portfolioweb.nancy.Entity.Persona;
import com.portfolioweb.nancy.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/persona")
public class PersonaController {
    private final IPersonaService iPersonaService;

    public PersonaController(IPersonaService iPersonaService) {
        this.iPersonaService = iPersonaService;
    }

    @GetMapping("/all")
public ResponseEntity<List<Persona>> getAllPersonas(){
        List<Persona> personas = iPersonaService.findAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable("id") Long id){
       Persona persona = iPersonaService.findPersonaById(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    /* @PreAuthorize("hasRole('ADMIN')") */
    @PostMapping("/add")
public ResponseEntity<Persona> addPersona(@RequestBody Persona persona){
        Persona  newPersona = iPersonaService.addPersona(persona);
        return new ResponseEntity<>(newPersona, HttpStatus.CREATED);
    }
    /* @PreAuthorize("hasRole('ADMIN')") */
    @PutMapping("/update")
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona){
        Persona  updatePersona = iPersonaService.updatePersona(persona);
        return new ResponseEntity<>(updatePersona, HttpStatus.OK);
    }
    /* @PreAuthorize("hasRole('ADMIN')") */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Persona> deletePersona(@PathVariable("id") Long id){
        iPersonaService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
