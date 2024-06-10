package Figuras;

public class Cuadrado extends Figura{

    private int lado;

    public Cuadrado(double x, double y, int lado) {
        super(x, y);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        double area = lado * lado;
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = lado * 4;
        return perimetro;
    }
}
