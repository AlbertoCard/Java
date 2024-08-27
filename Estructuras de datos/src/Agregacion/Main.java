package Agregacion;

import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
    private static final String ARCHIVO_VENTAS = "ventas.json";
    private static List<Venta> ventas = new ArrayList<>();

    public static void main(String[] args) {
        cargarVentas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSistema de Gestión de Ventas");
            System.out.println("1. Generar nueva venta");
            System.out.println("2. Ver ventas");
            System.out.println("3. Eliminar venta");
            System.out.println("4. Agregar línea a una venta");
            System.out.println("5. Eliminar línea de una venta");
            System.out.println("6. Grabar ventas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    generarVenta(scanner);
                    break;
                case 2:
                    verVentas();
                    break;
                case 3:
                    eliminarVenta(scanner);
                    break;
                case 4:
                    agregarLineaAVenta(scanner);
                    break;
                case 5:
                    eliminarLineaDeVenta(scanner);
                    break;
                case 6:
                    grabarVentas();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void generarVenta(Scanner scanner) {
        System.out.print("Ingrese el folio de la venta: ");
        String folio = scanner.next();
        System.out.print("Ingrese la fecha de la venta (DD/MM/YYYY): ");
        String fecha = scanner.next();

        Venta nuevaVenta = new Venta(folio, fecha);
        ventas.add(nuevaVenta);
        System.out.println("Venta generada exitosamente.");
    }

    private static void verVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (Venta venta : ventas) {
                System.out.println(venta);
            }
        }
    }

    private static void eliminarVenta(Scanner scanner) {
        System.out.print("Ingrese el folio de la venta a eliminar: ");
        String folio = scanner.next();
        Venta ventaAEliminar = buscarVentaPorFolio(folio);

        if (ventaAEliminar != null) {
            ventas.remove(ventaAEliminar);
            System.out.println("Venta eliminada exitosamente.");
        } else {
            System.out.println("Venta no encontrada.");
        }
    }

    private static void agregarLineaAVenta(Scanner scanner) {
        System.out.print("Ingrese el folio de la venta: ");
        String folio = scanner.next();
        Venta venta = buscarVentaPorFolio(folio);

        if (venta != null) {
            System.out.print("Ingrese el código del producto: ");
            int prod = scanner.nextInt();
            System.out.print("Ingrese la cantidad de unidades: ");
            int unidades = scanner.nextInt();
            System.out.print("Ingrese el precio: ");
            int precio = scanner.nextInt();

            if (venta.agregarLinea(prod, unidades, precio)) {
                System.out.println("Línea agregada exitosamente.");
            }
        } else {
            System.out.println("Venta no encontrada.");
        }
    }

    private static void eliminarLineaDeVenta(Scanner scanner) {
        System.out.print("Ingrese el folio de la venta: ");
        String folio = scanner.next();
        Venta venta = buscarVentaPorFolio(folio);

        if (venta != null) {
            System.out.print("Ingrese el número de línea a eliminar: ");
            int indice = scanner.nextInt() - 1;

            if (venta.eliminarLinea(indice)) {
                System.out.println("Línea eliminada exitosamente.");
            }
        } else {
            System.out.println("Venta no encontrada.");
        }
    }

    private static Venta buscarVentaPorFolio(String folio) {
        for (Venta venta : ventas) {
            if (venta.getFolio().equals(folio)) {
                return venta;
            }
        }
        return null;
    }

    private static void cargarVentas() {
        try {
            File archivo = new File(ARCHIVO_VENTAS);
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                Gson gson = new Gson();
                ventas = gson.fromJson(br, new TypeToken<List<Venta>>() {}.getType());
                br.close();
            } else {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar las ventas: " + e.getMessage());
        }
    }

    private static void grabarVentas() {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(ARCHIVO_VENTAS);
            gson.toJson(ventas, writer);
            writer.flush();
            writer.close();
            System.out.println("Ventas grabadas exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al grabar las ventas: " + e.getMessage());
        }
    }
}

