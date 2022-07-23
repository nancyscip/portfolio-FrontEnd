package com.portfolioweb.nancy.Interface;

import com.portfolioweb.nancy.Entity.Estudios;
import com.portfolioweb.nancy.Repository.IEstudiosRepository;
import com.portfolioweb.nancy.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IEstudiosService {
    private final IEstudiosRepository iestudiosRepository;

    @Autowired
    public IEstudiosService(IEstudiosRepository iestudiosRepository){
        this.iestudiosRepository = iestudiosRepository;
    }

    public Estudios addEstudio(Estudios estudio) {
        return iestudiosRepository.save(estudio);
    }

    public List<Estudios> findAllEstudios() {
        return iestudiosRepository.findAll();
    }

    public Estudios updateEstudios(Estudios estudio) {
        return iestudiosRepository.save(estudio);
    }

    public void deleteEstudios(Long id) {
        iestudiosRepository.deleteEstudiosById(id);
    }


    public Estudios findEstudiosById(Long id) {
        return iestudiosRepository.findEstudiosById(id).orElseThrow(() -> new UserNotFoundException("El curso de id" + id + "no fue encontrado"));
    }
}
