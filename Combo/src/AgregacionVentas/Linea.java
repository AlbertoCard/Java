package AgregacionVentas;

public class Linea {
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

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
