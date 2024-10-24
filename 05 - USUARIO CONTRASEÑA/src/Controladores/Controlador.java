package Controladores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelos.Modelo;
import Modelos.Usuario;
import Vistas.Vista;

public class Controlador implements ActionListener {
    Modelo modelo;
    Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnLogout()) {
            modelo.logout(vista.getUsuario());
            vista.cambiarTarjeta("Inicio");
        }
        if (e.getSource() == vista.getBtnLogin()) {
            Usuario usuario = vista.getUsuario();
            if (usuario != null) {
                if (!modelo.validarCorreoUsuario(usuario))
                {
                    vista.mensaje("La estructura del correo es invalida", true);
                    return;
                }

                if (modelo.getUsuario(usuario) == null) {
                    vista.mensaje("Informacion invalida o no existente", true);
                    return;
                }
                modelo.quitarBloqueo(modelo.getUsuario(usuario));
                if (!modelo.verificarUsuario(usuario)) {
                    Usuario dbUser = modelo.getUsuario(usuario);
                    if (dbUser.getLockedUpTo() != null) {
                        vista.mensaje("Se han superado los intentos de logueo, intente mas tarde", true);
                        return;
                    }
                    vista.mensaje("Usuario ó contraseña incorrectos", true);
                    return;
                }
                usuario = modelo.getUsuario(usuario);
                if (!usuario.isOnline() && usuario.getLockedUpTo() == null) {
                    modelo.login(usuario);
                    vista.cambiarTarjeta("Bienvenida");
                    vista.mensaje("Usuario logueado correctamente", false);
                    return;
                }
                vista.mensaje("El usuario actualmente se encuentra bloqueado", true);
                return;
            } else {
                vista.mensaje("Usuario ó contraseña invalidos", true);
                return;
            }
        }
    }
}
