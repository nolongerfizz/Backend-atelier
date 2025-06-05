package com.backend.BackEndAmigurimisAtelier.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    @JsonManagedReference
    private List<Usuario> usuarios = new ArrayList<>();

    public Rol() {
    }

    public Rol(Long idRol, String nombreRol, List<Usuario> usuarios) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.usuarios = usuarios;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


}
