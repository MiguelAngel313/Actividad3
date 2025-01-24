import java.util.ArrayList;
import java.util.Scanner;

public class GestionLibros {

    public Libro agregarLibrosNuevos(Usuario user) {

        /*
         * Implementar condicional que me permita controlar si el usuario es admin o no
         */
        if (user.isAdmin()) {

            Scanner entrada = new Scanner(System.in);

            Libro libro = new Libro(0, null, null, 0, null);

            System.out.println("Introduce un Id:");
            libro.setIdLibro(entrada.nextInt());

            System.out.println("Introduce un Titulo:");
            libro.setTitulo(entrada.next());

            System.out.println("Introduce un autor");
            libro.setAutor(entrada.next());

            System.out.println("Introduce un numero de paginas:");
            libro.setNumeroPaginas(entrada.nextInt());

            System.out.println("Introduce una categoria:");
            libro.setCategoria(entrada.next());
            return libro;
        } else {
            return null;
        }
    }

    public ArrayList eliminarLibrosExistentes(Usuario user, int idLibro, ArrayList<Libro> libros) {

        if (user.isAdmin()) {

            for (Libro libro : libros) {
                if (libro.getIdLibro() == idLibro) {
                    libros.remove(libro);
                }
            }
            return libros;
        } else {
            return null;
        }
    }

    public void buscarLibro(ArrayList <Libro> libros){
        System.out.println("Elige el valor por el que quieres buscar el libro:");
    }
}
