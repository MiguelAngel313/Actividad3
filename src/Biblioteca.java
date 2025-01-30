import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        GestionUsuarios gestor = new GestionUsuarios();

        // Crear usuarios
        Usuario admin = new Usuario("Administrador", "admn@example.com", "admn1234", true);
        Usuario usuario1 = new Usuario("Carla Leon", "carla@example.com", "contrasenia1", false);
        Usuario usuario2 = new Usuario("Ana Lopez", "ana@example.com", "contrasenia2", false);
        Usuario usuario3 = new Usuario("Juan Gomez", "juan@example.com", "contrasenia3", false);

        // Libro de prueba
        Libro libro1 = new Libro(01, "El quijote", "Miguel De Cervantes", 789, "Ficcion", false, 0);
        ArrayList<Libro> libros = new ArrayList<Libro>();
        libros.add(libro1);

        // Registrar administrador
        gestor.nuevoUsuario(admin);

        // Menú
        mostrarMenu(admin, libros);

        boolean continuar = true;
        while (continuar) {

            int opcion = obtenerOpcion(teclado);

            // Registrar usuarios
            if (opcion == 1) {
                if (gestor.registrarUsuario(usuario1, "admn@example.com", "admn1234")) {
                    System.out.println("El Usuario 1 esta registrado!");
                } else {
                    System.out.println("Error al registrar Usuario 1!!!");
                }

                if (gestor.registrarUsuario(usuario2, "admn@example.com", "admin1234")) {
                    System.out.println("El Usuario 2 esta registrado!");
                } else {
                    System.out.println("Error al registrar Usuario 2!!!");
                }

                if (gestor.registrarUsuario(usuario3, "admn@example.com", "admin1234")) {
                    System.out.println("El Usuario 3 esta registrado!");
                } else {
                    System.out.println("Error al registrar Usuario 3!!!");
                }

            } else if (opcion == 2) {
                // Consultar usuarios registrados (como administrador)
                String usuarios = gestor.consultarUsuarios("admn@example.com", "admn1234");
                if (usuarios != null) {
                    System.out.println("Usuarios registrados:\n" + usuarios);
                } else {
                    System.out.println("No tienes permisos para consultar usuarios.");
                }
            } else if (opcion == 3) {
                // Salir del programa
                System.out.println("Saliendo del programa... Chao!!");
                continuar = false;
            } else {
                System.out.println("Opción no válida, por favor intentelo de nuevo.");
            }
        }

        teclado.close();
    }

    // Leer la opción seleccionada por el usuario
    public static int obtenerOpcion(Scanner teclado) {
        while (!teclado.hasNextInt()) {
            System.out.println("Inserte un número válido!.");
            teclado.next();
        }

        return teclado.nextInt();
    }

    public static void mostrarMenu(Usuario user, ArrayList<Libro> libros) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 5) {

            System.out.println("Elige una opcion \n"
                    + "1. Gestionar Libros \n"
                    + "2. Gestionar Usuarios \n"
                    + "3. Gestionar Prestamos \n"
                    + "4. Estadisticas y Reportes \n"
                    + "5. Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    menuGestionarLibros(user, libros);

                break;
                
                case 2: //crear funcion de usuario
                
                break;

                case 3:
                    menuGestionarPrestamos(libros);
                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Opcion elegida: \n" + "SALIR");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }

    }

    public static void menuGestionarLibros(Usuario user, ArrayList<Libro> libros) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            GestionLibros gestor = new GestionLibros();
            System.out.println("Elige una opcion: \n"
                    + "1. Agregar libros nuevos (Admin) \n"
                    + "2. Eliminar libros existentes (Admin) \n"
                    + "3. Buscar libro por titulo, autor o categoria \n"
                    + "4. Mostrar todos los libros disponibles \n"
                    + "5. Volver a menu principal");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    gestor.agregarLibrosNuevos(user);
                    break;
                case 2:
                    System.out.println("Introduce un id del libro que desea eliminar:");
                    int id = entrada.nextInt();
                    gestor.eliminarLibrosExistentes(user, id, libros);
                    break;
                case 3:
                    gestor.buscarLibro(libros);
                    break;
                case 4:
                    gestor.todosLosLibros(libros);
                    break;

                case 5:
                    System.out.println("Volviendo al menu principal...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }

    }

    public static void menuGestionarPrestamos(ArrayList<Libro> libros) {
        GestionPrestamos gestor = new GestionPrestamos();
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        int id;

        while (opcion != 4) {
            System.out.println("Elige una opcion: \n"
                    + "1. Realizar prestamo de un libro \n"
                    + "2. Devolver libro prestado \n"
                    + "3. Mostrar libros prestados \n"
                    + "4. Volver al menu principal");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el id de libro que se va a prestar:");
                    id = entrada.nextInt();
                    gestor.realizarPrestamosLibros(libros, id);
                    break;
                case 2:
                    System.out.println("Introduce el id del libro que desea devolver:");
                    id = entrada.nextInt();
                    gestor.devolverLibroPrestado(libros, id);
                    break;
                case 3:
                    gestor.mostrarLibrosPrestados(libros);
                    break;
                case 4:
                    System.out.println("Volviendo al menu principal...");

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }
    //Crear aqui la funcion de gestion de Usuario.
}
