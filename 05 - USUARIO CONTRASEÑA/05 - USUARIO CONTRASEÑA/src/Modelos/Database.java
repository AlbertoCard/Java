package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private String host, database, user, password, url;
    private Connection connection;
    private PreparedStatement executor;
    
    public Database(String host, String database, String user, String password)
    {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
        checkConnection();
    }
    private void checkConnection() {
        this.url = "jdbc:mysql://" + this.host + "/" + this.database;
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            this.connection = null;
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
