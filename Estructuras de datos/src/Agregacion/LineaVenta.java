package Agregacion;

public class LineaVenta {
    private int prod;
    private int unidades;
    private int precio;

    public LineaVenta(int prod, int unidades, int precio) {
        this.prod = prod;
        this.unidades = unidades;
        this.precio = precio;
    }

    // Getters y Setters
    public int getProd() {
        return prod;
    }

    public int getUnidades() {
        return unidades;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto: " + prod + ", Unidades: " + unidades + ", Precio: " + precio;
    }
}

