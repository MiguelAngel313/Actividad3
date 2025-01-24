import java.util.ArrayList;
import java.util.Scanner;

public class GestionLibros {
    

    public Libro agregarLibrosNuevos(){

        /*Implementar condicional que me permita controlar si el usuario es admin o no*/
        Scanner entrada=new Scanner(System.in);
        Libro libro=new Libro(0, null, null, 0, null);
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
    }
}
