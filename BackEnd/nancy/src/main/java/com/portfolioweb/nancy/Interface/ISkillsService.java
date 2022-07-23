package com.portfolioweb.nancy.Interface;

import com.portfolioweb.nancy.Entity.Skills;
import com.portfolioweb.nancy.Repository.ISkillsRepository;
import com.portfolioweb.nancy.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ISkillsService {

    private final ISkillsRepository iskillsRepository;

    @Autowired
    public ISkillsService(ISkillsRepository iskillsRepository) {
        this.iskillsRepository = iskillsRepository;
    }

    public Skills addSkill(Skills skill) {
        return iskillsRepository.save(skill);
    }

    public List<Skills> findAllSkills() {
        return iskillsRepository.findAll();
    }

    public Skills updateSkills(Skills skill) {
        return iskillsRepository.save(skill);
    }

    public void deleteSkill(Long id) {
        iskillsRepository.deleteSkillById(id);
    }


    public Skills findSkillById(Long id) {
        return iskillsRepository.findSkillById(id).orElseThrow(() -> new UserNotFoundException("La habilidad de id" + id + "no fue encontrada"));
    }
}
