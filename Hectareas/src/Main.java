import Controlador.Controlador;
import Vista.Vista;
import Modelo.Modelo;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo  = new Modelo();

        Controlador controlador = new Controlador(modelo,vista);

        vista.setEscuchador(controlador);
    }
}