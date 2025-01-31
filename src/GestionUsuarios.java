import java.util.ArrayList;

public class GestionUsuarios {
    
    private ArrayList<Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void nuevoUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean registrarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.isAdmin()) {
                usuarios.add(usuario);
                return true;
            }
        }
        return false;
    }

    public String consultarUsuarios(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.isAdmin()) {
                StringBuilder sb = new StringBuilder();
                for (Usuario user : usuarios) {
                    sb.append(user.toString()).append("\n");
                }
                return sb.toString();
            }
        }
        return null;
        
    }

    public boolean eliminarUsuario(String nombreUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombreUsuario)) {
                usuarios.remove(u);
                return true; 
            }
        }
        return false; 
    }
}




    