public class Usuario {
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
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
    }



}

