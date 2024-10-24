import Modelos.Usuario;

public class UserCreation {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("correo@correo.com", "donTamalitoYaLlego");
        usuario.hashearNip();
    }
}
