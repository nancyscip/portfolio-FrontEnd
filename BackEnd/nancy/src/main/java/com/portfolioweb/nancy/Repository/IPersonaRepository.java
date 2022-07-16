package com.portfolioweb.nancy.Repository;

import com.portfolioweb.nancy.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    void deletePersonaById(Long id);

    Persona findPersonaById(Long id);
}
