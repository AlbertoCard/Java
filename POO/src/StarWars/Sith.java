package StarWars;

public class Sith extends Usuario implements IFuerza{

    protected Sith(String nombre, String apellido, String rango, String afinidad) {
        super(nombre, apellido, rango, afinidad);
    }

    @Override
    protected void encenderSable() {
        System.out.println("Enciende un sable rojo");
    }


    @Override
    public void atacar() {
        System.out.println("Lanza un rayo");
    }

    @Override
    public void usarFuerza() {
        System.out.println("Te extrangula con telequinesis");
    }

    @Override
    public void mental() {
        System.out.println("Utiliza control mental");
    }
}
