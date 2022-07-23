package com.portfolioweb.nancy.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Experiencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "id", nullable = false)
    private Long id;

    private String cargo;
    private String nombre_empresa;
    private String fecha_inicio;
    private String fecha_fin;
    private Boolean es_trabajo_actual;
    private String descripcion;
    
    public Experiencia(){}

    public Experiencia(Long id, String cargo, String nombre_empresa, String fecha_inicio, String fecha_fin, Boolean es_trabajo_actual, String descripcion){
        this.id = id;
        this.cargo = cargo;
        this.nombre_empresa = nombre_empresa;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.es_trabajo_actual = es_trabajo_actual;
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return "Experiencia{" +
                "id=" + id +
                ",cargo=" + cargo +
                ",nombre_empresa=" + nombre_empresa +
                ",fecha_inicio=" + fecha_inicio +
                ",fecha_fin=" + fecha_fin +
                ",es_trabajo_actual=" + es_trabajo_actual +
                ",descripcion=" + descripcion + '\'' +
                '}';
    }
}
