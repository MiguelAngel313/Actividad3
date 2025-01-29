import java.util.ArrayList;

public class GestionUsuarios {
    
    private ArrayList<Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void nuevoUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean registrarUsuario(Usuario usuario, String adminEmail, String adminContrasenia) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(adminEmail) && u.getContrasenia().equals(adminContrasenia) && u.isAdmin()) {
                usuarios.add(usuario);
                return true;
            }
        }
        return false;
    }

    public String consultarUsuarios(String adminEmail, String adminContrasenia) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(adminEmail) && u.getContrasenia().equals(adminContrasenia) && u.isAdmin()) {
                StringBuilder sb = new StringBuilder();
                for (Usuario user : usuarios) {
                    sb.append(user.toString()).append("\n");
                }
                return sb.toString();
            }
        }
        return null;
        
    }
}


    