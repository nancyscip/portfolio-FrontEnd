package com.portfolioweb.nancy.security.repository;

import com.portfolioweb.nancy.security.entity.Rol;
import com.portfolioweb.nancy.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
