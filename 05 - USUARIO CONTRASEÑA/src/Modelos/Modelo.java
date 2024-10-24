package Modelos;

import java.sql.Timestamp;

import BaseDeDatos.Database;

public class Modelo {
    private Database db;
    public Modelo()
    {
        db = new Database("129.150.52.34","appsalon_phpmvc_josearlolo_db","appsalon-phpmvc-josearlolo","pj1qlJ6CI6nC(-1Z9(");
    }
    public boolean validarCorreoUsuario(Usuario usuario) {
        String emailRegex = "^[A-Za-z0-9]+@mango.db.mx$";
        return usuario.getCorreo() != null && usuario.getCorreo().matches(emailRegex);
    }
    public Usuario getUsuario(Usuario usuario)
    {
        if (usuario == null) return null;
        return db.getUsuario(usuario.getCorreo());
    }
    public boolean verificarUsuario(Usuario usuario)
    {
        Usuario userInDb = db.getUsuario(usuario.getCorreo());
        if (userInDb == null || userInDb.getLockedUpTo() != null) return false;
        if (userInDb.passwordVerify(usuario.getNip())) return true;

        db.usuarioIncorrecto(userInDb);
        return false;
    }
    public boolean nuevoUsuario(Usuario usuario)
    {
        usuario.hashNip();
        return db.createUsuario(usuario);
    }
    public boolean login(Usuario usuario)
    {
        return db.logUsuario(usuario, 1);
    }
    public boolean logout(Usuario usuario)
    {
        return db.logUsuario(usuario, 0);
    }
    public boolean quitarBloqueo(Usuario usuario)
    {
        if (usuario == null) return false;

        if (usuario.getLockedUpTo() != null)
        {
            Timestamp now = new Timestamp(System.currentTimeMillis());
            if (now.after(usuario.getLockedUpTo())) return db.quitarBloqueo(usuario);
        }
        return false;
    }
}
