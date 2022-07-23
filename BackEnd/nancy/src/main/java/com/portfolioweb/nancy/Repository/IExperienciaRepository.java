package com.portfolioweb.nancy.Repository;

import com.portfolioweb.nancy.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {
    void deleteExperienciaById(Long id);

    Optional<Experiencia> findExperienciaById(Long id);
}