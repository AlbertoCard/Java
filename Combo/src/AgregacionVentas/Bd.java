package AgregacionVentas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bd {

    public static void crearArchivo(){
        String fileName = "ventas.txt";
        File file = new File(fileName);

        try {
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e);
        }
    }

    // guardar venta
    public static boolean guardarVenta(Venta venta) {
        String fileName = "ventas.txt";
        boolean guardado = false;
        List<Venta> ventas = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream input = new ObjectInputStream(fileIn)) {
            while (true) {
                try {
                    ventas.add((Venta) input.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e);
        }

        // Añadir la nueva venta
        ventas.add(venta);

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream output = new ObjectOutputStream(fileOut)) {
            for (Venta v : ventas) {
                output.writeObject(v);
            }
            guardado = true;
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e);
        }

        return guardado;
    }

    // eliminar venta
    public static void eliminarVenta(String folio){
        String fileName = "ventas.txt";
        String tempFileName = "temp.txt";

        try (FileInputStream file = new FileInputStream(fileName);
             ObjectInputStream input = new ObjectInputStream(file);
             FileOutputStream tempFile = new FileOutputStream(tempFileName);
             ObjectOutputStream tempOutput = new ObjectOutputStream(tempFile)){

            while (true){
                try {
                    Venta venta = (Venta) input.readObject();
                    if (!venta.getFolio().equals(folio)){
                        tempOutput.writeObject(venta);
                    }
                } catch (EOFException e){
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Ocurrió un error: " + e);
        }

        File viejo = new File(fileName);
        File nuevo = new File(tempFileName);

        if (viejo.delete()){
            nuevo.renameTo(viejo);
        }
    }

    // modificar venta
    public static Venta buscarVenta(String folio){
        try (FileInputStream file = new FileInputStream("ventas.txt");
             ObjectInputStream input = new ObjectInputStream(file)){

            while (true){
                try {
                    Venta venta = (Venta) input.readObject();
                    if (venta.getFolio().equals(folio)){
                        return venta;
                    }
                } catch (EOFException e){
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Ocurrió un error: " + e);
        }

        return null;
    }

    // mostrar ventas
    public static void mostrarVentas(){
        try (FileInputStream file = new FileInputStream("ventas.txt");
             ObjectInputStream input = new ObjectInputStream(file)){

            while (true){

                try {
                    Venta venta = (Venta) input.readObject();
                    System.out.println(venta.toString());
                } catch (IOException e){
                    break;
                }

            }

        } catch (Exception e){
            System.out.println("Ocurrió un error: " + e);
        }
    }

}
