package StarWars;

public class Main {
    public static void main(String[] args) {

        Jedi j = new Jedi("Anakin", "Skywalker", "Maestro", "Muy alta");
        Sith s = new Sith("Darth", "Vader", "Lord Sith", "Muy alta");


        System.out.println(j.getNombre() + " " + j.getApellido());
        System.out.println("Rango :" + j.getRango());
        System.out.println("Afinidad con la fuerza: " + j.getAfinidad());
        j.encenderSable();
        j.atacar();
        j.usarFuerza();
        j.mental();
        j.apagerSable();

        System.out.println("\n");

        System.out.println(s.getNombre() + " " + s.getApellido());
        System.out.println("Rango :" + s.getRango());
        System.out.println("Afinidad con la fuerza: " + s.getAfinidad());
        s.encenderSable();
        s.atacar();
        s.usarFuerza();
        s.mental();
        s.apagerSable();


    }
}
