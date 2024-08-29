package AgregacionVentas;

import java.io.Serializable;

public class Venta implements Serializable {
    private String folio;
    private String fecha;
    private Linea [] lineas;

    public Venta(String folio, String fecha){
        lineas = new Linea[20];
        this.folio = folio;
        this.fecha = fecha;
    }

    public boolean AgregarLinea(int prod, int unidades, int precio){
        Linea linea = new Linea(prod, unidades, precio);
        boolean agregada = false;

        for (int i = 0; i < lineas.length; i++){
            if (lineas[i] == null){
                lineas[i] = linea;
                agregada = true;
                break;
            }
            if(i == lineas.length - 1){
                agregada = false;
            }
        }

        return agregada;
    }

    public void EliminarLinea(int prod) {
        for (int i = 0; i < lineas.length; i++) {
            if(lineas[i] != null && lineas[i].getProducto() == prod){
                lineas[i] = null;
                break;
            }
        }
    }


    public String getFolio() {
        return this.folio;
    }

    public String getFecha() {
        return this.fecha;
    }

    public Linea[] getLineas() {
        return lineas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(folio).append(",").append(fecha).append(";");
        for (Linea linea : lineas) {
            if (linea != null) {
                sb.append(linea.toString()).append(";");
            }
        }
        return sb.toString();
    }
}
