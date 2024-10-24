package Modelos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
    private String correo, nip;
    private boolean hashed = false;
    public Usuario(String correo, String nip)
    {
        this.correo = correo;
        this.nip = nip;
    }
    public void hashearNip()
    {
        if (hashed) return;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(this.nip.getBytes());
            StringBuilder hash = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hash.append('0');
                hash.append(hex);
            }
            this.nip = hash.toString();
            hashed = true;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean correoValido() {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return this.correo != null && this.correo.matches(emailRegex);
    }
}
