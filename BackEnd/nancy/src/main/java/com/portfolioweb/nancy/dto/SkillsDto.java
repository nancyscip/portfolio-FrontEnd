package com.portfolioweb.nancy.dto;

public class SkillsDto {

    private String skill;
    private Number porcentaje;
    private String img;

    public SkillsDto(){
    }
    public SkillsDto(String skill, Number porcentaje, String img){
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
