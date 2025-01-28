import java.util.ArrayList;

public class GestionPrestamos {
    
public void realizarPrestamosLibros(ArrayList<Libro> libros, int id){

    int vecesPrestado;
    for (Libro libro : libros) {
        if (libro.getIdLibro()==id && libro.isPrestado()==false) {
            vecesPrestado=libro.getNumVecesPrestado();
            libro.setPrestado(true);
            libro.setNumVecesPrestado(vecesPrestado++);
        }
    }
}

public void devolverLibroPrestado(ArrayList<Libro> libros, int id){

    for (Libro libro : libros) {
        if (libro.getIdLibro()==id && libro.isPrestado()==true) {
            libro.setPrestado(false);
        }
    }
}

//Implementar funcion de mostrar libros actualmente prestados

}
