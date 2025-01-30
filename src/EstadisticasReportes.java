import java.util.ArrayList;

public class EstadisticasReportes {

    public void mostrarPrestamosTotalesyActivos(ArrayList<Libro> libros, ArrayList<Usuario> users) {
        int prestamosTotales = 0;
        int prestamosActivos = 0;

        for (Libro libro : libros) {
            prestamosTotales += libro.getNumVecesPrestado();
        }

        for (Usuario usuario : users) {
            prestamosActivos += usuario.getNumeroDePrestamosActivos();
        }

        System.out.println("->Prestamos Totales: \n" + prestamosTotales);
        System.out.println("->Prestamos Activos: \n" + prestamosActivos);
    }

    public void mostrarLibrosMasPrestados(ArrayList<Libro> libros) {

        int mayor = 0;
        Libro libro1 = null;
        Libro libro2 = null;

        for (Libro libro : libros) {
            if (libro.getNumVecesPrestado() > mayor) {
                libro1 = libro;
                mayor = libro.getNumVecesPrestado();
            }
        }

        mayor = 0;

        for (Libro libro : libros) {
            if (libro != libro1) {
                if (libro.getNumVecesPrestado() > mayor) {
                    libro2 = libro;
                    mayor = libro.getNumVecesPrestado();
                }
            }
        }
        System.out.println("Libros mas prestados: \n" + libro1.getTitulo() + "\n" + libro2.getTitulo());

    }

    public void usuarioMasPrestamosActivos(ArrayList<Usuario> users) {

        int mayor = 0;
        Usuario user = null;

        for (Usuario usuario : users) {
            if (usuario.getNumeroDePrestamosActivos() > mayor) {
                user = usuario;
                mayor = usuario.getNumeroDePrestamosActivos();
            }
        }

        System.out.println("Usuario con mas prestamos activos: \n" + user.toString());
    }

}
