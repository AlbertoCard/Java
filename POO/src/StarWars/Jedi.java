package StarWars;

public class Jedi extends Usuario implements IFuerza{

    public Jedi(String nombre, String apellido, String rango, String afinidad) {
        super(nombre, apellido, rango, afinidad);
    }

    @Override
    protected void encenderSable() {
        System.out.println("Enciende un sable verde");
    }

    @Override
    public void atacar() {
        System.out.println("Empuja con telequinesis");
    }

    @Override
    public void usarFuerza() {
        System.out.println("Te levanta con telequinesis");
    }

    @Override
    public void mental() {
        System.out.println("Utiliza persuacion mental");
    }
}
