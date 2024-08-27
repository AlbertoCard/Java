package AgregacionVentas;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuVentas {
    Scanner scn = new Scanner(System.in);
    ArrayList<Venta> ventasLista = new ArrayList<Venta>();

    public void iniciarMenuVentas(){
        int opcion;

//        leerArchivo();

        System.out.println("Menu de ventas");

        do{
            try{
                mostrarMenu();
                opcion = Integer.parseInt(scn.nextLine());

                switch (opcion){
                    case 1:
                        System.out.println("Agregar venta");
                        agregarVenta();
                        break;
                    case 2:
                        System.out.println("Eliminar venta");
                        eliminarVenta();
                        break;
                    case 3:
                        System.out.println("Modificar venta");
//                        modificarVenta();
                        break;
                    case 4:
                        System.out.println("Mostrar ventas");
                        mostrarVentas();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Solo se aceptan numeros");
                opcion = -1;
            }
        }while (opcion != 0);

    }

    public void mostrarMenu(){
        System.out.println("1.- Agregar venta");
        System.out.println("2.- Eliminar venta");
        System.out.println("3.- Modificar venta");
        System.out.println("4.- Mostrar ventas");
        System.out.println("0.- Salir");
    }

    public void agregarVenta(){
        String folio = generateFolio();
        String fecha = generateFecha();
        Venta venta = new Venta(folio, fecha);

        System.out.println("Generando venta con folio: " + folio);
        MenuLineas menuLineas = new MenuLineas();
        menuLineas.iniciarMenuLineas(venta);

        ventasLista.add(venta);
    }

    public static String generateFolio() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return "F" + timestamp; // Folio con formato F20230826123045
    }

    public static String generateFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd-HH-mm-ss");
        Date now = new Date();
        return sdf.format(now);
    }

    public void eliminarVenta(){
        System.out.println("Ingrese el folio de la venta a eliminar: ");
        String folio = scn.nextLine();

        for (Venta v : ventasLista){
            if (v.getFolio().equals(folio)){
                ventasLista.remove(v);
                break;
            }
        }
    }

    public void modificarVenta(){
        MenuLineas menuLineas = new MenuLineas();
        System.out.println("Ingrese el folio de la venta a modificar: ");
        String folio = scn.nextLine();

        for (Venta v : ventasLista){
            if (v.getFolio().equals(folio)){
                menuLineas.iniciarMenuLineas(v);
                break;
            }
        }
    }

    public void mostrarVentas(){
        System.out.println("Ventas");

        for( Venta v : ventasLista){
            System.out.println("Folio: " + v.getFolio());
            System.out.println("Fecha: " + v.getFecha());
            System.out.println("Lineas de venta");

            for (Linea l : v.getLineas()){
                if (l != null){
                    System.out.println(l.getProducto() + " - " + l.getUnidades() + " - " + l.getPrecio());
                }
            }

        }
    }


























    public void leerArchivo(){
        String fileName = "bdVentas.json";
        File file = new File(fileName);

        try {
            if (file.exists()) {
                System.out.println("Cargando archivo...");
            } else {
                if (file.createNewFile()) {
                    System.out.println("El archivo 'bdVentas.json' ha sido creado.");
                } else {
                    System.out.println("No se pudo crear el archivo 'bdVentas.json'.");
                }
            }
        } catch (IOException e) {
            // Maneja excepciones de entrada/salida
            System.out.println("Ocurrió un error al manejar el archivo: " + e.getMessage());
        }

    }
}
