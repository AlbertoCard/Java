package Controlador;

import Modelo.Modelo;
import Vista.Vista;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo,Vista vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
    }
}
