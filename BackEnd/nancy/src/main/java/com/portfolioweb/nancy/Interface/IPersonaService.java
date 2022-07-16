package com.portfolioweb.nancy.Interface;

import com.portfolioweb.nancy.Entity.Persona;
import com.portfolioweb.nancy.Repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
@Service
public class IPersonaService {
    private final IPersonaRepository iPersonaRepository;

    @Autowired
    public IPersonaService(IPersonaRepository ipersonaRepository) {
        this.iPersonaRepository = ipersonaRepository;
    }

    public Persona addPersona(Persona persona){
        return iPersonaRepository.save(persona);
    }

    public List<Persona> findAllPersonas(){
        return iPersonaRepository.findAll();
    }

    public Persona updatePersona(Persona persona){
        return iPersonaRepository.save(persona);
    }
    
    public void deletePersona(Long id){
        iPersonaRepository.deletePersonaById(id);
    }

    public Persona findPersonaById(Long id) {
        return iPersonaRepository.findPersonaById(id);
    }

}
