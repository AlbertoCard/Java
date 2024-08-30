package AgregacionVentas;

import java.io.*;

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
        String tempFileName = "temp.txt";
        boolean guardado = false;

        try (FileInputStream file = new FileInputStream(fileName);
             ObjectInputStream input = new ObjectInputStream(file);
             FileOutputStream tempFile = new FileOutputStream(tempFileName);
             ObjectOutputStream tempOutput = new ObjectOutputStream(tempFile)){

            while (true){
                try {
                    Venta v = (Venta) input.readObject();
                    tempOutput.writeObject(v);
                } catch (EOFException e){
                    break;
                }
            }

            tempOutput.writeObject(venta);
            guardado = true;

        } catch (Exception e){
            System.out.println("Ocurrió un error: " + e);
        }

        File viejo = new File(fileName);
        File nuevo = new File(tempFileName);

        if (viejo.delete()){
            nuevo.renameTo(viejo);
        }

        return guardado;
    }

    // eliminar venta
    public static boolean eliminarVenta(String folio){
        String fileName = "ventas.txt";
        String tempFileName = "temp.txt";
        boolean eliminado = false;

        try (FileInputStream file = new FileInputStream(fileName);
             ObjectInputStream input = new ObjectInputStream(file);
             FileOutputStream tempFile = new FileOutputStream(tempFileName);
             ObjectOutputStream tempOutput = new ObjectOutputStream(tempFile)){

            while (true){
                try {
                    Venta venta = (Venta) input.readObject();
                    if (!venta.getFolio().equals(folio)){
                        tempOutput.writeObject(venta);
                    } else {
                        eliminado = true;
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
        return eliminado;
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
                    System.out.println("-----------------------------");
                    System.out.println(venta.getFolio() + "  |" + venta.getFecha());
                    for(Linea linea : venta.getLineas()) {
                        if (linea != null){
                            System.out.println(linea.getProducto() + " | " + linea.getUnidades() + " | " + linea.getPrecio());
                        }
                    }
                } catch (IOException e){
                    break;
                }

            }

        } catch (Exception e){
            System.out.println("Ocurrió un error: " + e);
        }
    }

}
