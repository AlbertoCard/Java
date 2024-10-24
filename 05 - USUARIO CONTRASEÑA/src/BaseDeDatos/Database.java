package BaseDeDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Modelos.Usuario;

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
    public Usuario getUsuario(String correo)
    {
        Usuario databaseUser = null;
        try {
            this.executor = this.connection.prepareStatement("SELECT * FROM users where correo = ? LIMIT 1");
            this.executor.setString(1, correo);
            ResultSet rs = this.executor.executeQuery();
            if (rs.next())
                databaseUser = new Usuario(
                    rs.getString("correo"), 
                    rs.getString("nip"),
                    rs.getInt("online") == 0 ? false : true,
                    rs.getInt("loginAttemps"),
                    rs.getTimestamp("LockedUpTo"));
            this.executor = null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseUser;
    }
    public boolean createUsuario(Usuario usuario) {
        boolean exit = false;
        try {
            this.executor = this.connection.prepareStatement("INSERT INTO users (correo, nip) VALUES (?, ?)");
            this.executor.setString(1, usuario.getCorreo());
            this.executor.setString(2, usuario.getNip());
            return this.executor.executeUpdate() == 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return exit;
    }
    
    public boolean logUsuario(Usuario usuario, int i) {
        try {
            this.executor = this.connection.prepareStatement("UPDATE users SET online = ?, loginAttemps = ?, LockedUpTo = null WHERE correo = ?");
            this.executor.setInt(1, i);
            this.executor.setInt(2, 0);
            this.executor.setString(3, usuario.getCorreo());
            return this.executor.executeUpdate() == 1;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean usuarioIncorrecto(Usuario usuario) {
        if (usuario.getLockedUpTo() != null) return false;
        try {
            int attemps = usuario.getLoginAttemps() + 1;
            if (attemps % 3 != 0){
                this.executor = this.connection.prepareStatement("UPDATE users SET loginAttemps = ? WHERE correo = ?");
                this.executor.setInt(1, attemps);
                this.executor.setString(2, usuario.getCorreo());
            }
            else{
                Timestamp ahora = new Timestamp(System.currentTimeMillis());
                Timestamp tiempoBloqueo = new Timestamp(ahora.getTime() + 30 * 60 * 1000);
                this.executor = this.connection.prepareStatement("UPDATE users SET loginAttemps = ?, LockedUpTo = ? WHERE correo = ?");
                this.executor.setInt(1, 0);
                this.executor.setTimestamp(2, tiempoBloqueo);
                this.executor.setString(3, usuario.getCorreo());
            }
            
            return this.executor.executeUpdate() == 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean quitarBloqueo(Usuario usuario) {
        try {
            this.executor = this.connection.prepareStatement("UPDATE users SET loginAttemps = ?, LockedUpTo = null WHERE correo = ?");
            this.executor.setInt(1, 0);
            this.executor.setString(2, usuario.getCorreo());
            return this.executor.executeUpdate() == 1;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
