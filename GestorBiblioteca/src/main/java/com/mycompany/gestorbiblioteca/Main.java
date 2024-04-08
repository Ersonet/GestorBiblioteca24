/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorbiblioteca;

/**
 *
 * @author Josea
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del gestor de biblioteca
        GestorBiblioteca gestor = new GestorBiblioteca();

        // Menú
        int opcion;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("======= Menú =======");
            System.out.println("1. Administrar libros");
            System.out.println("2. administrar usuarios");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            if(opcion == 1){
                System.out.println("======= Admin Libros =======");
                System.out.println("1. Agregar libro");
                System.out.println("2. Buscar libro");
                System.out.println("3. Pedir Libro");
                System.out.println("4. Devolver Libro");
                System.out.println("5. Eliminar Libro");
                System.out.println("6. Editar Libro");
                System.out.print("Seleccione una opción: ");
                scanner.nextLine(); // Limpiar el buffer del teclado
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        agregarLibro(gestor, scanner);
                        break;
                    case 2:
                        buscarLibroPorTitulo(gestor, scanner);
                        break;
                    case 3:
                        pedirLibro(gestor, scanner);
                        break;
                    case 4:
                        devolverLibro(gestor, scanner);
                        break;
                    case 5:
                        eliminarLibro(gestor, scanner);
                        break;
                    case 6:
                        editarLibroPorTitulo(gestor, scanner);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa");
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            } else if (opcion == 2){
                System.out.println("======= Admin cliente =======");
                System.out.println("1. Agregar Cliente");
                System.out.println("2. Buscar Cliente");
                System.out.println("3. Editar Usuario");
                System.out.println("4. Eliminar Usuario");
                System.out.print("Seleccione una opción: ");
                scanner.nextLine(); // Limpiar el buffer del teclado
                opcion = scanner.nextInt();
      
                switch (opcion) {

                case 1:
                    agregarUsuario(gestor, scanner);
                    break;
                case 2:
                    buscarUsuarioPorNombre(gestor, scanner);
                    break;
                case 3:
                    editarUsuarioPorId(gestor, scanner);
                    break;
                case 4:
                    eliminarUsuarioPorNombre(gestor, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            }
        } while (opcion != 0);
        
        scanner.close();
    }

    // Método para agregar un libro
    private static void agregarLibro(GestorBiblioteca gestor, Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer del teclado
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el código del libro: ");
        int codigo = scanner.nextInt();
        System.out.print("Ingrese la cantidad de libros: ");
        int cantidad = scanner.nextInt();
        gestor.agregarLibro(new Libro(titulo, autor, codigo, cantidad));
        System.out.println("Libro(s) agregado(s) correctamente.");
    }
    
    private static void editarLibroPorTitulo(GestorBiblioteca gestor, Scanner scanner) {
    scanner.nextLine(); // Limpiar el buffer del teclado
    System.out.print("Ingrese el título del libro que desea editar: ");
    String tituloLibro = scanner.nextLine();

    Libro libroExistente = gestor.buscarLibroPorTitulo(tituloLibro);
        if (libroExistente != null) {
            System.out.print("Ingrese el nuevo título del libro: ");
            String nuevoTitulo = scanner.nextLine();
            System.out.print("Ingrese el nuevo autor del libro: ");
            String nuevoAutor = scanner.nextLine();
            System.out.print("Ingrese el nuevo código del libro: ");
            int nuevoCodigo = scanner.nextInt();
            System.out.print("Ingrese la nueva cantidad de libros: ");
            int nuevaCantidad = scanner.nextInt();

            Libro nuevoLibro = new Libro(nuevoTitulo, nuevoAutor, nuevoCodigo, nuevaCantidad);
            boolean editado = gestor.editarLibro(tituloLibro, nuevoLibro);
                if (editado) {
                    System.out.println("Libro editado correctamente.");
                } else {
                    System.out.println("El libro no se encuentra en la biblioteca.");
                }
        } else {
            System.out.println("El libro no se encuentra en la biblioteca.");
        }
    }


    // Método para agregar un usuario
    private static void agregarUsuario(GestorBiblioteca gestor, Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer del teclado
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del usuario: ");
        int id = scanner.nextInt();
        gestor.registrarUsuario(new Usuario(nombre, id));
        System.out.println("Usuario agregado correctamente.");
    }
    
    private static void editarUsuarioPorId(GestorBiblioteca gestor, Scanner scanner) {
    System.out.print("Ingrese el ID del usuario que desea editar: ");
    int idUsuario = scanner.nextInt();
    scanner.nextLine(); // Limpiar el buffer del teclado

    Usuario usuarioExistente = gestor.buscarUsuarioPorId(idUsuario);
        if (usuarioExistente != null) {
            System.out.print("Ingrese el nuevo nombre del usuario: ");
            String nuevoNombre = scanner.nextLine();

            Usuario nuevoUsuario = new Usuario(nuevoNombre, idUsuario);
            boolean editado = gestor.editarUsuarioPorId(idUsuario, nuevoUsuario);
                if (editado) {
                    System.out.println("Usuario editado correctamente.");
                } else {
                    System.out.println("El usuario no se encuentra registrado en la biblioteca.");
                }
        } else {
            System.out.println("El usuario no se encuentra registrado en la biblioteca.");
        }
    }
    
    private static void eliminarUsuarioPorNombre(GestorBiblioteca gestor, Scanner scanner) {
    scanner.nextLine(); // Limpiar el buffer del teclado
    System.out.print("Ingrese el nombre del usuario que desea eliminar: ");
    String nombreUsuario = scanner.nextLine();

    boolean eliminado = gestor.eliminarUsuarioPorNombre(nombreUsuario);
        if (eliminado) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("El usuario no se encuentra registrado en la biblioteca.");
        }
    }

    // Método para buscar un libro por su título
    private static void buscarLibroPorTitulo(GestorBiblioteca gestor, Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer del teclado
        System.out.print("Ingrese el título del libro a buscar: ");
        String titulo = scanner.nextLine();
        Libro libroEncontrado = gestor.buscarLibroPorTitulo(titulo);
            if (libroEncontrado != null) {
                System.out.println("Libro encontrado:");
                System.out.println("Título: " + libroEncontrado.getTitulo());
                System.out.println("Autor: " + libroEncontrado.getAutor());
                System.out.println("Código: " + libroEncontrado.getCodigo());
                System.out.println("Cantidad: " + libroEncontrado.getCantidad());
            } else {
                System.out.println("Libro no encontrado.");
            }
    }
    
    // Método para eliminar libros
    private static void eliminarLibro(GestorBiblioteca gestor, Scanner scanner) {
    scanner.nextLine(); // Limpiar el buffer del teclado
    System.out.print("Ingrese el nombre del libro que desea eliminar: ");
    String nombreLibro = scanner.nextLine();

    boolean eliminado = gestor.eliminarLibro(nombreLibro);
        if (eliminado) {
            System.out.println("Libro eliminado correctamente.");
        } else {
            System.out.println("El libro no se encuentra en la biblioteca.");
        }
    }


    // Método para buscar un usuario por su nombre
    private static void buscarUsuarioPorNombre(GestorBiblioteca gestor, Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer del teclado
        System.out.print("Ingrese el nombre del usuario a buscar: ");
        String nombre = scanner.nextLine();
        Usuario usuarioEncontrado = gestor.buscarUsuarioPorNombre(nombre);
        if (usuarioEncontrado != null) {
            System.out.println("Usuario encontrado:");
            System.out.println("Nombre: " + usuarioEncontrado.getNombre());
            System.out.println("ID: " + usuarioEncontrado.getId());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
    
    private static void pedirLibro(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del teclado

        // Verificar si el usuario está registrado
        Usuario usuario = gestor.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("El usuario no está registrado en la biblioteca.");
            return;
        }

        System.out.print("Ingrese el título del libro que desea pedir prestado: ");
        String tituloLibro = scanner.nextLine();

        boolean prestado = gestor.prestarLibro(idUsuario, tituloLibro);
        if (prestado) {
            System.out.println("Libro prestado correctamente.");
        } else {
            System.out.println("El libro no está disponible o no se encuentra en la biblioteca.");
        }
    }

    
    private static void devolverLibro(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del teclado
        System.out.print("Ingrese el título del libro que desea devolver: ");
        String tituloLibro = scanner.nextLine();
    
    boolean devuelto = gestor.devolverLibro(idUsuario, tituloLibro);
        if (devuelto) {
            System.out.println("Libro devuelto correctamente.");
        } else {
            System.out.println("El libro no fue prestado por este usuario o no se encuentra en la biblioteca.");
        }
    }
}
