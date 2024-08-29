package AgregacionVentas;

import java.io.Serializable;

public class Linea implements Serializable {
    private int producto, unidades, precio;

    public Linea(int producto, int unidades, int precio){
        this.producto = producto;
        this.unidades = unidades;
        this.precio = precio;
    }

    public int getProducto() {
        return producto;
    }

    public int getUnidades() {
        return unidades;
    }

    public int getPrecio() {
        return precio;
    }


    @Override
    public String toString() {
        return producto + "," + unidades + "," + precio;
    }
}
