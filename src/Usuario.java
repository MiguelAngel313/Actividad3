public class Usuario {
    private int idUsuario;
    private boolean admin;
    private String nombre;
    private int edad;
    public Usuario(int idUsuario, boolean admin, String nombre, int edad) {
        this.idUsuario = idUsuario;
        this.admin = admin;
        this.nombre = nombre;
        this.edad = edad;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", admin=" + admin + ", nombre=" + nombre + ", edad=" + edad + "]";
    }

}
