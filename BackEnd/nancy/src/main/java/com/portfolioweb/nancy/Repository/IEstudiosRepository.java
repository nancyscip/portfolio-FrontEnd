package com.portfolioweb.nancy.Repository;

import com.portfolioweb.nancy.Entity.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IEstudiosRepository extends JpaRepository<Estudios, Long> {
    void deleteEstudiosById(Long id);

    Optional<Estudios> findEstudiosById(Long id);
}