package Modelos;

import java.sql.Timestamp;
import org.mindrot.jbcrypt.BCrypt;

public class Usuario {
    private String correo, nip;
    private boolean online = false;
    private int loginAttemps = 0;
    private Timestamp lockedUpTo = null;

    private boolean hashed = false;
    public Usuario(String correo, String nip) {
        this.correo = correo;
        this.nip = nip;
    }
    public Usuario(String correo, String nip, boolean online, int loginAttemps, Timestamp lockedUpTo)
    {
        this.correo = correo;
        this.nip = nip;
        this.online = online;
        this.loginAttemps = loginAttemps;
        this.lockedUpTo = lockedUpTo;
    }
    public void hashNip() {
        if (hashed)
            return;

        this.nip = BCrypt.hashpw(this.nip, BCrypt.gensalt(10));
        this.hashed = true;
    }
    public boolean passwordVerify(String password) {
        return BCrypt.checkpw(password, this.nip);
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNip() {
        return nip;
    }
    public void setNip(String nip) {
        this.nip = nip;
    }
    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }
    public int getLoginAttemps() {
        return loginAttemps;
    }
    public void setLoginAttemps(int loginAttemps) {
        this.loginAttemps = loginAttemps;
    }
    public Timestamp getLockedUpTo() {
        return lockedUpTo;
    }
    public void setLockedUpTo(Timestamp lockedUpTo) {
        this.lockedUpTo = lockedUpTo;
    }
}
