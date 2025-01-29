import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        GestionUsuarios gestor = new GestionUsuarios();

        //Crear usuarios
        Usuario admin = new Usuario("Administrador", "admn@example.com", "admn1234", true);
        Usuario usuario1 = new Usuario("Carla Leon", "carla@example.com", "contrasenia1", false);
        Usuario usuario2 = new Usuario("Ana Lopez", "ana@example.com", "contrasenia2", false);
        Usuario usuario3 = new Usuario("Juan Gomez", "juan@example.com", "contrasenia3", false);

        //Registrar administrador 
        gestor.nuevoUsuario(admin);

        //Menú
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = obtenerOpcion(teclado);

            //Registrar usuarios
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
                //Salir del programa
                System.out.println("Saliendo del programa... Chao!!");
                continuar = false;
            } else {
                System.out.println("Opción no válida, por favor intentelo de nuevo.");
            }
        }

        teclado.close();
    }

    //Mostrar menú 
    public static void mostrarMenu1() {
        System.out.println("Menú Principal");
        System.out.println("1) Registrar Usuarios");
        System.out.println("2) Consultar Usuarios");
        System.out.println("3) Salir");
        System.out.print("Seleccione una opción: ");
    }

    //Leer la opción seleccionada por el usuario
    public static int obtenerOpcion(Scanner teclado) {
        while (!teclado.hasNextInt()) {
            System.out.println("Inserte un número válido!.");
            teclado.next();
        }

        return teclado.nextInt();
    }

    public void mostrarMenu(){
        System.out.println("Elige una opcion \n"
        +"1. Gestionar Libros \n"
        +"2. Gestionar Usuarios \n"
        +"3. Gestionar Prestamos \n"
        +"4. Estadisticas y Reportes \n"
        +"5. Salir");
    }
}
    
