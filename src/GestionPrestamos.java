import java.util.ArrayList;
import java.util.Scanner;

public class GestionPrestamos {
    
public void realizarPrestamosLibros(ArrayList<Libro> libros, int id, ArrayList<Usuario> users){

    Scanner entrada=new Scanner(System.in);
    boolean continuar=false;
    int prestamosActivos=0;
while (continuar==false) {
    
    System.out.println("Introduce el nombre del usuario que solicita el prestamo:");
    String nombre=entrada.next();
    
    for (Usuario usuario : users) {
        if (usuario.getNombre().equalsIgnoreCase(nombre)) {
            prestamosActivos=usuario.getNumeroDePrestamosActivos()+1;
            usuario.setNumeroDePrestamosActivos(prestamosActivos);
            continuar=true;
            break;
        }
    }
}
    int vecesPrestado;

    for (Libro libro : libros) {
        if (libro.getIdLibro()==id && libro.isPrestado()==false) {
            vecesPrestado=libro.getNumVecesPrestado();
            libro.setPrestado(true);
            libro.setNumVecesPrestado(vecesPrestado++);
            System.out.println("Libro prestado correctamente.");
        }
    }
}

public void devolverLibroPrestado(ArrayList<Libro> libros, int id, ArrayList<Usuario> users){

    Scanner entrada=new Scanner(System.in);
    boolean continuar=false;

    while (!continuar) {
        
        System.out.println("Introduce el nombre del usuario que deseas devolver el libro:");
        String nombre=entrada.next();
        int prestamosActivos=0;
        
        for (Usuario usuario : users) {
            if (usuario.getNombre().equalsIgnoreCase(nombre) && usuario.getNumeroDePrestamosActivos()>0) {
                prestamosActivos=usuario.getNumeroDePrestamosActivos()-1;
                usuario.setNumeroDePrestamosActivos(prestamosActivos);
                continuar=true;
                break;
            }
        }
        
        if (!continuar) {
            System.out.println("El usuario no tiene prestamos activos.");
        }
    }

    for (Libro libro : libros) {
        if (libro.getIdLibro()==id && libro.isPrestado()==true) {
            libro.setPrestado(false);
            System.out.println("Libro devuelto correctamente.");
        }
    }
}


public void mostrarLibrosPrestados(ArrayList<Libro> libros){

    for (Libro libro : libros) {
        if (libro.isPrestado()) {
            System.out.println(libro.toString());
        }
    }
}

}
