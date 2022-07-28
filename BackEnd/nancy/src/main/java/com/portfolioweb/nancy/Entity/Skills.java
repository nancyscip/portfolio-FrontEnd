package com.portfolioweb.nancy.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String skill;
    private Integer porcentaje;

    private String img;

    public Skills(){}

    public Skills(Long id, String skill, Integer porcentaje, String img) {
        this.id = id;
        this.skill = skill;
        this.porcentaje = porcentaje;
        this.img = img;
    }

    public String getSkill(){ return skill; }

    public void setSkill (String skill) {this.skill = skill; }

    public Integer getPorcentaje() { return (Integer) porcentaje; }

    public void setPorcentaje (Integer porcentaje) {this.porcentaje = porcentaje;}

    public String getImg() { return img; }

    public void setImg (String img) {this.img = img;}
}

