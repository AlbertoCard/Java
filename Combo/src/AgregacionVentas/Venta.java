package AgregacionVentas;

public class Venta {
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
                System.out.println("Cantidad maxima de lineas alcanzada");
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

    public void setLineas(Linea[] lineas) {
        this.lineas = lineas;
    }
}
