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
public class Estudios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lugar;
    private String fecha_inicio;
    private String fecha_fin;
    private String titulo;
    private String img;

    public Estudios(){
    }

    public Estudios(Long id, String lugar, String fecha_inicio, String fecha_fin, String titulo, String img){
        this.id = id;
        this.lugar = lugar;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.titulo = titulo;
        this.img = img;
    }

    @Override
    public String toString(){
        return "Estudios {" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", lugar=" + lugar + '\'' +
                ", fecha_inicio=" + fecha_inicio + '\'' +
                ", fecha_fin=" + fecha_fin + '\'' +
                ", img=" + img + '\'' +
                '}';
    }
}
