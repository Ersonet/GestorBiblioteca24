package com.mycompany.gestorbiblioteca;

public class GestorBiblioteca {
    private Libro[] libros;
    private Usuario[] usuarios;
    private int librosSize;
    private int usuariosSize;
    private NodoArbol raiz;

    // Constructor
    public GestorBiblioteca() {
        libros = new Libro[10]; // Inicializamos con capacidad para 10 libros
        usuarios = new Usuario[10]; // Inicializamos con capacidad para 10 usuarios
        librosSize = 0;
        usuariosSize = 0;
        raiz = null;
    }

    // --------------------------Métodos para Libros-----------------------------

    // Método para agregar un libro al árbol
    public void agregarLibro(Libro libro) {
        raiz = agregarLibroRecursivo(raiz, libro);
    }

    private NodoArbol agregarLibroRecursivo(NodoArbol nodo, Libro libro) {
        if (nodo == null) {
            return new NodoArbol();
        }

        if (libro.getTitulo().compareToIgnoreCase(nodo.libro.getTitulo()) < 0) {
            nodo.izquierdo = agregarLibroRecursivo(nodo.izquierdo, libro);
        } else if (libro.getTitulo().compareToIgnoreCase(nodo.libro.getTitulo()) > 0) {
            nodo.derecho = agregarLibroRecursivo(nodo.derecho, libro);
        } else {
            // El libro ya existe, puedes manejar esto según lo necesites
            System.out.println("El Libro ya existe en el inventario");
        }

        return nodo;
    }

    // Método para buscar un libro por su título en el árbol
    public Libro buscarLibroPorTitulo(String titulo) {
        return buscarLibroPorTituloRecursivo(raiz, titulo);
    }

    private Libro buscarLibroPorTituloRecursivo(NodoArbol nodo, String titulo) {
        if (nodo == null) {
            return null;
        }

        if (titulo.compareToIgnoreCase(nodo.libro.getTitulo()) == 0) {
            return nodo.libro;
        } else if (titulo.compareToIgnoreCase(nodo.libro.getTitulo()) < 0) {
            return buscarLibroPorTituloRecursivo(nodo.izquierdo, titulo);
        } else {
            return buscarLibroPorTituloRecursivo(nodo.derecho, titulo);
        }
    }

    // Método para editar un libro por su título
    public boolean editarLibro(String tituloLibro, Libro nuevoLibro) {
        for (int i = 0; i < librosSize; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(tituloLibro)) {
                libros[i] = nuevoLibro;
                return true;
            }
        }
        return false; // Libro no encontrado
    }

    // Método para eliminar un libro por su título
    public boolean eliminarLibro(String nombreLibro) {
        for (int i = 0; i < librosSize; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(nombreLibro)) {
                // Eliminamos el libro moviendo los elementos posteriores
                for (int j = i; j < librosSize - 1; j++) {
                    libros[j] = libros[j + 1];
                }
                librosSize--;
                return true;
            }
        }
        return false; // Libro no encontrado
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

    // ---------------------Métodos para Usuarios-------------------------------

    // Método para registrar un usuario
    public void registrarUsuario(Usuario usuario) {
        if (usuariosSize == usuarios.length) {
            // Si el arreglo de usuarios está lleno, ampliamos su capacidad
            Usuario[] newArray = new Usuario[usuarios.length * 2];
            System.arraycopy(usuarios, 0, newArray, 0, usuarios.length);
            usuarios = newArray;
        }
        usuarios[usuariosSize++] = usuario;
    }

    // Método para editar un usuario por su ID
    public boolean editarUsuarioPorId(int idUsuario, Usuario nuevoUsuario) {
        for (int i = 0; i < usuariosSize; i++) {
            if (usuarios[i].getId() == idUsuario) {
                usuarios[i] = nuevoUsuario;
                return true;
            }
        }
        return false; // Usuario no encontrado
    }

    // Método para eliminar un usuario por su nombre
    public boolean eliminarUsuarioPorNombre(String nombreUsuario) {
        for (int i = 0; i < usuariosSize; i++) {
            if (usuarios[i].getNombre().equalsIgnoreCase(nombreUsuario)) {
                // Eliminamos el usuario moviendo los elementos posteriores
                for (int j = i; j < usuariosSize - 1; j++) {
                    usuarios[j] = usuarios[j + 1];
                }
                usuariosSize--;
                return true;
            }
        }
        return false; // Usuario no encontrado
    }

    // Método para buscar un usuario por su nombre
    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (int i = 0; i < usuariosSize; i++) {
            if (usuarios[i].getNombre().equalsIgnoreCase(nombre)) {
                return usuarios[i];
            }
        }
        return null;
    }

    // Método para buscar un usuario por su ID
    public Usuario buscarUsuarioPorId(int id) {
        for (int i = 0; i < usuariosSize; i++) {
            if (usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }
        return null; // Usuario no encontrado
    }

}