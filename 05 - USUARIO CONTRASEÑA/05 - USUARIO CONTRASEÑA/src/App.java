import Controladores.Controlador;
import Modelos.Modelo;
import Vistas.Vista;

public class App {
    public static void main(String[] args) throws Exception {
        Vista vista = new Vista();
        Modelo modelo = new Modelo("129.150.52.34","appsalon_phpmvc_josearlolo_db","appsalon-phpmvc-josearlolo","pj1qlJ6CI6nC(-1Z9(");
        Controlador controlador = new Controlador(modelo, vista);
        vista.setListener(controlador);
    }
}
