package Agregacion;

import java.util.Arrays;

public class Venta {
    private String folio;
    private String fecha;
    private LineaVenta[] lineas;
    private int contadorLineas;

    public Venta(String folio, String fecha) {
        this.folio = folio;
        this.fecha = fecha;
        this.lineas = new LineaVenta[20]; // Hasta 20 líneas de venta
        this.contadorLineas = 0;
    }

    public boolean agregarLinea(int prod, int unidades, int precio) {
        if (contadorLineas < 20) {
            lineas[contadorLineas] = new LineaVenta(prod, unidades, precio);
            contadorLineas++;
            return true;
        } else {
            System.out.println("No se pueden agregar más líneas a esta venta.");
            return false;
        }
    }

    public boolean eliminarLinea(int indice) {
        if (indice >= 0 && indice < contadorLineas) {
            for (int i = indice; i < contadorLineas - 1; i++) {
                lineas[i] = lineas[i + 1];
            }
            lineas[contadorLineas - 1] = null;
            contadorLineas--;
            return true;
        } else {
            System.out.println("Índice de línea de venta no válido.");
            return false;
        }
    }

    public String getFolio() {
        return folio;
    }

    public String getFecha() {
        return fecha;
    }

    public LineaVenta[] getLineas() {
        return Arrays.copyOf(lineas, contadorLineas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Folio: ").append(folio).append(", Fecha: ").append(fecha).append("\n");
        for (int i = 0; i < contadorLineas; i++) {
            sb.append("  Línea ").append(i + 1).append(": ").append(lineas[i]).append("\n");
        }
        return sb.toString();
    }
}
