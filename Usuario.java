package com.mycompany.gestorbiblioteca;

public class Usuario {
    private String nombre;
    private int id;

    // Constructor
    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
