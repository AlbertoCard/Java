package Controlador;

import Modelo.Hectareas;
import Vista.Vista;
import Modelo.Modelo;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.List;

public class Controlador implements ActionListener {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo,Vista vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource()==vista.getBtnRecuperar()){
            int id = vista.getIdHectarea();

            if(modelo.Validar(id)==0){
                vista.informarOperacion("No se encontraron datos");
                return;
            }
            vista.setHectarea(modelo.Recuperar(id));
            return;
        }

        if (evt.getSource()==vista.getBtnGrabar()){

            try {
                Integer.parseInt(vista.getTxtIdHectarea());
            } catch (NumberFormatException e) {
                vista.informarOperacion("ID debe ser un numero entero");
                return;
            }

            try {
                Integer.parseInt(vista.getTxtRenta());
            } catch (NumberFormatException e) {
                vista.informarOperacion("Renta debe ser un numero entero");
                return;
            }

            Hectareas hectarea = vista.getHectarea();

            if(modelo.Validar(hectarea.getIdHectarea())==1){
                vista.informarOperacion("ID ya existente. \nSi desea modificarlo, presione el boton Modificar");
                return;
            }

            int resultado = modelo.Grabar(hectarea);

            if (resultado == 0){
                vista.informarOperacion("Ocurrio un error");
                return;
            }
            vista.Limpiar();
            vista.informarOperacion("Operacion realizada con exito");
            return;
        }

        if(evt.getSource()==vista.getBtnModificar()){
            try {
                Integer.parseInt(vista.getTxtIdHectarea());
            } catch (NumberFormatException e) {
                vista.informarOperacion("ID debe ser un numero entero");
                return;
            }

            try {
                Integer.parseInt(vista.getTxtRenta());
            } catch (NumberFormatException e) {
                vista.informarOperacion("Renta debe ser un numero entero");
                return;
            }

            Hectareas hectarea = vista.getHectarea();

            if(modelo.Validar(hectarea.getIdHectarea())==0){
                vista.informarOperacion("ID no existente. \nSi desea agregarlo, presione el boton Grabar");
                return;
            }

            int resultado = modelo.Modificar(hectarea);

            if (resultado == 0){
                vista.informarOperacion("Ocurrio un error");
                return;
            }
            vista.Limpiar();
            vista.informarOperacion("Operacion realizada con exito");
            return;
        }

        if(evt.getSource()==vista.getBtnBorrar()){
            int id = vista.getIdHectarea();

            if(modelo.Validar(id)==0){
                vista.informarOperacion("ID no existente");
                return;
            }

            int resultado = modelo.Borrar(id);

            if (resultado == 0){
                vista.informarOperacion("Ocurrio un error");
                return;
            }
            vista.Limpiar();
            vista.informarOperacion("Operacion realizada con exito");
            return;
        }

        if(evt.getSource()==vista.getBtnConsultar()){
            List<Hectareas> lista = modelo.Consultar();

            if(lista == null){
                vista.informarOperacion("No se encontraron datos");
                return;
            }

            vista.interfazHectareas(lista);
        }

        if (evt.getSource()==vista.getBtnLimpiar()){
            vista.Limpiar();
        }
    }
}
