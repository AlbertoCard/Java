package AgregacionVentas;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuVentas {
    Scanner scn = new Scanner(System.in);

    public void iniciarMenuVentas(){
        int opcion;

        Bd.crearArchivo();

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
                        modificarVenta();
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

        Bd.guardarVenta(venta);
    }

    public static String generateFolio() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return "F" + timestamp; // Folio con formato F20230826123045
    }

    public static String generateFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date now = new Date();
        return sdf.format(now);
    }

    public void eliminarVenta(){
        System.out.println("Ingrese el folio de la venta a eliminar: ");
        String folio = scn.nextLine();

        Bd.eliminarVenta(folio);
        System.out.println("Venta eliminada");
    }

    public void modificarVenta(){
        System.out.println("Ingrese el folio de la venta a modificar: ");
        String folio = scn.nextLine();

        Venta venta = Bd.buscarVenta(folio);

        if (venta != null){
            MenuLineas menuLineas = new MenuLineas();
            menuLineas.iniciarMenuLineas(venta);

            Bd.eliminarVenta(folio);
            Bd.guardarVenta(venta);
        } else {
            System.out.println("Venta no encontrada");
        }
    }

    public void mostrarVentas(){
        System.out.println("Lista de Ventas:");
        System.out.println("Folio:\t\t\t Fecha:\t  Lineas:");

        Bd.mostrarVentas();
    }


}
