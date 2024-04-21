package com.mycompany.gestorbiblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("======= Menú =======");
            System.out.println("1. Administrar libros");
            System.out.println("2. Administrar usuarios");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    administrarLibros(gestor, scanner);
                    break;
                case 2:
                    administrarUsuarios(gestor, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void administrarLibros(GestorBiblioteca gestor, Scanner scanner) {
        int opcion;
        do {
            System.out.println("======= Administrar Libros =======");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Pedir libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Editar libro");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarLibro(gestor, scanner);
                    break;
                case 2:
                    buscarLibroPorTitulo(gestor, scanner);
                    break;
                // Puedes añadir más casos según sea necesario
                case 0:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    private static void administrarUsuarios(GestorBiblioteca gestor, Scanner scanner) {
        int opcion;
        do {
            System.out.println("======= Administrar Usuarios =======");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Editar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
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
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    // -------------- Métodos para administrar libros---------------------------

    // Método para agregar libro

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

        Libro nuevoLibro = new Libro(titulo, autor, codigo, cantidad);
        gestor.agregarLibro(nuevoLibro);
        System.out.println("Libro agregado correctamente.");
    }

    // Meétodo para buscar por titulo
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

    // Método editar libro
    @SuppressWarnings("unused")
    private static void editarLibro(GestorBiblioteca gestor, Scanner scanner) {
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

    // Método eliminar libro
    @SuppressWarnings("unused")
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

    // Método para pedir libro
    @SuppressWarnings("unused")
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

    // Método devolver libro
    @SuppressWarnings("unused")
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

    // ----------------------Métodos para USUARIOS-------------------------------

    // Método agregar usuario
    private static void agregarUsuario(GestorBiblioteca gestor, Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer del teclado
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del usuario: ");
        int id = scanner.nextInt();
        gestor.registrarUsuario(new Usuario(nombre, id));
        System.out.println("Usuario agregado correctamente.");
    }

    // Método buscar usuario por nombre
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

    // Método editar usuario
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

    // Método eliminar usuario
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

    @Override
    public String toString() {
        return "Main []";
    }
}