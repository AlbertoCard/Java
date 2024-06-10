package StarWars;

public abstract class Usuario {

    private String nombre;
    private String apellido;
    private String rango;
    private String afinidad;

    protected Usuario(String nombre, String apellido, String rango, String afinidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rango = rango;
        this.afinidad = afinidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRango() {
        return rango;
    }

    public String getAfinidad() {
        return afinidad;
    }

    protected abstract void encenderSable();
    protected void apagerSable(){
        System.out.println("Apaga el sable");
    }
}
