package AgregacionVentas;

import java.util.Scanner;

public class MenuLineas {
    Venta venta;
    Scanner scn = new Scanner(System.in);

    public void iniciarMenuLineas(Venta venta){
        int opcion;
        this.venta = venta;

        System.out.println("Menu de ventas");

        do{
            try{
                mostrarMenu();
                opcion = Integer.parseInt(scn.nextLine());

                switch (opcion){
                    case 1:
                        System.out.println("Agregar linea");
                        agregarLinea();
                        break;
                    case 2:
                        System.out.println("Eliminar linea");
                        eliminarLinea();
                        break;
                    case 3:
                        System.out.println("Mostar lineas");
                        mostrarLineas();
                        break;
                    case 0:
                        System.out.println("Guardando...");
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
        System.out.println("1.- Agregar linea");
        System.out.println("2.- Eliminar linea");
        System.out.println("3.- Mostrar lineas");
        System.out.println("0.- Salir");
    }

    public void agregarLinea(){
        System.out.println("Ingrese el producto: ");
        int prod = Integer.parseInt(scn.nextLine());
        System.out.println("Ingrese las unidades: ");
        int unidades = Integer.parseInt(scn.nextLine());
        System.out.println("Ingrese el precio: ");
        int precio = Integer.parseInt(scn.nextLine());

        if(venta.AgregarLinea(prod, unidades, precio)){
            System.out.println("Linea agregada");
        }
        else{
            System.out.println("Cantidad maximas de lineas alcanzada");
            System.out.println("No se pudo agregar la linea");
        }
    }

    public void eliminarLinea(){
        System.out.println("Ingrese el producto a eliminar: ");
        int prod = Integer.parseInt(scn.nextLine());

        venta.EliminarLinea(prod);

        System.out.println("Linea eliminada");
    }

    public void mostrarLineas(){
        System.out.println("Productos: \t Unidades: \t Precio: ");
        for (Linea linea : venta.getLineas()){
            if (linea != null){
                System.out.println(linea.toString());
            }
        }
    }
}