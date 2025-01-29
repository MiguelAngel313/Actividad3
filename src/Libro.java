public class Libro {

    private int idLibro;
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private String categoria;
    private boolean prestado;
    private int numVecesPrestado;

    public Libro(int idLibro, String titulo, String autor, int numeroPaginas, String categoria, boolean prestado,
            int numVecesPrestado) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.categoria = categoria;
        this.prestado = false;
        this.numVecesPrestado = 0;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public int getNumVecesPrestado() {
        return numVecesPrestado;
    }

    public void setNumVecesPrestado(int numVecesPrestado) {
        this.numVecesPrestado = numVecesPrestado;
    }

    @Override
    public String toString() {
        return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", numeroPaginas="
                + numeroPaginas + ", categoria=" + categoria + "]";
    }

}