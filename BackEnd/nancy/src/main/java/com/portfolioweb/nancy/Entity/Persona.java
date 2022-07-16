
package com.portfolioweb.nancy.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter @Setter
@Entity
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(nullable = false, updatable = false)
    private Long id;
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String sobre_mi;
    private String domicilio;
    private String img;
    private String titulo;
    
    public Persona(){
    }
    public Persona(Long id, String nombre, String apellido, String telefono, String correo, String sobre_mi, String img, String titulo){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.sobre_mi = sobre_mi;
        this.domicilio = domicilio;
        this.img = img;
        this.titulo = titulo;
    }
    
    @Override
    public String toString(){
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido=" + apellido + '\'' +
                ", telefono=" + telefono + '\'' +
                ", correoo=" + correo + '\'' +
                ", sobre_mi=" + sobre_mi + '\'' +
                ", domicilio=" + domicilio + '\'' +
                ", img=" + img + '\'' +
                ", titulo=" + titulo + '\'' +
                '}';
    }

}
