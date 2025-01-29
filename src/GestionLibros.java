import java.util.ArrayList;
import java.util.Scanner;

public class GestionLibros {

    public Libro agregarLibrosNuevos(Usuario user) {
        if (user.isAdmin()) {

            Scanner entrada = new Scanner(System.in);

            Libro libro = new Libro(0, null, null, 0, null, false, 0);

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
            entrada.close();
            return libro;
        } else {
            return null;
        }
    }

    public ArrayList<Libro> eliminarLibrosExistentes(Usuario user, int idLibro, ArrayList<Libro> libros) {

        if (user.isAdmin()) {

            for (Libro libro : libros) {
                if (libro.getIdLibro() == idLibro) {
                    libros.remove(libro);
                }
            }
        }
        return libros;
    }

    public void buscarLibro(ArrayList <Libro> libros){
        Scanner entrada=new Scanner(System.in);
        System.out.println("Elige el valor por el que  quieres buscar el libro: \n"
        +"1. Titulo \n"+"2. Autor \n"+"3. Categoria \n"+"Elige una opcion:");
        int opcion=entrada.nextInt();

        switch(opcion){
            case 1:
            System.out.println("Introduce un titulo:");
            String titulo=entrada.next();
                for (Libro libro : libros) {
                    if (titulo.equalsIgnoreCase(libro.getTitulo())) {
                        System.out.println(libro.toString());
                    }
                }
                break;
            case 2:
                System.out.println("Introduce un autor:");
                String autor=entrada.next();
                for (Libro libro : libros) {
                    if (autor.equalsIgnoreCase(libro.getAutor())) {
                        System.out.println(libro.toString());
                    }
                }
            break;
            case 3:
                System.out.println("Introduce una categoria:");
                String categoria=entrada.next();
                for (Libro libro : libros) {
                    if (categoria.equalsIgnoreCase(libro.getCategoria())) {
                        System.out.println(libro.toString());
                    }
                }
            break;

            default:
            System.out.println("Esa opcion no es valida:");

        }
        entrada.close();
    }

    public void todosLosLibros(ArrayList<Libro> libros){
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }
}
