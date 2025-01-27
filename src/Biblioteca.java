public class Biblioteca {
    public static void main(String[] args) {

        //Hay que hacer un menu


        GestorUsuarios gestor = new GestorUsuarios();

        // Crear usuarios
        Usuario admn = new Usuario("Administrador", "admn@example.com", "admn1234", true);
        Usuario user1 = new Usuario("Carla Leon", "carla@example.com", "contrasenia1", false);
        Usuario user2 = new Usuario("Ana Lopez", "ana@example.com", "contrasenia2", false);
        Usuario user3 = new Usuario("Juan Gomez", "juan@example.com", "contrasenia3", false);

        // Registrar administrador directamente
        gestor.nuevoUsuario(admn);

        // Registrar usuarios (requiere un administrador)
        if (gestor.registrarUsuario(user1, "admn@example.com", "admn1234")) {
            System.out.println("Usuario 1 registrado correctamente.");
        } else {
            System.out.println("Error al registrar Usuario 1.");
        }

        if (gestor.registrarUsuario(user2, "admn@example.com", "admin1234")) {
            System.out.println("Usuario 2 registrado correctamente.");
        } else {
            System.out.println("Error al registrar Usuario 2.");
        }

        // Consultar usuarios registrados (como administrador)
        String usuarios = gestor.consultarUsuarios("admn@example.com", "admn1234");
        if (usuarios != null) {
            System.out.println("Usuarios registrados:\n" + usuarios);
        } else {
            System.out.println("No tienes permisos para consultar usuarios.");
        }
    }
        
        
    }

