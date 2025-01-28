public class Usuario {
<<<<<<< HEAD
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
=======
        private String nombre;
        private String email;
        private String contrasenia;
        private boolean isAdmin;


public Usuario(String nombre, String email, String contrasenia, boolean isAdmin ){
    this.nombre = nombre;
    this.email = email;
    this.contrasenia = contrasenia;
    this.isAdmin= isAdmin;
    
}

    public String getNombre() {
        return this.nombre;
>>>>>>> e3553b99db97b0ff7a7eac18514060decbe55b3d
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
<<<<<<< HEAD
    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", admin=" + admin + ", nombre=" + nombre + ", edad=" + edad + "]";
=======

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public boolean getAdmin() {
        return this.isAdmin;
    }

    public void setEsAdm(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + nombre + "'" +
            ", email='" + email + "'" +
            ", contrasenia='" + contrasenia + "'" +
            ", isAdmin='" + isAdmin() + "'" +
            "}";
>>>>>>> e3553b99db97b0ff7a7eac18514060decbe55b3d
    }

}
