package Modelo;

import Libs.BdInteracciones;
import Libs.Hectareas;

import java.util.List;

public class Modelo {
    public Hectareas Recuperar(int numero){
        Hectareas hectarea = BdInteracciones.Recuperar(numero);
        return hectarea;
    }

    public int Grabar(Hectareas hectarea){
        int resultado = BdInteracciones.Grabar(hectarea);
        return resultado;
    }

    public int Modificar(Hectareas hectarea){
        int resultado = BdInteracciones.Modificar(hectarea);
        return resultado;

    }

    public int Borrar(int numero){
        int resultado = BdInteracciones.Borrar(numero);
        return resultado;
    }

    public List<Hectareas> Consultar(){
        List<Hectareas> resultado = BdInteracciones.Consultar();
        return resultado;
    }

    public int Validar(int numero){
        int resultado = BdInteracciones.Validar(numero);
        return resultado;
    }
}
