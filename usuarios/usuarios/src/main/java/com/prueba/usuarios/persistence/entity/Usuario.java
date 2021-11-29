package com.prueba.usuarios.persistence.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre", unique = true)
    private String nombre;

    @Column(name="activo")
    private Character activo;

    
    @ManyToOne
    @JoinColumn(name="id_rol", insertable = false, updatable = false)
    private Rol rol;

    public Usuario(Integer idUser, String nombre, Character activo, Integer idRol) {
        this.id = idUser;
        this.nombre = nombre;
        this.activo = activo;
      
    }

    public Usuario() {
    }

    public Integer getIdUser() {
        return id;
    }

    public void setIdUser(Integer idUser) {
        this.id = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol2) {
        this.rol=rol2;
    }

  
    
}
