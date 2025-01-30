import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        GestionUsuarios gestor = new GestionUsuarios();

        // Crear usuarios
        Usuario admin = new Usuario("Administrador", "admn@example.com", "admn1234", true, 0);
        Usuario usuario1 = new Usuario("Carla_Leon", "carla@example.com", "contrasenia1", false, 0);
        Usuario usuario2 = new Usuario("Ana_Lopez", "ana@example.com", "contrasenia2", false, 0);
        Usuario usuario3 = new Usuario("Juan_Gomez", "juan@example.com", "contrasenia3", false, 0);
        Usuario usuarioSeleccionado = null;

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(admin);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        // Inicio de sesion
        usuarioSeleccionado = inicioDeSesion(usuarios);

        // Libro de prueba
        Libro libro1 = new Libro(1, "El_Quijote", "Miguel_De_Cervantes", 789, "Ficcion", false, 0);
        Libro libro2 = new Libro(2, "El_arte_de_la_guerra", "Tsun_Zu", 120, "Estrategia_militar", false, 0);
        Libro libro3 = new Libro(3, "Habitos_Atomicos", "James_Clear", 342, "Psicologia", false, 0);
        ArrayList<Libro> libros = new ArrayList<Libro>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        // Menú
        mostrarMenu(usuarioSeleccionado, libros, usuarios);

    }

    // Funciones---------------------------------------------------

    public static Usuario inicioDeSesion(ArrayList<Usuario> users) {
        Scanner entrada = new Scanner(System.in);
        String name, passwd;
        Usuario user = null;
        boolean inicio = false;
        while (!inicio) {
            System.out.println("    Inicio de Sesion \n" + "          ---- \n" + "Introduce un nombre de usuario:");
            name = entrada.next();
            System.out.println("Introduce una contrasenia:");
            passwd = entrada.next();

            for (Usuario usuario : users) {
                if (usuario.getNombre().equalsIgnoreCase(name) && usuario.getContrasenia().equalsIgnoreCase(passwd)) {
                    user = usuario;
                    inicio = true;
                    break;
                }
            }
            if (inicio) {
                System.out.println("Sesion iniciada correctamente.");
            } else {
                System.out.println("Usuario o contrasenia no validos.");
            }
        }
        return user;
    }

    public static void mostrarMenu(Usuario user, ArrayList<Libro> libros, ArrayList<Usuario> users) {
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

                case 2:

                    break;

                case 3:
                    menuGestionarPrestamos(libros, users);
                    break;

                case 4:
                    menuEstasisticasyReportes(users, libros);
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
                    gestor.agregarLibrosNuevos(user, libros);
                    break;
                case 2:
                    gestor.eliminarLibrosExistentes(user, libros);
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

    public static void menuGestionarPrestamos(ArrayList<Libro> libros, ArrayList<Usuario> users) {
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
                    gestor.realizarPrestamosLibros(libros, id, users);

                    break;
                case 2:
                    System.out.println("Introduce el id del libro que desea devolver:");
                    id = entrada.nextInt();
                    gestor.devolverLibroPrestado(libros, id, users);
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

    public static void menuEstasisticasyReportes(ArrayList<Usuario> users, ArrayList<Libro> libros){
            Scanner entrada=new Scanner(System.in);
            EstadisticasReportes gestor=new EstadisticasReportes();
            
            int opcion=0;

        while (opcion!=4) {
            System.out.println("Elige una opcion: \n"
            +"1. Mostrar numero de prestamos totales y activos \n"
            +"2. Mostrar libros mas prestados \n"
            +"3. Mostrar usuarios con mas prestamos activos \n"
            +"4. Volver al menu principal");

            opcion=entrada.nextInt();

            switch (opcion) {
                case 1:
                    gestor.mostrarPrestamosTotalesyActivos(libros, users);
                    break;
                case 2:
                    gestor.mostrarLibrosMasPrestados(libros);
                    break;
                case 3:
                    gestor.usuarioMasPrestamosActivos(users);
                    break;
                case 4:
                    System.out.println("Volviendo al menu principal...");
                    break;
            
                default:
                System.out.println("Opcion no valida.");
                    break;
            }
        }
    }
}
