package com.portfolioweb.nancy.dto;

public class ExperienciaDto {
    private String cargo;
    private String nombre_empresa;
    private String fecha_inicio;
    private String fecha_fin;
    private Boolean es_trabajo_actual;
    private String descripcion;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String cargo, String nombre_empresa, String fecha_inicio, String fecha_fin, Boolean es_trabajo_actual, String descripcion) {
        this.cargo = cargo;
        this.nombre_empresa = nombre_empresa;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.es_trabajo_actual = es_trabajo_actual;
        this.descripcion = descripcion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }


    public Boolean getEs_trabajo_actual() {
        return es_trabajo_actual;
    }

    public void setEs_trabajo_actual(Boolean es_trabajo_actual) {
        this.es_trabajo_actual = es_trabajo_actual;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
