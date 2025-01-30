public class Usuario {
    private String nombre;
    private String email;
    private String contrasenia;
    private boolean isAdmin;
    private int numeroDePrestamosActivos;
    



public Usuario(String nombre, String email, String contrasenia, boolean isAdmin, int numeroDePrestamosActivos) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.isAdmin = isAdmin;
        this.numeroDePrestamosActivos = 0;
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

public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
}


public int getNumeroDePrestamosActivos() {
    return numeroDePrestamosActivos;
}

public void setNumeroDePrestamosActivos(int numeroDePrestamosActivos) {
    this.numeroDePrestamosActivos = numeroDePrestamosActivos;
}

@Override
public String toString() {
    return "{" +
        " nombre='" + nombre + "'" +
        ", email='" + email + "'" +
        ", contrasenia='" + contrasenia + "'" +
        ", isAdmin='" + isAdmin + "'" +
        "}";
}
}
