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

        // Menú Principal
        mostrarMenu(admin, libros, gestor, teclado);
        teclado.close();
    }
    

    public static void mostrarMenu(Usuario user, ArrayList<Libro> libros, GestionUsuarios gestor, Scanner teclado) {
    
        int opcion = 0;
        while (opcion != 5) {

            System.out.println("Elige una opcion \n"
                    + "1. Gestionar Libros \n"
                    + "2. Gestionar Usuarios \n"
                    + "3. Gestionar Prestamos \n"
                    + "4. Estadisticas y Reportes \n"
                    + "5. Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    menuGestionarLibros(user, libros, teclado);
                break;
                
                case 2: 
                    menuGestionarUsuarios(gestor, teclado);
                break;

                case 3:
                    menuGestionarPrestamos(libros, teclado);
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

    public static void menuGestionarLibros(Usuario user, ArrayList<Libro> libros, Scanner teclado) {
        GestionLibros gestor = new GestionLibros();
        int opcion = 0;

        while (opcion != 5) {

            System.out.println("Elige una opcion: \n"
                    + "1. Agregar libros nuevos (Admin) \n"
                    + "2. Eliminar libros existentes (Admin) \n"
                    + "3. Buscar libro por titulo, autor o categoria \n"
                    + "4. Mostrar todos los libros disponibles \n"
                    + "5. Volver a menu principal");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    gestor.agregarLibrosNuevos(user);
                    break;
                case 2:
                    System.out.println("Introduce un id del libro que desea eliminar:");
                    int id = teclado.nextInt();
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

    public static void menuGestionarPrestamos(ArrayList<Libro> libros, Scanner teclado) {
        GestionPrestamos gestor = new GestionPrestamos();
        
        int opcion = 0;
        int id;

        while (opcion != 4) {
            System.out.println("Elige una opcion: \n"
                    + "1. Realizar prestamo de un libro \n"
                    + "2. Devolver libro prestado \n"
                    + "3. Mostrar libros prestados \n"
                    + "4. Volver al menu principal");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el id de libro que se va a prestar:");
                    id = teclado.nextInt();
                    gestor.realizarPrestamosLibros(libros, id);
                    break;
                case 2:
                    System.out.println("Introduce el id del libro que desea devolver:");
                    id = teclado.nextInt();
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
    public static void menuGestionarUsuarios(GestionUsuarios gestor, Scanner teclado) {

        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Elige una opción: \n"
                    + "1. Registrar un nuevo usuario \n"
                    + "2. Eliminar un usuario \n"
                    + "3. Consultar usuarios registrados \n"
                    + "4. Volver al menú principal");
    
            opcion = obtenerOpcion(teclado);
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del nuevo usuario: ");
                    String nombre = teclado.nextLine();
    
                    System.out.println("Ingrese el correo electrónico: ");
                    String email = teclado.nextLine();
    
                    System.out.println("Ingrese una contrasenia: ");
                    String contrasena = teclado.nextLine();
    
                    System.out.println("¿Es administrador? ");
                    boolean esAdmin = teclado.nextBoolean();

                    Usuario nuevoUsuario = new Usuario(nombre, email, contrasena, esAdmin);
                    gestor.nuevoUsuario(nuevoUsuario);
                    System.out.println("El usuario fue registrado correctamente");

                break;

            case 2:
                System.out.println("Ingrese el correo electrónico del usuario a eliminar:");
                String correoEliminar = teclado.nextLine();

                if (gestor.eliminarUsuario(correoEliminar)) {
                    System.out.println("Usuario eliminado! ");
                } else {
                    System.out.println("No se encuentra el usuario!! ");
                }
                break;

            case 3:
                System.out.println("Ingrese su correo de administrador:");
                String correoAdmin = teclado.nextLine();

                System.out.println("Ingrese su contraseña de administrador:");
                String claveAdmin = teclado.nextLine();

                String listaUsuarios = gestor.consultarUsuarios(correoAdmin, claveAdmin);
                if (listaUsuarios != null) {
                    System.out.println("Usuarios registrados:\n" + listaUsuarios);
                } else {
                    System.out.println("No tiene permisos para consultar usuarios.");
                }
                break;

            case 4:
                System.out.println("Volviendo al menú principal...");
                break;

            default:
                System.out.println("Opción no válida, inténtelo de nuevo.");
                break;
        }
    }
    
}

 // Leer la opción seleccionada por el usuario
 public static int obtenerOpcion(Scanner teclado) {
    while (!teclado.hasNextInt()) {
        System.out.println("Inserte un número válido!.");
        teclado.next();
    }

    return teclado.nextInt();
}

}

