package Modelos;

public class Modelo {
    private Database db;
    public Modelo(String host, String database, String user, String password)
    {
        db = new Database(host, database, user, password);
    }
    public Modelo()
    {
        this("localhost:3306", "pruebas", "root", "root");
    }
    
}
