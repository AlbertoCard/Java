package Figuras;

public class Main {
    public static void main(String[] args) {

        Figura[] figs = new Figura[3];

        figs[0] = new Circulo(10, 10, 5);
        figs[1] = new Cuadrado(20, 20, 6);
        figs[2] = new Triangulo(30, 30, 4, 4);



        for (Figura f : figs){
            System.out.println("Area: " + f.calcularArea());
            System.out.println("Perimetro: " + f.calcularPerimetro());
            System.out.println();
        }


    }
}
