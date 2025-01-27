public class Usuaria {
    public class Usuario {
        private String nombre;
        private String email;
        private String contrasenia;
        private boolean esAdm;


    public Usuario(String nombre, String email, String contrasenia, boolean esAdm ){
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.esAdm= esAdm;
    
    }

    //Getter and Sters

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

    public boolean isEsAdm() {
        return this.esAdm;
    }

    public boolean getEsAdm() {
        return this.esAdm;
    }

    public void setEsAdm(boolean esAdm) {
        this.esAdm = esAdm;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + nombre + "'" +
            ", email='" + email + "'" +
            ", contrasenia='" + contrasenia + "'" +
            ", esAdm='" + esAdm + "'" +
            "}";
    }




}

}
