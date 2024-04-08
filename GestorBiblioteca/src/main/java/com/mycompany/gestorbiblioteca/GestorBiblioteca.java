/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorbiblioteca;

/**
 *
 * @author Josea
 */

import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    // Constructor
    public GestorBiblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    // Método para añadir un libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // En la clase GestorBiblioteca
    public boolean eliminarLibro(String nombreLibro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(nombreLibro)) {
                libros.remove(i);
                return true;
            }
        }
        return false; // Libro no encontrado
    }


    // Método para buscar un libro por su título
    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
    
    // Método para editar un libro por su título
    public boolean editarLibro(String tituloLibro, Libro nuevoLibro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(tituloLibro)) {
                libros.set(i, nuevoLibro);
                return true;
            }
        }
        return false; // Libro no encontrado
    }

    // Método para registrar un usuario
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    // Método para editar un usuario por su ID
    public boolean editarUsuarioPorId(int idUsuario, Usuario nuevoUsuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == idUsuario) {
                usuarios.set(i, nuevoUsuario);
                return true;
            }
        }
        return false; // Usuario no encontrado
    }
    
    // Método para eliminar un usuario por su nombre
    public boolean eliminarUsuarioPorNombre(String nombreUsuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equalsIgnoreCase(nombreUsuario)) {
                usuarios.remove(i);
                return true;
            }
        }
        return false; // Usuario no encontrado
    }

    // Método para buscar un usuario por su nombre
    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    // Método para prestar un libro a un usuario
    public boolean prestarLibro(int idUsuario, String tituloLibro) {
        Libro libro = buscarLibroPorTitulo(tituloLibro);
        if (libro != null && libro.getCantidad() > 0) {
            libro.setCantidad(libro.getCantidad() - 1);
            return true;
        } else {
            return false; // Libro no encontrado o no disponible
        }
    }
    
    // Método buscar usuario por ID
    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado
    }
    
    // Método para devolver un libro
    public boolean devolverLibro(int idUsuario, String tituloLibro) {
        Libro libro = buscarLibroPorTitulo(tituloLibro);
        if (libro != null) {
            libro.setCantidad(libro.getCantidad() + 1);
            return true;
        } else {
            return false; // Libro no encontrado
        }
    }
}

