
import Modelos.Modelo;
import Modelos.Usuario;

public class UserCreation {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("alberto@mango.db.mx", "123");
        Modelo modelo = new Modelo();
        usuario.hashNip();
        System.out.println(modelo.nuevoUsuario(usuario));
    }
}
