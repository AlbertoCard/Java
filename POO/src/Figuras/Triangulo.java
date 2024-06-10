package Figuras;

public class Triangulo extends Figura{

    private double base;
    private double altura;

    public Triangulo(double x, double y, double base, double altura) {
        super(x, y);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        double area = (base * altura)/2;
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = base * 3;
        return 0;
    }
}
