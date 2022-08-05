
package com.portfolioweb.nancy.Entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity

public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;


    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String sobre_mi;
    private String domicilio;
    private String img;
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Estudios.class)
    @JoinColumn(name = "ed_fk", referencedColumnName = "id")
    private List<Estudios> estudiosList;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Experiencia.class)
    @JoinColumn(name = "ex_fk", referencedColumnName = "id")
    private List<Experiencia> experienciaList;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Skills.class)
    @JoinColumn(name = "sk_fk", referencedColumnName = "id")
    private List<Skills> skillsList;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Proyectos.class)
    @JoinColumn(name = "pr_fk", referencedColumnName = "id")
    private List<Proyectos> proyectosList;

    public Persona(){
    }
    public Persona(Long id, String nombre, String apellido, String telefono, String correo, String sobre_mi, String img, String titulo, List<Estudios> estudiosList, List<Experiencia> experienciaList, List<Skills> skillsList, List<Proyectos> proyectosList ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.sobre_mi = sobre_mi;
        this.domicilio = domicilio;
        this.img = img;
        this.titulo = titulo;
        this.estudiosList = estudiosList;
        this.experienciaList = experienciaList;
        this.skillsList = skillsList;
        this.proyectosList = proyectosList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSobre_mi() {
        return sobre_mi;
    }

    public void setSobre_mi(String sobre_mi) {
        this.sobre_mi = sobre_mi;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Estudios> getEstudiosList() {
        return estudiosList;
    }

    public void setEstudiosList(List<Estudios> estudiosList) {
        this.estudiosList = estudiosList;
    }

    public List<Experiencia> getExperienciaList() {
        return experienciaList;
    }

    public void setExperienciaList(List<Experiencia> experienciaList) {
        this.experienciaList = experienciaList;
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", sobre_mi='" + sobre_mi + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", img='" + img + '\'' +
                ", titulo='" + titulo + '\'' +
                ", estudiosList=" + estudiosList +
                ", experienciaList=" + experienciaList +
                ", skillsList=" + skillsList +
                ", proyectosList=" + proyectosList +
                '}';
    }
}

