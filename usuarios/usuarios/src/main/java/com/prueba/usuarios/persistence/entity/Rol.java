package com.prueba.usuarios.persistence.entity;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idRol;

    @Column(name="nombre", unique = true)
    private String nombre; 

    /* @OneToMany(mappedBy ="rol")
    private Usuario usuarios;
 */
        
    public Rol() {
    }

    public Rol(Integer idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
        
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    } */
    
}
