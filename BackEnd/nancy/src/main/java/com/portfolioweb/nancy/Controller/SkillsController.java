package com.portfolioweb.nancy.Controller;

import com.portfolioweb.nancy.Entity.Skills;
import com.portfolioweb.nancy.Interface.ISkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/skills")
public class SkillsController {

    @Autowired
    ISkillsService iskillsService;

    @GetMapping("/all")
    public ResponseEntity<List<Skills>> findAllSkills() {
        List<Skills> skills = iskillsService.findAllSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Skills> findSkillsById(@PathVariable("id") Long id) {
        Skills skills = iskillsService.findSkillById(id);
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    /* @PreAuthorize("hasRole('ADMIN')") */
    @PostMapping("/add")
    public ResponseEntity<Skills> addSkill(@RequestBody Skills skills) {
        Skills newSkill = iskillsService.addSkill(skills);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    /* @PreAuthorize("hasRole('ADMIN')") */
    @PutMapping("/update")
    public ResponseEntity<Skills> updateSkills(@RequestBody Skills skill) {
        Skills updateSkills = iskillsService.updateSkills(skill);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }

    /* @PreAuthorize("hasRole('ADMIN')") */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") Long id) {
        iskillsService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
