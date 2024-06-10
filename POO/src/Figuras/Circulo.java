package Figuras;

public class Circulo extends Figura{

    private double radio;

    public Circulo(double x, double y, double radio) {
        super(x,y);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        double area = 3.1416 * (radio * radio);
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = 3.1416 * (2 * radio);
        return perimetro;
    }
}
