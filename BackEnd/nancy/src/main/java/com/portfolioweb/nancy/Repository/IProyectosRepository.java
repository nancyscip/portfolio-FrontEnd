package com.portfolioweb.nancy.Repository;

import com.portfolioweb.nancy.Entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos, Long> {
    void deleteProyectoById(Long id);

    Optional<Proyectos> findProyectoById(Long id);
}
