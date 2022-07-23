package com.portfolioweb.nancy.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Proyectos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String img;
    private String github;
    private String proyecto;

    public Proyectos(){
    }

    public Proyectos(Long id, String nombre, String descripcion, String fecha, String img, String github, String proyecto){
        this.id = id;
        this.nombre = nombre;
    this.descripcion = descripcion;
    this.fecha = fecha;
    this.img = img;
    this.github = github;
    this.proyecto = proyecto;
    }

    @Override
    public String toString(){
        return "Proyectos {" +
                "id=" + id + '\'' +
                "nombre=" + nombre + '\'' +
                "descripcion=" + descripcion + '\'' +
                "fecha=" + fecha + '\'' +
                "img=" + img + '\'' +
                "github=" + github + '\'' +
                "proyecto=" + proyecto +  '\'' +
                '}';
    }
}
