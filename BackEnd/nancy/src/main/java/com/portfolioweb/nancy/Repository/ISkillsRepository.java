package com.portfolioweb.nancy.Repository;

import com.portfolioweb.nancy.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISkillsRepository extends JpaRepository<Skills, Long> {
    void deleteSkillById(Long id);

    Optional<Skills> findSkillById(Long id);
}
