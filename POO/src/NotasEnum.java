public class NotasEnum {
    enum Color{
        ROJO,AZUL,VERDE,AMARILLO,NARANJA,NEGRO,BLANCO
    }

    public static void main(String[] args) {
        for (Color c : Color.values()){
            System.out.println("Color: " + c);
        }
    }
}
