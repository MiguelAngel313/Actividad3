public class Usuario {
        private String nombre;
        private String email;
        private String contrasenia;
        private boolean isAdmi;


public Usuario(String nombre, String email, String contrasenia, boolean isAdmi ){
    this.nombre = nombre;
    this.email = email;
    this.contrasenia = contrasenia;
    this.isAdmi= isAdmi;
    
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

    public boolean isEsAdmi() {
        return this.isAdmi;
    }

    public boolean getEsAdmi() {
        return this.isAdmi;
    }

    public void setEsAdm(boolean isEsAdmi) {
        this.isAdmi = isEsAdmi;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + nombre + "'" +
            ", email='" + email + "'" +
            ", contrasenia='" + contrasenia + "'" +
            ", isAdm='" + isAdmi + "'" +
            "}";
    }



}

