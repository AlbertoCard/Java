package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String url = "jdbc:sqlserver://localhost\\ALBERTO:1434;database=Hectareas;instanse=ALBERTO;encrypt=false;trustServerCertificate=true;";
    private String user = "sa";
    private String password = "***";
    private Connection con = null;

    public Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos" + e.getMessage());
        }
        return con;
    }

    public void desconectar(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar de la base de datos");
        }
    }
}
