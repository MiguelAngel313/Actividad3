import java.util.ArrayList;

public class GestionPrestamos {
    
public void realizarPrestamosLibros(ArrayList<Libro> libros, int id){

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

public void devolverLibroPrestado(ArrayList<Libro> libros, int id){

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
