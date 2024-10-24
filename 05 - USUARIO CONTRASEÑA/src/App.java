import Controladores.Controlador;
import Modelos.Modelo;
import Vistas.Vista;

public class App {
    public static void main(String[] args) throws Exception {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(modelo, vista);
        vista.setListener(controlador);
    }
}
