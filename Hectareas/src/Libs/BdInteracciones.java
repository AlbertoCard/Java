package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BdInteracciones {

    public static Hectareas Recuperar(int id){
        String consulta = "SELECT * FROM hectarea WHERE IdHectarea = "+id;

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            if(!rs.next()){
                System.out.println("No se encontraron datos");
                stmt.close();
                rs.close();
                conexion.desconectar(con);
                return null;
            }

            int IdHectarea = rs.getInt("IdHectarea");
            String Comunidad = rs.getString("Comunidad");
            int Renta = rs.getInt("Renta");
            String Ubicacion = rs.getString("Ubicacion");


            Hectareas hectarea = new Hectareas(IdHectarea, Comunidad, Renta, Ubicacion);

            stmt.close();
            rs.close();
            conexion.desconectar(con);

            return hectarea;

        } catch (Exception e) {
            System.out.println("Error al recuperar datos");
            return null;
        }
    }

    public static int Grabar(Hectareas hectarea){
        String consulta = "INSERT INTO hectarea (IdHectarea, Comunidad, Renta, Ubicacion) VALUES ("+hectarea.getIdHectarea()+",'"+hectarea.getComunidad()+"',"+hectarea.getRenta()+",'"+hectarea.getUbicacion()+"')";

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();

            Statement stmt = con.createStatement();
            int resultado = stmt.executeUpdate(consulta);

            stmt.close();
            conexion.desconectar(con);

            return resultado;

        } catch (Exception e) {
            System.out.println("Error al grabar datos " + e.getMessage());
            return 0;
        }
    }

    public static int Modificar(Hectareas hectarea){
        String consulta = "UPDATE hectarea SET Comunidad = '"+hectarea.getComunidad()+"', Renta = "+hectarea.getRenta()+", Ubicacion = '"+hectarea.getUbicacion()+"' WHERE IdHectarea = "+hectarea.getIdHectarea();

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();

            Statement stmt = con.createStatement();
            int resultado = stmt.executeUpdate(consulta);

            stmt.close();
            conexion.desconectar(con);

            return resultado;

        } catch (Exception e) {
            System.out.println("Error al modificar datos");
            return 0;
        }
    }

    public static int Borrar(int id){
        String consulta = "DELETE FROM hectarea WHERE IdHectarea = "+id;

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();

            Statement stmt = con.createStatement();
            int resultado = stmt.executeUpdate(consulta);

            stmt.close();
            conexion.desconectar(con);

            return resultado;

        } catch (Exception e) {
            System.out.println("Error al borrar datos");
            return 0;
        }
    }

    public static List<Hectareas> Consultar(){
        String consulta = "SELECT * FROM hectarea";
        List<Hectareas> resultado = new ArrayList<>();

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                int IdHectarea = rs.getInt("IdHectarea");
                String Comunidad = rs.getString("Comunidad");
                int Renta = rs.getInt("Renta");
                String Ubicacion = rs.getString("Ubicacion");

                Hectareas hectarea = new Hectareas(IdHectarea, Comunidad, Renta, Ubicacion);
                resultado.add(hectarea);
            }

            stmt.close();
            rs.close();
            conexion.desconectar(con);

        } catch (Exception e) {
            System.out.println("Error al recuperar datos"+e.getMessage());
        } finally {
            return resultado;
        }
    }

    public static int Validar(int id){

        int resultado = 0;
        String consulta = "SELECT * FROM hectarea WHERE IdHectarea = "+id;

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            if (rs.next()) {
                resultado = 1;
            }
            stmt.close();
            rs.close();
            conexion.desconectar(con);

        } catch (Exception e) {
            System.out.println("Error al recuperar datos");
        }
        return resultado;
    }
}
