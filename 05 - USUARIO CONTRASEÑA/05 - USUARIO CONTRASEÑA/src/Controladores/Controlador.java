package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelos.Modelo;
import Modelos.Usuario;
import Vistas.Vista;

public class Controlador implements ActionListener{
    Modelo modelo;
    Vista vista;
    
    public Controlador(Modelo modelo, Vista vista)
    {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnLogin()){
            Usuario usuario = vista.getUsuario();
            if (usuario == null) {
                vista.mensaje("Los datos de inicio de sesion\nSon invalidos", true);
                return;
            }

            if (!usuario.correoValido())
            {
                vista.mensaje("El correo es invalido\nNo existe o esta mal escrito", true);
                return;
            }
        }
    }
}
